import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class Usuario {
	private int id;
	private String nombre;
	private String email;
	private String contrasenaHash;
	private int tipoUsuario;
	private boolean activo;
	private LocalDateTime fechaRegistro;
	
	public Usuario( int id, String nombre, String email, String contrasenaHash,int tipoUsuario,boolean activo,LocalDateTime fechaRegistro ) {
		this.id=id;
		this.nombre=nombre;
		this.email=email;
		this.contrasenaHash=contrasenaHash;
		this.tipoUsuario=tipoUsuario;
		this.activo=activo;
		this.fechaRegistro=fechaRegistro;
		

	}
	
}
