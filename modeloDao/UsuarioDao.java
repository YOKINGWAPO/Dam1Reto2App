
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
		
		Nombre = eventosInicio.getInicio().getTxtUsuario().getText();
		Contrasena = String.valueOf(eventosInicio.getInicio().getTextPass().getPassword());
		System.out.println(Nombre);
		System.out.println(Contrasena);
		//setContentPane(menu);
		
		
				
		return 0;
	}
	
}
