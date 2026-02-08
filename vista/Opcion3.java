import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;

public class Opcion3 extends JPanel {

    private Menu menu;
    private ClienteDao clienteDao;
    private List<Cliente> listaCliente = new ArrayList<>();
    private JTable tablaClientes;
    private DefaultTableModel model;
    private JButton btnCrearNuevoCliente;
    private JButton btnVerPedidosCliente;
    private EventosOpcion3 eventosOpcion3;
    private JLabel lblClienteTotales;
    private JLabel lblNewLabel;
    private JLabel lblClienteConPedidos;
    private JLabel lblClientesSinPedido;
    private JLabel lblNewLabel_1;
    private JLabel lblUltimoClienteRegistrado;
    private int idUsuario;
    private JButton btnCrearPedido;

    public Opcion3(Menu menu) {

        this.menu = menu;
        setLayout(new BorderLayout(0, 0));

        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTitulo = new JLabel("Clientes:");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblTitulo);
        add(panelTop, BorderLayout.NORTH);

        lblClienteTotales = new JLabel("totales");
        lblClienteTotales.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblClienteTotales);

        JSeparator separator = new JSeparator();
        panelTop.add(separator);

        lblNewLabel = new JLabel("Clientes con pedidos:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblNewLabel);

        lblClienteConPedidos = new JLabel("0");
        lblClienteConPedidos.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblClienteConPedidos);

        JLabel lblClientesSinPedidos = new JLabel("Clientes Sin pedidos:");
        lblClientesSinPedidos.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblClientesSinPedidos);

        lblClientesSinPedido = new JLabel("0");
        lblClientesSinPedido.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblClientesSinPedido);

        lblNewLabel_1 = new JLabel("Ultimo Cliente Registrado:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblNewLabel_1);

        lblUltimoClienteRegistrado = new JLabel("ultimo");
        lblUltimoClienteRegistrado.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblUltimoClienteRegistrado);

      
        String[] columnas = { "ID", "Nombre", "Apellidos", "Email", "Teléfono", "Dirección" };
        model = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaClientes = new JTable(model);
        tablaClientes.setRowHeight(26);
        tablaClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tablaClientes.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
        tablaClientes.getTableHeader().setReorderingAllowed(false);

       
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);

        tablaClientes.getColumnModel().getColumn(0).setCellRenderer(center); 
        tablaClientes.getColumnModel().getColumn(4).setCellRenderer(center); 
       
        tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);   
        tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(120);  
        tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(140); 
        tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(220); 
        tablaClientes.getColumnModel().getColumn(4).setPreferredWidth(90);   
        tablaClientes.getColumnModel().getColumn(5).setPreferredWidth(260);  

        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        btnCrearPedido = new JButton("Crear Pedido");
        panelBoton.add(btnCrearPedido);
        btnCrearNuevoCliente = new JButton("Crear Nuevo Cliente");
        panelBoton.add(btnCrearNuevoCliente);

        btnVerPedidosCliente = new JButton("Ver pedidos");
        panelBoton.add(btnVerPedidosCliente);

        add(panelBoton, BorderLayout.SOUTH);

        cargarClientesEnTabla();

        eventosOpcion3 = new EventosOpcion3(this);
        
    }
  

    public void cargarClientesEnTabla() {
    	clienteDao = new ClienteDao();
    	lblClienteTotales.setText(clienteDao.clientesTotales()+"");
    	lblClienteConPedidos.setText(clienteDao.clientesConPedidosJoin()+"");
    	lblClientesSinPedido.setText(clienteDao.clientesSinPedidos()+"");
    	lblUltimoClienteRegistrado.setText(clienteDao.ultimoCliente());
    	
        this.listaCliente=clienteDao.obtenerClientes();
    	model.setRowCount(0); 
		for (int i = 0; i < listaCliente.size(); i++) {
			model.addRow(new Object[]{
					listaCliente.get(i).getIdCliente(),
					listaCliente.get(i).getNombre(),
					listaCliente.get(i).getApellidos(),
					listaCliente.get(i).getEmail(),
					listaCliente.get(i).getTelefono(),
					listaCliente.get(i).getDireccion()});
			
			
		}
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





	public List<Cliente> getListaCliente() {
		return listaCliente;
	}





	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}





	public DefaultTableModel getModel() {
		return model;
	}





	public void setModel(DefaultTableModel model) {
		this.model = model;
	}





	public JButton getBtnVerPedidosCliente() {
		return btnVerPedidosCliente;
	}





	public void setBtnVerPedidosCliente(JButton btnVerPedidosCliente) {
		this.btnVerPedidosCliente = btnVerPedidosCliente;
	}





	public EventosOpcion3 getEventosOpcion3() {
		return eventosOpcion3;
	}





	public void setEventosOpcion3(EventosOpcion3 eventosOpcion3) {
		this.eventosOpcion3 = eventosOpcion3;
	}





	public void setTablaClientes(JTable tablaClientes) {
		this.tablaClientes = tablaClientes;
	}





	public void setBtnCrearNuevoCliente(JButton btnCrearNuevoCliente) {
		this.btnCrearNuevoCliente = btnCrearNuevoCliente;
	}


	public JButton getBtnCrearNuevoCliente() {
        return btnCrearNuevoCliente;
    }

    public JTable getTablaClientes() {
        return tablaClientes;
    }


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public JButton getBtnCrearPedido() {
		return btnCrearPedido;
	}


	public void setBtnCrearPedido(JButton btnCrearPedido) {
		this.btnCrearPedido = btnCrearPedido;
	}
}
