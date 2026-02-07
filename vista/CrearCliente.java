import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CrearCliente extends JPanel{
	private Menu menu;
	private ClienteDao clienteDao;
	private JPanel panelAbjo;
	private JPanel panel;
	private JTextField textNombreCliente;
	private JTextField textApellidosCliente;
	private JTextField textDireccionCliente;
	private JTextField textTelefonoCliente;
	private JTextField textEmailCliente;
	private JButton btnNewButton;
	
	private EventoCrearCliente eventoCrearCliente;
	CrearCliente(Menu menu){
		this.menu=menu;
		setLayout(new BorderLayout(0, 0));
		
		panelAbjo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAbjo.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panelAbjo, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Crear");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelAbjo.add(btnNewButton);
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		textNombreCliente = new JTextField();
		textNombreCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(textNombreCliente);
		textNombreCliente.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		textApellidosCliente = new JTextField();
		textApellidosCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(textApellidosCliente);
		textApellidosCliente.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);
		
		textEmailCliente = new JTextField();
		textEmailCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(textEmailCliente);
		textEmailCliente.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefono");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
		
		textTelefonoCliente = new JTextField();
		textTelefonoCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(textTelefonoCliente);
		textTelefonoCliente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Direccion");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		textDireccionCliente = new JTextField();
		textDireccionCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(textDireccionCliente);
		textDireccionCliente.setColumns(10);
		
		eventoCrearCliente = new EventoCrearCliente(this);
		
		
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public ClienteDao getClienteDao() {
		return clienteDao;
	}
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	public JPanel getPanelAbjo() {
		return panelAbjo;
	}
	public void setPanelAbjo(JPanel panelAbjo) {
		this.panelAbjo = panelAbjo;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JTextField getTextNombreCliente() {
		return textNombreCliente;
	}
	public void setTextNombreCliente(JTextField textNombreCliente) {
		this.textNombreCliente = textNombreCliente;
	}
	public JTextField getTextApellidosCliente() {
		return textApellidosCliente;
	}
	public void setTextApellidosCliente(JTextField textApellidosCliente) {
		this.textApellidosCliente = textApellidosCliente;
	}
	public JTextField getTextDireccionCliente() {
		return textDireccionCliente;
	}
	public void setTextDireccionCliente(JTextField textDireccionCliente) {
		this.textDireccionCliente = textDireccionCliente;
	}
	public JTextField getTextTelefonoCliente() {
		return textTelefonoCliente;
	}
	public void setTextTelefonoCliente(JTextField textTelefonoCliente) {
		this.textTelefonoCliente = textTelefonoCliente;
	}
	public JTextField getTextEmailCliente() {
		return textEmailCliente;
	}
	public void setTextEmailCliente(JTextField textEmailCliente) {
		this.textEmailCliente = textEmailCliente;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
}
