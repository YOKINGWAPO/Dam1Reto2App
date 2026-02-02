import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class App extends JFrame {
	private CardLayout layout = new CardLayout();
	private JPanel contenedor = new JPanel(layout);
	private Usuario usuario;
	private Menu menu;
	private Inicio inicio;
	private int Logeo;


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		Logeo=0;
		setUndecorated(true); 
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 861, 542);


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		System.out.println("Cargando Login");

		setContentPane(contenedor);
		inicio=new Inicio(this);
		menu=new Menu(this);
		
		addPanel(inicio, "login");

		addPanel(menu, "menu");   

		mostrar("login");

	}

	private void addPanel(JPanel panel, String nombre) {
		//System.out.println(nombre);
		//System.out.println(panel);
		contenedor.add(panel, nombre);

	}

	public void mostrar(String nombre) {
		layout.show(contenedor, nombre);
		contenedor.revalidate();
		contenedor.repaint();

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		gestionLogeo();
		
	}

	private void gestionLogeo() {
		
		Logeo=1;
		try {
			menu.procesarProductos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		menu.cargarPaneles();
		menu.ponerNombre();
		System.out.println(usuario.getNombre());
		
		
	}

}
