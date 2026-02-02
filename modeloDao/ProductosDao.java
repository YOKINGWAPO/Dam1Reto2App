import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProductosDao {
	//private Producto producto;
	private Conexion conexion;

	public ProductosDao() {
		//obtenerProductos();

	}

	public List obtenerProductos() {
		List<Producto> lista = new ArrayList<>();

		String sql= "SELECT * FROM COMPONENTES WHERE activo = 1";
		int  id_componente;
		int id_proveedor;
		int id_categoria;
		String nombre;
		String descripcion;
		String especificaciones;
		BigDecimal precio;
		int stock;
		Blob imagen;
		int activo;
		Timestamp fechaRegistro;
		
		try (Connection cone = Conexion.conectar()){
			PreparedStatement ps = cone.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				id_componente = rs.getInt("id_componente");
				id_proveedor = rs.getInt("id_proveedor");
				id_categoria = rs.getInt("id_categoria");
				nombre = rs.getString("nombre");
				descripcion = rs.getString("descripcion");
				especificaciones = rs.getString("especificaciones");
				precio = rs.getBigDecimal("precio");
				stock = rs.getInt("stock");
				imagen = rs.getBlob("imagen");
				activo = rs.getInt("activo");
				fechaRegistro = rs.getTimestamp("fecha_alta");
				
				Producto producto= new Producto(id_componente, id_proveedor, id_categoria, nombre, descripcion, especificaciones, precio, stock, imagen, activo, fechaRegistro);
				lista.add(producto);

			}
			System.out.println("Cargandoooo");
			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
