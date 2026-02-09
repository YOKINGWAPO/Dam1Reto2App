import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class CartaComponentes extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel lblNombreComp;
    private JPanel panelImagen;
    private JLabel lblDescripcion;
    private JLabel lblEspecificacion;
    private JLabel lblDinero;
    private JLabel lblImagen;

    private EventosCartaComponentes eventosCartaComponentes;
    private JLabel lblNewLabel;

    public CartaComponentes() {
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(12, 12, 12, 12)
        ));
        setLayout(new BorderLayout(10, 10));

        lblNombreComp = new JLabel("Título", SwingConstants.CENTER);
        lblNombreComp.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(lblNombreComp, BorderLayout.NORTH);

        JPanel center = new JPanel(new BorderLayout(8, 8));
        center.setOpaque(false);
        add(center, BorderLayout.CENTER);

        panelImagen = new JPanel(new BorderLayout());
        panelImagen.setBackground(new Color(245, 246, 248));
        panelImagen.setBorder(new LineBorder(new Color(230, 230, 230), 1, true));
        panelImagen.setPreferredSize(new Dimension(320, 170));

        lblImagen = new JLabel("", SwingConstants.CENTER);
        panelImagen.add(lblImagen, BorderLayout.CENTER);

        center.add(panelImagen, BorderLayout.NORTH);

        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        lblDescripcion = new JLabel("<html><div style='width:320px;'>Descripción</div></html>");
        lblDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblDescripcion.setForeground(new Color(60, 60, 60));

        lblEspecificacion = new JLabel("<html><div style='width:320px;'>Especificaciones</div></html>");
        lblEspecificacion.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblEspecificacion.setForeground(new Color(90, 90, 90));

        info.add(lblDescripcion);
        info.add(Box.createVerticalStrut(6));
        info.add(lblEspecificacion);

        center.add(info, BorderLayout.CENTER);

        JPanel footer = new JPanel(new BorderLayout());
        footer.setOpaque(false);
        add(footer, BorderLayout.SOUTH);

        JPanel price = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        price.setOpaque(false);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblPrecio.setForeground(new Color(110, 110, 110));

        lblDinero = new JLabel("0000€");
        lblDinero.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblDinero.setForeground(new Color(20, 20, 20));

        price.add(lblPrecio);
        price.add(lblDinero);

        footer.add(price, BorderLayout.WEST);
        
        lblNewLabel = new JLabel("€");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        price.add(lblNewLabel);

        eventosCartaComponentes = new EventosCartaComponentes(this);
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

	

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

	public EventosCartaComponentes getEventosCartaComponentes() {
		return eventosCartaComponentes;
	}

	public void setEventosCartaComponentes(EventosCartaComponentes eventosCartaComponentes) {
		this.eventosCartaComponentes = eventosCartaComponentes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

   
}
