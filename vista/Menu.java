import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelMenu;
	private JButton btnSalir;
	private EventosMenu eventosMenu;
	private JPanel PanelMenu2;

	public Menu(EventosInicio eventosInicio ) {
		setUndecorated(true); 
		setAlwaysOnTop(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 868, 532);
		PanelMenu = new JPanel();
		PanelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelMenu);
		PanelMenu.setLayout(new BorderLayout(0, 0));
		
		PanelMenu2 = new JPanel();
		PanelMenu2.setBackground(new Color(0, 204, 153));
		PanelMenu.add(PanelMenu2, BorderLayout.NORTH);
		PanelMenu2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		PanelMenu2.add(lblNewLabel_3, BorderLayout.WEST);
		
		btnSalir = new JButton("X");
		PanelMenu2.add(btnSalir, BorderLayout.EAST);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		
		JPanel PanelLateral = new JPanel();
		PanelLateral.setBackground(new Color(0, 102, 255));
		PanelMenu.add(PanelLateral, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("New label");
		PanelLateral.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		PanelLateral.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		PanelLateral.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		PanelMenu.add(panel_1, BorderLayout.CENTER);

		eventosMenu = new EventosMenu(this);
	}


	public JPanel getPanelMenu() {
		return PanelMenu;
	}


	public void setPanelMenu(JPanel panelMenu) {
		PanelMenu = panelMenu;
	}


	public JButton getBtnSalir() {
		return btnSalir;
	}


	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}


	public JPanel getPanelMenu2() {
		return PanelMenu2;
	}


	public void setPanelMenu2(JPanel panelMenu2) {
		PanelMenu2 = panelMenu2;
	}

}
