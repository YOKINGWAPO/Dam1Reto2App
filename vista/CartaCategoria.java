import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CartaCategoria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblCategoria;
	private String tipoComponente;
	private EventoCartaCategoria eventoCartaCategoria;
	private Menu menu;
	private JPanel panelCategoria;
	private JLabel lblImagenCategoria;
	public CartaCategoria(Menu menu) {
		this.menu=menu;
		setLayout(new BorderLayout(50, 50));
		
		eventoCartaCategoria = new EventoCartaCategoria(this, menu);
		
		panelCategoria = new JPanel();
		add(panelCategoria, BorderLayout.CENTER);
		panelCategoria.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblImagenCategoria = new JLabel("Imagen categoria");
		lblImagenCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenCategoria.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelCategoria.add(lblImagenCategoria);
		
		lblCategoria = new JLabel("NombreCategoria");
		panelCategoria.add(lblCategoria);
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 20));
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public JLabel getLblImagenCategoria() {
		return lblImagenCategoria;
	}
	public void setLblImagenCategoria(JLabel lblImagenCategoria) {
		this.lblImagenCategoria = lblImagenCategoria;
	}
	
	
}
