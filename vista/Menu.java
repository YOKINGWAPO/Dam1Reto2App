import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;

public class Menu extends JPanel {


	private JPanel PanelMenu;
	private JButton btnSalir;
	private EventosMenu eventosMenu;
	private JPanel PanelMenu2;
	private App app;
	private JButton btnMax;
	private JButton btnOpcion5;
	private JButton btnOpcion4;
	private JButton btnOpcion3;
	private JButton btnOpcion2;
	private JButton btnOpcion1;
	
	private CardLayout layout = new CardLayout();
	JPanel panelContenido = new JPanel(layout);

	public Menu(App app) {
		this.app=app;

		setBounds(100, 100, 868, 532);
		PanelMenu = new JPanel();
		setLayout(new BorderLayout());
	
		PanelMenu.setLayout(new BorderLayout(0, 0));
		add(PanelMenu, BorderLayout.CENTER);
		
		PanelMenu2 = new JPanel();
		PanelMenu2.setBackground(new Color(0, 204, 153));
		PanelMenu.add(PanelMenu2, BorderLayout.NORTH);
		PanelMenu2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		PanelMenu2.add(lblNewLabel_3, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		PanelMenu2.add(panel, BorderLayout.EAST);
		
		btnMax = new JButton("[]");
		btnMax.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnMax);
		btnMax.setOpaque(false);
		btnMax.setContentAreaFilled(false);
		btnMax.setBorderPainted(false);
		
		btnSalir = new JButton("X");
		panel.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		
		JPanel PanelLateral = new JPanel();
		PanelLateral.setBackground(new Color(0, 102, 255));
		PanelMenu.add(PanelLateral, BorderLayout.WEST);
		PanelLateral.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PanelLateral.add(lblNewLabel, "6, 4");
		
		btnOpcion1 = new JButton("Opcion 1");
		btnOpcion1.setFont(new Font("Tahoma", Font.BOLD, 18));
		PanelLateral.add(btnOpcion1, "6, 8");
		
		btnOpcion2 = new JButton("Opcion 2");
		btnOpcion2.setFont(new Font("Tahoma", Font.BOLD, 18));
		PanelLateral.add(btnOpcion2, "6, 12");
		
		btnOpcion3 = new JButton("Opcion 3");
		btnOpcion3.setFont(new Font("Tahoma", Font.BOLD, 18));
		PanelLateral.add(btnOpcion3, "6, 16");
		
		btnOpcion4 = new JButton("Opcion 4");
		btnOpcion4.setFont(new Font("Tahoma", Font.BOLD, 18));
		PanelLateral.add(btnOpcion4, "6, 20");
		
		btnOpcion5 = new JButton("Opcion 5");
		btnOpcion5.setFont(new Font("Tahoma", Font.BOLD, 18));
		PanelLateral.add(btnOpcion5, "6, 24");
		
		
		PanelMenu.add(panelContenido, BorderLayout.CENTER);

		eventosMenu = new EventosMenu(this, app);
		
		 addPanel(new Opcion1(this), "Opcion1");
		 addPanel(new Opcion2(this), "Opcion2");
		 addPanel(new Opcion3(this), "Opcion3");
		 addPanel(new Opcion4(this), "Opcion4");
		 addPanel(new Opcion5(this), "Opcion5");
		 
		 mostrar("Opcion1");
	}

	private void addPanel(JPanel panel, String nombre) {
		System.out.println(nombre);
		System.out.println(panel);
		panelContenido.add(panel, nombre);
		
	}

	public void mostrar(String nombre) {
		 layout.show(panelContenido, nombre);
		 panelContenido.revalidate();
		 panelContenido.repaint();
		
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


	public JButton getBtnMax() {
		return btnMax;
	}


	public void setBtnMax(JButton btnMax) {
		this.btnMax = btnMax;
	}


	public JButton getBtnOpcion5() {
		return btnOpcion5;
	}


	public void setBtnOpcion5(JButton btnOpcion5) {
		this.btnOpcion5 = btnOpcion5;
	}


	public JButton getBtnOpcion4() {
		return btnOpcion4;
	}


	public void setBtnOpcion4(JButton btnOpcion4) {
		this.btnOpcion4 = btnOpcion4;
	}


	public JButton getBtnOpcion3() {
		return btnOpcion3;
	}


	public void setBtnOpcion3(JButton btnOpcion3) {
		this.btnOpcion3 = btnOpcion3;
	}


	public JButton getBtnOpcion2() {
		return btnOpcion2;
	}


	public void setBtnOpcion2(JButton btnOpcion2) {
		this.btnOpcion2 = btnOpcion2;
	}


	public JButton getBtnOpcion1() {
		return btnOpcion1;
	}


	public void setBtnOpcion1(JButton btnOpcion1) {
		this.btnOpcion1 = btnOpcion1;
	}

}
