import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDao {
	CategoriasDao(){
		//obtenerCategorias();
	}

	public List<Categoria>  obtenerCategorias() {

		String sql;
		ResultSet rs;
		PreparedStatement ps;

		List<Categoria> listaCategoria = new ArrayList<>();
		
		int id_categoria;
		String nombre;
		String descripcion;
		
		Blob imagen;
		byte[] imgBytes;

		try (Connection cone = Conexion.conectar()){
			sql = "SELECT * FROM CATEGORIAS";
			ps = cone.prepareStatement(sql);
			rs = ps.executeQuery(); 

			while (rs.next()) {
				id_categoria=rs.getInt("id_categoria");
				nombre=rs.getString("nombre");
				descripcion=rs.getString("descripcion");
				imagen=rs.getBlob("imagen");
				
				if (imagen != null) {
                    imgBytes = imagen.getBytes(1, (int) imagen.length());
                } else {
                    imgBytes = new byte[0]; 
                }
				
				Categoria categoria= new Categoria(id_categoria,nombre,descripcion,imgBytes);
				//System.out.println(id_categoria);
				listaCategoria.add(categoria);
			}

			return listaCategoria;
		} catch (SQLException e) {
			e.printStackTrace();
			return listaCategoria;

		}

	}
}
