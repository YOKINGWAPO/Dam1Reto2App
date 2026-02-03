import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class CartaComponentes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNombreComp;
	private Opcion1 opcion1;
	private JPanel panelImagen;
	private JLabel lblDescripcion;
	private JLabel lblEspecificacion;
	private JLabel lblDinero;
	private JButton btnAndir;
	private Image logo;
	private JLabel lblImagen;
	private EventosCartaComponentes eventosCartaComponentes;
	
	public CartaComponentes() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
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

		panelImagen = new JPanel();
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
				
						lblDescripcion = new JLabel("Descripcion");
						panel_2.add(lblDescripcion);
		
				lblEspecificacion = new JLabel("Especificaciones");
				panel_2.add(lblEspecificacion);
				GroupLayout gl_panel_1 = new GroupLayout(panel_1);
				gl_panel_1.setHorizontalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panelImagen, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
				);
				gl_panel_1.setVerticalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panelImagen, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
				);
				
				panelImagen.setLayout(new CardLayout(0, 0));
				panelImagen.add(lblImagen, "name_8896516453600");
				panel_1.setLayout(gl_panel_1);
		eventosCartaComponentes = new EventosCartaComponentes(this);
		
	}

	
	
	public JPanel getPanelPrincipal() {
		return this;
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

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

}
