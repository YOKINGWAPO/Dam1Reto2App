import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.Image;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelInicio;
	private JTextField txtUsuario;
	private JPasswordField textPass;
	private JButton btnInicio;
	private EventosInicio EventosInicio;
	private JPanel panelMenu;
	private JButton btnSalir;
	private Image imagen;
	private FondoInicio fondoInicio;
	private Conexion conexion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		
		setUndecorated(true); 
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 861, 542);
		
		PanelInicio = new JPanel();
		PanelInicio.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelInicio);
		PanelInicio.setLayout(null);
		
		btnInicio = new JButton("Iniciar Sesion");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInicio.setBounds(290, 381, 321, 47);
		PanelInicio.add(btnInicio);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Usuario");
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtUsuario.setBounds(290, 231, 321, 39);
		PanelInicio.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		textPass = new JPasswordField();
		textPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		textPass.setBounds(290, 306, 321, 39);
		PanelInicio.add(textPass);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(284, 52, 295, 207);
		PanelInicio.add(lblLogo);
		//lblLogo.setIcon(new ImageIcon(getClass().getResource("logo.png")));
		ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
		Image img = icon.getImage().getScaledInstance(
		    lblLogo.getWidth(), 
		    lblLogo.getHeight(),
		    Image.SCALE_SMOOTH   
		);

		lblLogo.setIcon(new ImageIcon(img));

		
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 861, 53);
		PanelInicio.add(panelMenu);
		panelMenu.setLayout(null);
		panelMenu.setOpaque(false);

		
		btnSalir = new JButton("X");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalir.setBounds(784, 0, 77, 53);
		panelMenu.add(btnSalir);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		

		
		 
		EventosInicio = new EventosInicio(this);
		
		fondoInicio = new FondoInicio(this);
		fondoInicio.setBounds(0, 0, 861, 542);
		PanelInicio.add(fondoInicio);
		
		conexion=new Conexion();
		
		
		
		
	}
	
	

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JPanel getPanelMenu() {
		return panelMenu;
	}

	public void setPanelMenu(JPanel panelMenu) {
		this.panelMenu = panelMenu;
	}

	public JButton getBtnInicio() {
		return btnInicio;
	}

	public void setBtnInicio(JButton btnInicio) {
		this.btnInicio = btnInicio;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getTextPass() {
		return textPass;
	}

	public void setTextPass(JPasswordField textPass) {
		this.textPass = textPass;
	}

	public JPanel getPanelInicio() {
		return PanelInicio;
	}

	public void setPanelInicio(JPanel panelInicio) {
		PanelInicio = panelInicio;
	}
}
