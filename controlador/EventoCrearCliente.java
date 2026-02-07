import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class EventoCrearCliente {
	private CrearCliente crearCliente;
	private Cliente cliente;
	private ClienteDao clienteDao;

	EventoCrearCliente(CrearCliente crearCliente){
		this.crearCliente = crearCliente;


		eventoCampos();
		eventoBoton();
	}

	private void eventoCampos() {


		crearCliente.getTextNombreCliente().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(crearCliente.getTextNombreCliente().getText().trim().equals("")) {
					crearCliente.getTextNombreCliente().setBackground(Color.PINK);
				} else {
					crearCliente.getTextNombreCliente().setBackground(Color.WHITE);
				}
			}
		});


		crearCliente.getTextApellidosCliente().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(crearCliente.getTextApellidosCliente().getText().trim().equals("")) {
					crearCliente.getTextApellidosCliente().setBackground(Color.PINK);
				} else {
					crearCliente.getTextApellidosCliente().setBackground(Color.WHITE);
				}
			}
		});


		crearCliente.getTextEmailCliente().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(crearCliente.getTextEmailCliente().getText().trim().equals("")) {
					crearCliente.getTextEmailCliente().setBackground(Color.PINK);
				} else {
					crearCliente.getTextEmailCliente().setBackground(Color.WHITE);
				}
			}
		});


		crearCliente.getTextDireccionCliente().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(crearCliente.getTextDireccionCliente().getText().trim().equals("")) {
					crearCliente.getTextDireccionCliente().setBackground(Color.PINK);
				} else {
					crearCliente.getTextDireccionCliente().setBackground(Color.WHITE);
				}
			}
		});


		crearCliente.getTextTelefonoCliente().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && !Character.isISOControl(c)) {
					e.consume();
				}
			}
			public void keyReleased(KeyEvent e) {
				if(crearCliente.getTextTelefonoCliente().getText().trim().equals("")) {
					crearCliente.getTextTelefonoCliente().setBackground(Color.PINK);
				} else {
					crearCliente.getTextTelefonoCliente().setBackground(Color.WHITE);
				}
			}
		});
	}

	private void eventoBoton() {
		crearCliente.getBtnNewButton().addActionListener(e -> {
			String nombre;
			String apellidos;
			String email;
			String telefono;
			String direccion;
			int insertado;
			if(

					crearCliente.getTextNombreCliente().getText().trim().equals("") ||
					crearCliente.getTextApellidosCliente().getText().trim().equals("") ||
					crearCliente.getTextEmailCliente().getText().trim().equals("") ||
					crearCliente.getTextTelefonoCliente().getText().trim().equals("") ||
					crearCliente.getTextDireccionCliente().getText().trim().equals("")
					) {
				JOptionPane.showMessageDialog(crearCliente, "Rellena todos los campos");
				return;
			}
			nombre=crearCliente.getTextNombreCliente().getText().trim();
			apellidos=crearCliente.getTextApellidosCliente().getText().trim(); 
			email=crearCliente.getTextEmailCliente().getText().trim();
			telefono=crearCliente.getTextTelefonoCliente().getText().trim();
			direccion=crearCliente.getTextDireccionCliente().getText().trim();


			clienteDao =new ClienteDao();
			cliente = new Cliente(nombre,apellidos,email,telefono,direccion);

			insertado=clienteDao.crearCliente(cliente);
			if (insertado==0) {
				JOptionPane.showMessageDialog(crearCliente, "Error al insertar cliente");
				return;
			}
			JOptionPane.showMessageDialog(crearCliente, "Cliente creado");
			crearCliente.getMenu().getOpcion3().cargarClientesEnTabla();
			crearCliente.getMenu().mostrar("Opcion3");

		});
	}
}
