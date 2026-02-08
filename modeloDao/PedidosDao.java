import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

public class PedidosDao {
	PedidosDao(){

	}
	public int totalPedidosCliente(int idCliente) {

		String sql =
				"SELECT almitech.f_total_pedidos_cliente(?) AS total FROM dual";

		try (Connection cone = Conexion.conectar();
				PreparedStatement ps = cone.prepareStatement(sql)) {

			ps.setInt(1, idCliente);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("total");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public List<Pedido> obtenerPedidosCliente(int idCliente) {

		List<Pedido> lista = new ArrayList<>();

		String sql;
		ResultSet rs;
		CallableStatement cs;

		sql = "{ CALL almitech.p_pedidos_cliente_validado(?, ?) }";

		try (Connection cone = Conexion.conectar()) {

			cs = cone.prepareCall(sql);
			cs.setInt(1, idCliente);
			cs.registerOutParameter(2, OracleTypes.CURSOR);

			cs.execute();

			rs = (ResultSet) cs.getObject(2);

			Pedido pedidoActual = null;
			int idConfigActual = -1;

			while (rs.next()) {


				if (rs.getObject("id_configuracion") == null) {
					rs.close();
					cs.close();
					return new ArrayList<>();
				}

				int idConfig = rs.getInt("id_configuracion");


				if (pedidoActual == null || idConfig != idConfigActual) {

					pedidoActual = new Pedido(
							idConfig,
							rs.getInt("id_cliente"),
							rs.getString("nombre_config"),
							rs.getString("descripcion"),
							rs.getString("estado"),
							rs.getTimestamp("fecha_creacion")
							);

					lista.add(pedidoActual);
					idConfigActual = idConfig;
				}


				if (rs.getObject("id_detalle") != null) {

					String nombre = rs.getString("nombre_componente");
					System.out.println(nombre);
					DetallePedido detalle = new DetallePedido(
							rs.getInt("id_detalle"),
							idConfig,
							rs.getInt("id_componente"),
							nombre,
							rs.getInt("cantidad"),
							rs.getDouble("precio_unitario")
							);

					pedidoActual.getDetalles().add(detalle);
				}
			}

			rs.close();
			cs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}



	public int crearPedidoConDetalles(Pedido pedido) {

        String sqlPedido = "{ call almitech.p_crear_pedido(?, ?, ?, ?, ?) }";
        String sqlDetalle = "{ call almitech.p_crear_detalle_pedido(?, ?, ?, ?) }";

        CallableStatement csPedido;
        CallableStatement csDetalle;

        try (Connection cone = Conexion.conectar()) {

            cone.setAutoCommit(false);

            // 1) crear pedido y obtener id_configuracion
            csPedido = cone.prepareCall(sqlPedido);
            csPedido.setInt(1, pedido.getIdCliente());
            csPedido.setString(2, pedido.getNombreConfig());
            csPedido.setString(3, pedido.getDescripcion());
            csPedido.setString(4, pedido.getEstado());
            csPedido.registerOutParameter(5, Types.INTEGER);

            csPedido.execute();

            int idConfig = csPedido.getInt(5);
            csPedido.close();

            if (idConfig <= 0) {
                cone.rollback();
                return 0;
            }

            // 2) insertar detalles
            for (int i = 0; i < pedido.getDetalles().size(); i++) {

                DetallePedido d = pedido.getDetalles().get(i);

                csDetalle = cone.prepareCall(sqlDetalle);
                csDetalle.setInt(1, idConfig);
                csDetalle.setInt(2, d.getIdComponente());
                csDetalle.setInt(3, d.getCantidad());
                csDetalle.setDouble(4, d.getPrecioUnitario());

                csDetalle.execute();
                csDetalle.close();
            }

            cone.commit();
            return idConfig;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

}
