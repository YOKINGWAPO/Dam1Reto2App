import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Opcion7 extends JPanel {

    private static final long serialVersionUID = 1L;

    private Menu menu;
    private int idCliente;

    private ProductosDao productosDao;
    private PedidosDao pedidosDao;

    private JLabel lblTitulo;
    private JLabel lblIdCliente;

    private JComboBox<String> cbTipo;
    private JButton btnCargarProductos;
    private JButton btnAddProducto;

    private JTable tablaProductos;
    private DefaultTableModel modelProductos;
    private List<Producto> listaProductos = new ArrayList<>();

    private JTable tablaDetalles;
    private DefaultTableModel modelDetalles;

    private JTextField txtNombreConfig;
    private JTextField txtDescripcion;
    private JComboBox<String> cbEstado;
    private JButton btnCrearPedido;

    public Opcion7(Menu menu) {

        this.menu = menu;
        setLayout(new BorderLayout(0, 0));

        productosDao = new ProductosDao();
        pedidosDao = new PedidosDao();

       
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblTitulo = new JLabel("Crear pedido - Cliente:");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblTitulo);

        lblIdCliente = new JLabel("0");
        lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblIdCliente);

        add(panelTop, BorderLayout.SOUTH);

        
        String[] colsProd = { "ID", "Nombre", "Precio" };
        modelProductos = new DefaultTableModel(colsProd, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tablaProductos = new JTable(modelProductos);
        tablaProductos.setRowHeight(24);
        tablaProductos.getTableHeader().setReorderingAllowed(false);

        
        String[] colsDet = { "ID Componente", "Nombre", "Cantidad", "Precio unitario" };
        modelDetalles = new DefaultTableModel(colsDet, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 2; // solo cantidad editable
            }
        };

        tablaDetalles = new JTable(modelDetalles);
        tablaDetalles.setRowHeight(24);
        tablaDetalles.getTableHeader().setReorderingAllowed(false);

        
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);

        tablaProductos.getColumnModel().getColumn(0).setCellRenderer(center);
        tablaDetalles.getColumnModel().getColumn(0).setCellRenderer(center);
        tablaDetalles.getColumnModel().getColumn(2).setCellRenderer(center);

       
        JScrollPane spProductos = new JScrollPane(tablaProductos);
        JScrollPane spDetalles = new JScrollPane(tablaDetalles);

        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spProductos, spDetalles);
        split.setResizeWeight(0.55); 
        add(split, BorderLayout.CENTER);

        
        JPanel panelBottom = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panelBottom.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{
                "CPU","GPU","RAM","ALMACENAMIENTO","PLACA_BASE","MONITOR","CASCOS","CONSOLA","PSU","CAJA"
        });
        panelBottom.add(cbTipo);

        btnCargarProductos = new JButton("Cargar");
        panelBottom.add(btnCargarProductos);

        btnAddProducto = new JButton("Añadir");
        panelBottom.add(btnAddProducto);

        panelBottom.add(new JLabel("Nombre config:"));
        txtNombreConfig = new JTextField(12);
        panelBottom.add(txtNombreConfig);

        panelBottom.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField(14);
        panelBottom.add(txtDescripcion);

        panelBottom.add(new JLabel("Estado:"));
        cbEstado = new JComboBox<>(new String[]{"PEDIDO","CARRITO","PAGADO"});
        panelBottom.add(cbEstado);

        btnCrearPedido = new JButton("Crear pedido");
        panelBottom.add(btnCrearPedido);

        add(panelBottom, BorderLayout.NORTH);

        
        btnCargarProductos.addActionListener(e -> cargarProductos());
        btnAddProducto.addActionListener(e -> anadirProductoAlPedido());
        btnCrearPedido.addActionListener(e -> crearPedido());
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
        lblIdCliente.setText(String.valueOf(idCliente));
    }

    private void cargarProductos() {

        String tipo = (String) cbTipo.getSelectedItem();
        listaProductos = productosDao.obtenerProductos(tipo);

        modelProductos.setRowCount(0);

        for (int i = 0; i < listaProductos.size(); i++) {

            int id = listaProductos.get(i).getId_componente();
            String nombre = listaProductos.get(i).getNombre();
            BigDecimal precio = listaProductos.get(i).getPrecio();

            modelProductos.addRow(new Object[]{ id, nombre, precio });
        }
    }

    private void anadirProductoAlPedido() {

        int fila = tablaProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un producto");
            return;
        }

        int filaModelo = tablaProductos.convertRowIndexToModel(fila);

        int idComp = Integer.parseInt(modelProductos.getValueAt(filaModelo, 0).toString());
        String nombre = modelProductos.getValueAt(filaModelo, 1).toString();

        double precio = 0;
        Object pObj = modelProductos.getValueAt(filaModelo, 2);
        if (pObj != null) precio = Double.parseDouble(pObj.toString().replace(",", "."));

       
        for (int i = 0; i < modelDetalles.getRowCount(); i++) {
            int idExistente = Integer.parseInt(modelDetalles.getValueAt(i, 0).toString());
            if (idExistente == idComp) {
                int cantActual = Integer.parseInt(modelDetalles.getValueAt(i, 2).toString());
                modelDetalles.setValueAt(cantActual + 1, i, 2);
                return;
            }
        }

        modelDetalles.addRow(new Object[]{ idComp, nombre, 1, precio });
    }

    private void crearPedido() {

        String nombreConfig = txtNombreConfig.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        String estado = (String) cbEstado.getSelectedItem();

        if (idCliente <= 0) {
            JOptionPane.showMessageDialog(this, "ID cliente incorrecto");
            return;
        }

        if (nombreConfig.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta el nombre de la configuraciun");
            return;
        }

        if (modelDetalles.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Añade al menos un componente al pedido");
            return;
        }

        Pedido pedido = new Pedido();
        pedido.setIdCliente(idCliente);
        pedido.setNombreConfig(nombreConfig);
        pedido.setDescripcion(descripcion);
        pedido.setEstado(estado);
        pedido.setDetalles(new ArrayList<>());

        for (int i = 0; i < modelDetalles.getRowCount(); i++) {

            int idComp = Integer.parseInt(modelDetalles.getValueAt(i, 0).toString());
            int cant = Integer.parseInt(modelDetalles.getValueAt(i, 2).toString());

            double precio = 0;
            Object pObj = modelDetalles.getValueAt(i, 3);
            if (pObj != null) precio = Double.parseDouble(pObj.toString().replace(",", "."));

            DetallePedido detalle = new DetallePedido();
            detalle.setIdComponente(idComp);
            detalle.setCantidad(cant);
            detalle.setPrecioUnitario(precio);

            pedido.getDetalles().add(detalle);
        }

        int idNuevo = pedidosDao.crearPedidoConDetalles(pedido);

        if (idNuevo > 0) {
            JOptionPane.showMessageDialog(this, "Pedido creado con ID: " + idNuevo);

            txtNombreConfig.setText("");
            txtDescripcion.setText("");
            modelDetalles.setRowCount(0);

        } else {
            JOptionPane.showMessageDialog(this, "No se pudo crear el pedido");
        }
    }

    public int getIdCliente() {
        return idCliente;
    }
}
