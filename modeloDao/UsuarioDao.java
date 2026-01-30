import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao {
	private Usuario usuario;
	private EventosInicio eventosInicio;
	private Conexion conexion;
	
	
	public UsuarioDao(EventosInicio eventosInicio){
		this.eventosInicio = eventosInicio;
		
	}
	
	public int comprobarLogin() {
		String Nombre;
		String Contrasena;
		String sql;
		
		sql="SELECT id_usuario FROM usuarios WHERE (nombre_usuario = ? OR email = ?) AND password_hash = ?";
		
		Nombre = eventosInicio.getInicio().getTxtUsuario().getText();
		Contrasena = String.valueOf(eventosInicio.getInicio().getTextPass().getPassword());
		//System.out.println(Nombre);
		//System.out.println(Contrasena);
		
		try (Connection cone = Conexion.conectar()){
			PreparedStatement ps = cone.prepareStatement(sql);
			ps.setString(1, Nombre);
		    ps.setString(2, Nombre);
		    ps.setString(3, Contrasena);
		    
		    ResultSet rs = ps.executeQuery(); 
	        
	        if (rs.next()) {
	            return rs.getInt("id_usuario");
	        }
		} catch (Exception e) {
			
		}
		//setContentPane(menu);
				
		return 0;
	}
	public Usuario datosUsuario() {
		
		return usuario;
	}
	
}
