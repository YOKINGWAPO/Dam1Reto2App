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
	private JLabel lblImagenCategoria;
	private JLabel lblCategoria;
	private int idCategoria;
	private EventoCartaCategoria eventoCartaCategoria;
	private Menu menu;
	public CartaCategoria(Menu menu) {
		this.menu=menu;
		setLayout(new BorderLayout(50, 50));
		
		lblCategoria = new JLabel("NombreCategoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblCategoria, BorderLayout.SOUTH);
		
		lblImagenCategoria = new JLabel("Imagen categoria");
		lblImagenCategoria.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblImagenCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblImagenCategoria, BorderLayout.CENTER);
		
		eventoCartaCategoria = new EventoCartaCategoria(this, menu);
	}
	
	public JLabel getLblImagenCategoria() {
		return lblImagenCategoria;
	}
	public void setLblImagenCategoria(JLabel lblImagenCategoria) {
		this.lblImagenCategoria = lblImagenCategoria;
	}
	public JLabel getLblCategoria() {
		return lblCategoria;
	}
	public void setLblCategoria(JLabel lblCategoria) {
		this.lblCategoria = lblCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
		
		System.out.println(idCategoria);
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
