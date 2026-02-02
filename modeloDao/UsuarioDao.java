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
		String Nombre;
		String Contrasena;
		String sql;
		int idUsuario;
		String nombreUsu;
		String email;
		String tipoUsu;
		int Activo;
		Timestamp fechaRegistro;
		ResultSet rs;

		PreparedStatement ps;
		sql="SELECT id_usuario FROM usuarios WHERE (nombre_usuario = ? OR email = ?) AND password_hash = ?";

		Nombre = eventosInicio.getInicio().getTxtUsuario().getText();
		Contrasena = String.valueOf(eventosInicio.getInicio().getTextPass().getPassword());
		//System.out.println(Nombre);
		//System.out.println(Contrasena);

		try (Connection cone = Conexion.conectar()){
			ps = cone.prepareStatement(sql);
			ps.setString(1, Nombre);
			ps.setString(2, Nombre);
			ps.setString(3, Contrasena);

			rs = ps.executeQuery(); 

			if (rs.next()) {

				idUsuario = rs.getInt("id_usuario");



				sql= "SELECT id_usuario, nombre_usuario, email, tipo_usuario, activo, fecha_registro FROM USUARIOS WHERE id_usuario = ?";

				try (Connection cone2 = Conexion.conectar()){

					ps = cone2.prepareStatement(sql);
					ps.setInt(1, idUsuario);


					rs = ps.executeQuery(); 
					if (rs.next()) {

						nombreUsu = rs.getString("nombre_usuario");
						email = rs.getString("email");
						tipoUsu = rs.getString("tipo_usuario");
						Activo = rs.getInt("activo");
						fechaRegistro = rs.getTimestamp("fecha_registro");
						usuario = new Usuario(idUsuario, nombreUsu, email, tipoUsu, Activo, fechaRegistro);
						if (Activo==0) {
							return null;
						}
						return usuario;
					}
					
					
				} catch (Exception e) {

				}
				//return rs.getInt("id_usuario");
			}
		} catch (Exception e) {

		}
		//setContentPane(menu);

		return null;
	}
	public Usuario datosUsuario() {

		return usuario;
	}

}
