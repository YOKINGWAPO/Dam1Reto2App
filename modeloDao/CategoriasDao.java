import java.io.IOException;
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
		
		
		String nombre;
		byte[] imgBytes;

		try (Connection cone = Conexion.conectar()){
			sql = "SELECT DISTINCT tipo_componente\r\n"
					+ "FROM almitech.componentes\r\n"
					+ "ORDER BY tipo_componente";
			ps = cone.prepareStatement(sql);
			rs = ps.executeQuery(); 

			while (rs.next()) {
				
				nombre=rs.getString("tipo_componente");
				
				//imagen=rs.getBlob("imagen");
				 imgBytes = new byte[0]; 
				try {
					if ("GPU".equals(nombre)) {
					    imgBytes = getClass().getResourceAsStream("gpu.png").readAllBytes();

					} else if ("CPU".equals(nombre)) {
					    imgBytes = getClass().getResourceAsStream("cpu.png").readAllBytes();

					} else if ("PLACA_BASE".equals(nombre)) {
					    imgBytes = getClass().getResourceAsStream("placaBase.png").readAllBytes();

					} else if ("RAM".equals(nombre)) {
					    imgBytes = getClass().getResourceAsStream("ram.png").readAllBytes();

					} else if ("ALMACENAMIENTO".equals(nombre)) {
					    imgBytes = getClass().getResourceAsStream("ssd.png").readAllBytes();

					} else if ("PSU".equals(nombre)) {
					    imgBytes = getClass().getResourceAsStream("psu.png").readAllBytes();

					} else if ("CAJA".equals(nombre)) {
					    imgBytes = getClass().getResourceAsStream("caja.png").readAllBytes();

					} else if ("MONITOR".equals(nombre)) {
					    imgBytes = getClass().getResourceAsStream("monitor.png").readAllBytes();

					} else if ("CONSOLA".equals(nombre)) {
					    imgBytes = getClass().getResourceAsStream("consola.png").readAllBytes();

					} else if ("CASCOS".equals(nombre)) {
					    imgBytes = getClass().getResourceAsStream("cascos.png").readAllBytes();

					} else {
					    imgBytes = new byte[0];
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
                   
               
				
				Categoria categoria= new Categoria(nombre,imgBytes);
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
