import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

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
//		menu.getBtnOpcion2().addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("2");
//				menu.mostrar("Opcion2");
//			}
//		});
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
	
//	public void estilizarBoton(JButton btn) {
//	    btn.setFont(new Font("Tahoma", Font.BOLD, 20));
//	    btn.setBackground(new Color(60, 63, 65));
//	    btn.setForeground(Color.WHITE);
//	    btn.setFocusPainted(false);
//	    btn.setBorderPainted(false);
//	    btn.setOpaque(true);
//	    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//	    
//	    btn.addMouseListener(new java.awt.event.MouseAdapter() {
//	        @Override
//	        public void mouseEntered(java.awt.event.MouseEvent e) {
//	            btn.setBackground(new Color(80, 83, 85));
//	        }
//
//	        @Override
//	        public void mouseExited(java.awt.event.MouseEvent e) {
//	            btn.setBackground(new Color(60, 63, 65));
//	        }
//	    });
//	}
	
	

}
