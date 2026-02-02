import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventosInicio {
	private Inicio inicio;
	private UsuarioDao usuarioDao;
	private Usuario usuario;
	private Menu menu;
	private int xMouse, yMouse;
	private App app;
	private int idUsuario;

	public EventosInicio(Inicio inicio, App app) {
		usuarioDao = new UsuarioDao(this);

		this.app=app;
		//menu = new Menu(this);


		this.inicio = inicio;
		inicio.getBtnSalir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);

			}
		});//1

		inicio.getPanelMenu().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});

		inicio.getPanelMenu().addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();

				app.setLocation(x - xMouse, y - yMouse);

			}
		});

		inicio.getBtnInicio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				usuario = usuarioDao.comprobarLogin();
				if (usuario==null) {
					System.out.println("No Inicio de sesion");
					return;
				}
				//System.out.println(usuario.getNombre());
				//System.out.println(usuario.getFechaRegistro());
				app.setUsuario(usuario);
				

				app.mostrar("menu");
			}
		});


	}

	public Inicio getInicio() {
		return inicio;
	}

	public void setInicio(Inicio inicio) {
		this.inicio = inicio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
