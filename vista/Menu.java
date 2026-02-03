import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
	private Opcion1 opcion1;
	private Opcion2 opcion2;
	private Opcion3 opcion3;
	private Opcion4 opcion4;
	private Opcion5 opcion5;
	private int categoria;
	
	private ProductosDao productosDao;
	
	List<Producto> lista = new ArrayList<>();

	private CardLayout layout = new CardLayout();
	JPanel panelContenido = new JPanel(layout);
	private JLabel lblNombreUsu;

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

		lblNombreUsu = new JLabel("Usuario");
		lblNombreUsu.setHorizontalAlignment(SwingConstants.CENTER);

		PanelMenu2.add(lblNombreUsu, BorderLayout.WEST);

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
		PanelLateral.setBackground(new Color(140, 145, 145));
		PanelMenu.add(PanelLateral, BorderLayout.WEST);
		FormLayout fl_PanelLateral = new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,},
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
				FormSpecs.DEFAULT_ROWSPEC,});
		PanelLateral.setLayout(fl_PanelLateral);
				
						JLabel lblNewLabel = new JLabel("MENU");
						lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						PanelLateral.add(lblNewLabel, "2, 4, 7, 1");
				
						btnOpcion1 = new JButton("Componentes");
						btnOpcion1.setFont(new Font("Tahoma", Font.BOLD, 16));
						PanelLateral.add(btnOpcion1, "2, 8, 7, 1");
		
				btnOpcion2 = new JButton("Ordenadores");
				btnOpcion2.setFont(new Font("Tahoma", Font.BOLD, 16));
				PanelLateral.add(btnOpcion2, "2, 12, 7, 1");
		
				btnOpcion3 = new JButton("Perifericos");
				btnOpcion3.setFont(new Font("Tahoma", Font.BOLD, 16));
				PanelLateral.add(btnOpcion3, "2, 16, 7, 1");
		
				btnOpcion4 = new JButton("Consolas");
				btnOpcion4.setFont(new Font("Tahoma", Font.BOLD, 16));
				PanelLateral.add(btnOpcion4, "2, 20, 7, 1");
		
				btnOpcion5 = new JButton("Monitores");
				btnOpcion5.setFont(new Font("Tahoma", Font.BOLD, 16));
				PanelLateral.add(btnOpcion5, "2, 24, 7, 1");


		PanelMenu.add(panelContenido, BorderLayout.CENTER);



		eventosMenu = new EventosMenu(this, app);

		


		




	}
	public void cargarPaneles() {
		opcion1=new Opcion1(this);
		opcion2=new Opcion2(this);
		opcion3=new Opcion3(this);
		opcion4=new Opcion4(this);
		opcion5=new Opcion5(this);
		
		addPanel(opcion1, "Opcion1");
		addPanel(opcion2, "Opcion2");
		addPanel(opcion3, "Opcion3");
		addPanel(opcion4, "Opcion4");
		addPanel(opcion5, "Opcion5");

		mostrar("Opcion1");
	}
	public void procesarProductos() {
		productosDao = new ProductosDao();
		lista=productosDao.obtenerProductos(categoria);
	}
	public void ponerNombre(){
		lblNombreUsu.setText(app.getUsuario().getNombre());
	}
	private void addPanel(JPanel panel, String nombre) {
		//System.out.println(nombre);
		//System.out.println(panel);
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

	public JLabel getLblNombreUsu() {
		return lblNombreUsu;
	}

	public void setLblNombreUsu(JLabel lblNombreUsu) {
		this.lblNombreUsu = lblNombreUsu;
	}
	public List<Producto> getLista() {
		return lista;
	}
	public void setLista(List<Producto> lista) {
		this.lista = lista;
	}

}
