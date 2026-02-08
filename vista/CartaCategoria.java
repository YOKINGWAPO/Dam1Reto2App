import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class CartaCategoria extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel lblCategoria;
    private String tipoComponente;
    private EventoCartaCategoria eventoCartaCategoria;
    private Menu menu;
    private JPanel panelCategoria;
    private JLabel lblImagenCategoria;

    public CartaCategoria(Menu menu) {
        this.menu = menu;

        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(12, 12, 12, 12)
        ));
        setLayout(new BorderLayout(8, 8));

        eventoCartaCategoria = new EventoCartaCategoria(this, menu);

        panelCategoria = new JPanel(new BorderLayout(6, 6));
        panelCategoria.setOpaque(false);
        add(panelCategoria, BorderLayout.CENTER);

        JPanel panelImagen = new JPanel(new BorderLayout());
        panelImagen.setBackground(new Color(245, 246, 248));
        panelImagen.setBorder(new LineBorder(new Color(230, 230, 230), 1, true));
        panelImagen.setPreferredSize(new Dimension(320, 160));

        lblImagenCategoria = new JLabel("", SwingConstants.CENTER);
        lblImagenCategoria.setFont(new Font("SansSerif", Font.BOLD, 16));
        panelImagen.add(lblImagenCategoria, BorderLayout.CENTER);

        lblCategoria = new JLabel("NombreCategoria", SwingConstants.CENTER);
        lblCategoria.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblCategoria.setForeground(new Color(25, 25, 25));
        lblCategoria.setBorder(new EmptyBorder(6, 0, 0, 0));

        panelCategoria.add(panelImagen, BorderLayout.CENTER);
        panelCategoria.add(lblCategoria, BorderLayout.SOUTH);
    }

	public JLabel getLblCategoria() {
		return lblCategoria;
	}

	public void setLblCategoria(JLabel lblCategoria) {
		this.lblCategoria = lblCategoria;
	}

	public String getTipoComponente() {
		return tipoComponente;
	}

	public void setTipoComponente(String tipoComponente) {
		this.tipoComponente = tipoComponente;
	}

	public EventoCartaCategoria getEventoCartaCategoria() {
		return eventoCartaCategoria;
	}

	public void setEventoCartaCategoria(EventoCartaCategoria eventoCartaCategoria) {
		this.eventoCartaCategoria = eventoCartaCategoria;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public JPanel getPanelCategoria() {
		return panelCategoria;
	}

	public void setPanelCategoria(JPanel panelCategoria) {
		this.panelCategoria = panelCategoria;
	}

	public JLabel getLblImagenCategoria() {
		return lblImagenCategoria;
	}

	public void setLblImagenCategoria(JLabel lblImagenCategoria) {
		this.lblImagenCategoria = lblImagenCategoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
