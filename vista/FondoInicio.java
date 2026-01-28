
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoInicio extends JPanel{
	
	Inicio inicio;
	private Image fondo, logo;
	public FondoInicio (Inicio inicio) {
		
		this.inicio=inicio;
		this.setBackground(Color.blue);
		
	
		cargarImagenes();
		
	}
	
	private void cargarImagenes() {
		fondo = new ImageIcon(getClass().getResource("fondoInicio.png")).getImage();
		logo = new ImageIcon(getClass().getResource("logo.png")).getImage();
		
		
	}

	@Override
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
		
	}
}
