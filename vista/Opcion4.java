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

public class Opcion4 extends JPanel {

    private Menu menu;
    private int idCliente;

    private PedidosDao pedidosDao;
    private List<Pedido> listaPedidos = new ArrayList<>();

    private JTable tablaPedidos;
    private DefaultTableModel model;

    private JLabel lblTitulo;
    private JLabel lblTotalPedidos;

    private JButton btnVolver;

    public Opcion4(Menu menu) {

        this.menu = menu;
        setLayout(new BorderLayout(0, 0));

        
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lblTitulo = new JLabel("Pedidos del cliente:");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblTitulo);

        lblTotalPedidos = new JLabel("0");
        lblTotalPedidos.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTop.add(lblTotalPedidos);

        add(panelTop, BorderLayout.NORTH);

        
        String[] columnas = {
        	    "ID Pedido", "Nombre", "Descripción", "Estado", "Fecha creación", "Componentes", "Nº detalles"
        	};


        model = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaPedidos = new JTable(model);
        tablaPedidos.setRowHeight(26);
        tablaPedidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tablaPedidos.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
        tablaPedidos.getTableHeader().setReorderingAllowed(false);

        
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);

        tablaPedidos.getColumnModel().getColumn(0).setCellRenderer(center); 
        tablaPedidos.getColumnModel().getColumn(6).setCellRenderer(center); 

        tablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(80);
        tablaPedidos.getColumnModel().getColumn(1).setPreferredWidth(160);
        tablaPedidos.getColumnModel().getColumn(2).setPreferredWidth(260);
        tablaPedidos.getColumnModel().getColumn(3).setPreferredWidth(90);
        tablaPedidos.getColumnModel().getColumn(4).setPreferredWidth(160);
        tablaPedidos.getColumnModel().getColumn(5).setPreferredWidth(300); 
        tablaPedidos.getColumnModel().getColumn(6).setPreferredWidth(100);


        JScrollPane scrollPane = new JScrollPane(tablaPedidos);
        add(scrollPane, BorderLayout.CENTER);

       
        JPanel panelBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnVolver = new JButton("Volver");
        panelBottom.add(btnVolver);
        add(panelBottom, BorderLayout.SOUTH);
    }

    
    public void cargarPedidos() {

        pedidosDao = new PedidosDao();

        lblTotalPedidos.setText(
            pedidosDao.totalPedidosCliente(idCliente) + ""
        );

        this.listaPedidos = pedidosDao.obtenerPedidosCliente(idCliente);

        model.setRowCount(0);

        for (int i = 0; i < listaPedidos.size(); i++) {

            String componentes = "";

            for (int j = 0; j < listaPedidos.get(i).getDetalles().size(); j++) {

                DetallePedido d = listaPedidos.get(i).getDetalles().get(j);

               
                String nombre = d.getNombreComponente();
                if (nombre == null || nombre.trim().equals("")) {
                    nombre = "x";                }

                componentes += nombre + " x" + d.getCantidad();

                if (j < listaPedidos.get(i).getDetalles().size() - 1) {
                    componentes += ", ";
                }
            }

            model.addRow(new Object[]{
                listaPedidos.get(i).getIdConfiguracion(),
                listaPedidos.get(i).getNombreConfig(),
                listaPedidos.get(i).getDescripcion(),
                listaPedidos.get(i).getEstado(),
                listaPedidos.get(i).getFechaCreacion(),
                componentes, 
                listaPedidos.get(i).getDetalles().size()
            });
        }
    }




    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
        System.out.println(idCliente);
        cargarPedidos(); 
    }

    public int getIdCliente() {
        return idCliente;
    }

    public JTable getTablaPedidos() {
        return tablaPedidos;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public Menu getMenu() {
        return menu;
    }
}
