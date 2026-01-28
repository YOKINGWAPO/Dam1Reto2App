import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventosMenu {
	private Menu menu;
	private int xMouse, yMouse;
	
	public EventosMenu(Menu menu) {
		this.menu= menu;
		menu.getBtnSalir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pulsado");
				System.exit(1);
				
			}
		});
		
		menu.getPanelMenu2().addMouseListener(new MouseAdapter() {
			
			  @Override
	            public void mousePressed(MouseEvent e) {
	                xMouse = e.getX();
	                yMouse = e.getY();
	            }
	        });
		
		menu.getPanelMenu2().addMouseMotionListener(new MouseAdapter() {
			
			 @Override
	            public void mouseDragged(MouseEvent e) {
	                int x = e.getXOnScreen();
	                int y = e.getYOnScreen();
	               
	                menu.setLocation(x - xMouse, y - yMouse);
	                
	            }
	        });
	}
	
}
