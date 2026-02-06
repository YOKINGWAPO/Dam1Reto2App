import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EventosCartaComponentes {
	private CartaComponentes cartaComponentes;

	public EventosCartaComponentes(CartaComponentes cartaComponentes) {
		this.cartaComponentes=cartaComponentes;

		cartaComponentes.getPanelPrincipal().addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				
				JLabel lbl = cartaComponentes.getLblImagen();

				if (lbl != null && lbl.getIcon() instanceof ImageIcon) {

				    int ancho = cartaComponentes.getPanelImagen().getWidth();
				    int alto  = cartaComponentes.getPanelImagen().getHeight();

				    if (ancho > 0 && alto > 0) {

				        ImageIcon icon = (ImageIcon) lbl.getIcon();
				        Image imgEscalada = icon.getImage().getScaledInstance(
				                ancho,
				                alto,
				                Image.SCALE_SMOOTH
				        );

				        lbl.setIcon(new ImageIcon(imgEscalada));
				    }
				}

			}

		});


	}
}
