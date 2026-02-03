import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;

public class EventosCartaComponentes {
	private CartaComponentes cartaComponentes;

	public EventosCartaComponentes(CartaComponentes cartaComponentes) {
		this.cartaComponentes=cartaComponentes;

		cartaComponentes.getPanelPrincipal().addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				
//				ImageIcon icon = new ImageIcon(getClass().getResource("logo.png"));
//				Image img = icon.getImage().getScaledInstance(
//						cartaComponentes.getPanelImagen().getWidth(), 
//						cartaComponentes.getPanelImagen().getHeight(),
//						Image.SCALE_SMOOTH   
//						);
//
//				cartaComponentes.getLblImagen().setIcon(new ImageIcon(img));

			}

		});


	}
}
