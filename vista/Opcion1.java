import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JSlider;



public class Opcion1 extends JPanel {
	
	private Conexion conexion;
	private Menu menu;
	private JScrollPane cargarPanel;
	private JPanel panelTargetas;
	private CartaComponentes cartaComponentes; 
	private ArrayList<CartaComponentes> arrayComponentes;
	
	
	public Opcion1(Menu menu) {
		this.menu=menu;
		
		setBackground(new Color(0, 255, 128));
		this.menu=menu;
		setLayout(new BorderLayout(0, 0));
		
		JPanel titulo = new JPanel();
		add(titulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Componentes");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		titulo.add(lblTitulo);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Filtros");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		JSlider slider = new JSlider();
		panel_2.add(slider);
		
		JSlider slider_1 = new JSlider();
		panel_2.add(slider_1);
		
		JButton btnNewButton = new JButton("Marca");
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Procesadores(Familias)");
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Placas Bases");
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cantidad de Nucleos");
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		panel_2.add(btnNewButton_5);
		
		cargarPanel = new JScrollPane();
		panel.add(cargarPanel, BorderLayout.CENTER);
		
		panelTargetas = new JPanel();
		cargarPanel.setViewportView(panelTargetas);
		panelTargetas.setLayout(new GridLayout(0, 2, 10, 10));
		

      
		System.out.println(menu.getLista().size()+"esto es lista");
		menu.getLista().size();
	
		cargarTargetas();
		
		
		
		
	}


	private void cargarTargetas() {
		arrayComponentes = new ArrayList<>();
		
		for (int i = 0; i < menu.getLista().size(); i++) {
			arrayComponentes.add(new CartaComponentes());
			arrayComponentes.get(i).getLblNombreComp().setText(menu.getLista().get(i).getNombre());
			arrayComponentes.get(i).getLblDescripcion().setText(menu.getLista().get(i).getDescripcion());
			arrayComponentes.get(i).getLblDinero().setText(menu.getLista().get(i).getPrecio()+"");
			arrayComponentes.get(i).getLblEspecificacion().setText(menu.getLista().get(i).getEspecificaciones());
			//arrayComponentes.get(i).getLblImagen().
			
			 try {
				 
				
				 byte[] img = menu.getLista().get(i).getImagen();
				 BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(img));
				 arrayComponentes.get(i).getLblImagen().setIcon(new ImageIcon(imagen));

				
				

				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			panelTargetas.add(arrayComponentes.get(i));
			
			//cartaComponentes.getLblNombreComp().setText("Hola");
			
			
		}
		
		
	}
}
