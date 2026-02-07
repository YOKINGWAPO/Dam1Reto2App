import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventosOpcion3 {
	private Opcion3 opcion3;
	public EventosOpcion3(Opcion3 opcion3) {
		this.opcion3=opcion3;
		
		opcion3.getBtnCrearNuevoCliente().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				opcion3.getMenu().mostrar("crearCliente");
				
			}
		});
		
	}
}
