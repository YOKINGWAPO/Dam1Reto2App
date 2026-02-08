import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

	ClienteDao(){

		obtenerClientes();
	}

	public List<Cliente> obtenerClientes() {
		List<Cliente> listaCliente = new ArrayList<>();
		String sql;
		int idCliente;
		String nombreClie;
		String apellidosClie;
		String emailClie;
		String telefonoClie;
		String direccionClie;
		Timestamp fechaRegistro;


		ResultSet rs;

		PreparedStatement ps;
		sql = "SELECT * FROM almitech.cliente";




		try (Connection cone = Conexion.conectar()){
			ps = cone.prepareStatement(sql);
			rs = ps.executeQuery(); 

			while (rs.next()) {

				idCliente = rs.getInt("id_cliente");
				nombreClie=rs.getString("nombre");
				apellidosClie=rs.getString("apellidos");
				emailClie=rs.getString("email");
				telefonoClie=rs.getString("telefono");
				direccionClie=rs.getString("direccion");
				fechaRegistro=rs.getTimestamp("fecha_registro");
				System.out.println(nombreClie);
				Cliente cliente =new Cliente(idCliente, nombreClie, apellidosClie, emailClie, telefonoClie, direccionClie, fechaRegistro);
				listaCliente.add(cliente);


			}
		} catch (Exception e) {

		}


		return listaCliente;

	}

	public int crearCliente(Cliente cliente) {

		String sql =
				"INSERT INTO almitech.cliente (nombre, apellidos, email, telefono, direccion) " +
				"VALUES (?, ?, ?, ?, ?)";

		try (Connection cone = Conexion.conectar();
				PreparedStatement ps = cone.prepareStatement(sql)) {

			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getTelefono());
			ps.setString(5, cliente.getDireccion());


			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	public int clientesTotales() {

	    String sql = "SELECT COUNT(*) AS total FROM almitech.cliente";

	    try (Connection cone = Conexion.conectar();
	         PreparedStatement ps = cone.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        if (rs.next()) {
	            return rs.getInt("total");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return 0;
	}
	public int clientesConPedidosJoin() {

	    String sql =
	        "SELECT COUNT(DISTINCT c.id_cliente) AS total " +
	        "FROM almitech.cliente c " +
	        "INNER JOIN almitech.configuracion p ON p.id_cliente = c.id_cliente";

	    try (Connection cone = Conexion.conectar();
	         PreparedStatement ps = cone.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        if (rs.next()) {
	            return rs.getInt("total");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return 0;
	}
	
	public int clientesSinPedidos() {

	    String sql =
	        "SELECT COUNT(*) AS total " +
	        "FROM almitech.cliente c " +
	        "WHERE NOT EXISTS ( " +
	        "   SELECT 1 FROM almitech.configuracion p " +
	        "   WHERE p.id_cliente = c.id_cliente" +
	        ")";

	    try (Connection cone = Conexion.conectar();
	         PreparedStatement ps = cone.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        if (rs.next()) {
	            return rs.getInt("total");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return 0;
	}
	
	public String ultimoCliente() {

	    String sql = "SELECT almitech.f_ultimo_cliente() AS nombre FROM dual";

	    try (Connection cone = Conexion.conectar();
	         PreparedStatement ps = cone.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        if (rs.next()) return rs.getString("nombre");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "";
	}
	
	


}
