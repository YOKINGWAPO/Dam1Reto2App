import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UsuarioDao {
	private Usuario usuario;
	private EventosInicio eventosInicio;
	private Conexion conexion;


	public UsuarioDao(EventosInicio eventosInicio){
		this.eventosInicio = eventosInicio;


	}

	public Usuario comprobarLogin() {

	    String sql =
	    "SELECT id_usuario, nombre_usuario, email, tipo_usuario, activo, fecha_registro " +
	    "FROM almitech.usuario " +
	    "WHERE (nombre_usuario = ? OR email = ?) AND password_hash = ?";

	    String nombre = eventosInicio.getInicio().getTxtUsuario().getText();
	    String contrasena = String.valueOf(
	            eventosInicio.getInicio().getTextPass().getPassword()
	    );

	    try (Connection cone = Conexion.conectar();
	         PreparedStatement ps = cone.prepareStatement(sql)) {

	        ps.setString(1, nombre);
	        ps.setString(2, nombre);
	        ps.setString(3, contrasena);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            int idUsuario = rs.getInt("id_usuario");
	            String nombreUsu = rs.getString("nombre_usuario");
	            String email = rs.getString("email");
	            String tipoUsu = rs.getString("tipo_usuario");
	            int activo = rs.getInt("activo");
	            Timestamp fechaRegistro = rs.getTimestamp("fecha_registro");

	            if (activo == 0) {
	                return null;
	            }

	            return new Usuario(idUsuario, nombreUsu, email, tipoUsu, activo, fechaRegistro);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}

	public Usuario datosUsuario() {

		return usuario;
	}

}
