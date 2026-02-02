import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.sql.Timestamp;

public class Usuario {
	private int id;
	private String nombre;
	private String email;
	private String contrasenaHash;
	private String tipoUsuario;
	private int activo;
	private Timestamp fechaRegistro;
	
	public Usuario( int id, String nombre, String email, String tipoUsuario, int activo,Timestamp fechaRegistro ) {
		this.id=id;
		this.nombre=nombre;
		this.email=email;
		this.contrasenaHash=contrasenaHash;
		this.tipoUsuario=tipoUsuario;
		this.activo=activo;
		this.fechaRegistro=fechaRegistro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
