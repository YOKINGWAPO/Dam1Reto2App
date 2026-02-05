import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventoCartaCategoria {
	private CartaCategoria cartaCategoria;
	private Menu menu;
	public EventoCartaCategoria(CartaCategoria cartaCategoria,Menu menu) {
		this.cartaCategoria=cartaCategoria;
		this.menu=menu;
		
		cartaCategoria.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				menu.procesarProductos(cartaCategoria.getIdCategoria());
				//cartaCategoria.getMenu().procesarProductos(cartaCategoria.getIdCategoria());
               System.out.println(cartaCategoria.getIdCategoria());
            }
		});
	}
}
