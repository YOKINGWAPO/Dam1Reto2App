import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	 private static String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
     private static String user = "conexion";
     private static String password = "Almi123";
     
    public Conexion() {
       
        
        comprobarConexion();
        
    }
    
    
	public void comprobarConexion() {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conectado");
            } else {
                System.out.println("No Conectado");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
		
	}
	
	public static Connection conectar() throws SQLException {
       
			return DriverManager.getConnection(url, user, password);
		
    }
	
    
    
}
