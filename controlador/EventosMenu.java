import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventosMenu {
	private Menu menu;
	private int xMouse, yMouse;
	private App app;

	public EventosMenu(Menu menu, App app) {
		this.app=app;
		this.menu= menu;

		menu.getBtnSalir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Pulsado");
				System.exit(1);

			}
		});

		menu.getPanelMenu2().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// System.out.println("Pulsando");
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});

		menu.getPanelMenu2().addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				//System.out.println("Moviendo");
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();

				app.setLocation(x - xMouse, y - yMouse);

			}
		});

		menu.getBtnMax().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (app.getExtendedState() == Frame.MAXIMIZED_BOTH) {
					app.setExtendedState(Frame.NORMAL); 
				} else {
					app.setExtendedState(Frame.MAXIMIZED_BOTH); 
				}

			}
		});

		menu.getBtnOpcion1().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("6");
				menu.mostrar("Opcion6");

			}
		});
		menu.getBtnOpcion2().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("2");
				menu.mostrar("Opcion2");
			}
		});
		menu.getBtnOpcion3().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("3");
				menu.mostrar("Opcion3");

			}
		});
		menu.getBtnOpcion4().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("7");
				menu.mostrar("Opcion7");

			}
		});
		menu.getBtnOpcion5().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("5");
				menu.mostrar("Opcion5");

			}
		});
	}
	
	

}
