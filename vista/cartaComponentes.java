import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;

public class cartaComponentes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNombreComp;
	private Opcion1 opcion1;
	private JPanel panelImagen;
	private JLabel lblDescripcion;
	private JLabel lblEspecificacion;
	private JLabel lblDinero;
	private JButton btnAndir;
	
	public cartaComponentes() {
		setLayout(new BorderLayout(0, 0));
		
		lblNombreComp = new JLabel("Titulo");
		lblNombreComp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombreComp.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNombreComp, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblPrecio);
		
		lblDinero = new JLabel("0000€");
		lblDinero.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblDinero);
		
		btnAndir = new JButton("Añadir");
		panel.add(btnAndir);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		panelImagen = new JPanel();
		panel_1.add(panelImagen);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblDescripcion = new JLabel("Descripcion");
		panel_2.add(lblDescripcion);
		
		lblEspecificacion = new JLabel("Especificaciones");
		panel_2.add(lblEspecificacion);
		

	}

	public JLabel getLblNombreComp() {
		return lblNombreComp;
	}

	public void setLblNombreComp(JLabel lblNombreComp) {
		this.lblNombreComp = lblNombreComp;
	}

	public JPanel getPanelImagen() {
		return panelImagen;
	}

	public void setPanelImagen(JPanel panelImagen) {
		this.panelImagen = panelImagen;
	}

	public JLabel getLblDescripcion() {
		return lblDescripcion;
	}

	public void setLblDescripcion(JLabel lblDescripcion) {
		this.lblDescripcion = lblDescripcion;
	}

	public JLabel getLblEspecificacion() {
		return lblEspecificacion;
	}

	public void setLblEspecificacion(JLabel lblEspecificacion) {
		this.lblEspecificacion = lblEspecificacion;
	}

	public JLabel getLblDinero() {
		return lblDinero;
	}

	public void setLblDinero(JLabel lblDinero) {
		this.lblDinero = lblDinero;
	}

	public JButton getBtnAndir() {
		return btnAndir;
	}

	public void setBtnAndir(JButton btnAndir) {
		this.btnAndir = btnAndir;
	}

}
