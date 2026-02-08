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

		opcion3.getBtnVerPedidosCliente().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				int filaSeleccionada = opcion3.getTablaClientes().getSelectedRow();

				int idCliente = (int) opcion3.getModel().getValueAt(filaSeleccionada, 0);
				//opcion3.setIdUsuario(idCliente);
				opcion3.getMenu().getOpcion4().setIdCliente(idCliente);
				opcion3.getMenu().mostrar("Opcion4");
			}
		});
		opcion3.getBtnCrearPedido().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = opcion3.getTablaClientes().getSelectedRow();

				int idCliente = (int) opcion3.getModel().getValueAt(filaSeleccionada, 0);
				
				opcion3.getMenu().getOpcion7().setIdCliente(idCliente);
				opcion3.getMenu().mostrar("Opcion7");
				
			}
		});

	}
}
