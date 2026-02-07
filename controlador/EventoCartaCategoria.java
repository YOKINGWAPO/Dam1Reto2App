import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EventoCartaCategoria {
	private CartaCategoria cartaCategoria;
	private Menu menu;
	public EventoCartaCategoria(CartaCategoria cartaCategoria,Menu menu) {
		this.cartaCategoria=cartaCategoria;
		this.menu=menu;

		cartaCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.procesarProductos(cartaCategoria.getTipoComponente());
				//cartaCategoria.getMenu().procesarProductos(cartaCategoria.getIdCategoria());
				//System.out.println(cartaCategoria.getTipoComponente());
			}
		});

//		cartaCategoria.getPanelCategoria().addComponentListener(new ComponentAdapter() {
//
//			@Override
//			public void componentResized(ComponentEvent e) {
//
//				JLabel lbl = cartaCategoria.getLblImagenCategoria();
//
//				if (lbl != null && lbl.getIcon() instanceof ImageIcon) {
//
//					int ancho = cartaCategoria.getLblImagenCategoria().getWidth();
//					int alto  = cartaCategoria.getLblImagenCategoria().getHeight();
//
//					if (ancho > 0 && alto > 0) {
//
//						ImageIcon icon = (ImageIcon) lbl.getIcon();
//						Image imgEscalada = icon.getImage().getScaledInstance(
//								ancho,
//								alto,
//								Image.SCALE_SMOOTH
//								);
//
//						lbl.setIcon(new ImageIcon(imgEscalada));
//					}
//				}
//
//			}
//
//		});


	}

}

