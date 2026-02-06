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
import javax.swing.JList;
import javax.swing.AbstractListModel;



public class Opcion1 extends JPanel {

	private Conexion conexion;
	private Menu menu;
	private JScrollPane cargarPanel;
	private JPanel panelTargetas;
	private CartaComponentes cartaComponentes; 
	private Filtros filtros; 
	
	private ArrayList<CartaComponentes> arrayComponentes;
	private JPanel panelFiltrosPrincipal;


	public Opcion1(Menu menu) {
		this.menu=menu;

		setBackground(new Color(0, 255, 128));

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

		panelFiltrosPrincipal = new JPanel();
		panel.add(panelFiltrosPrincipal, BorderLayout.WEST);
		panelFiltrosPrincipal.setLayout(new GridLayout(10, 1, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelFiltrosPrincipal.add(lblNewLabel_2);

		JSlider slider = new JSlider();
		panelFiltrosPrincipal.add(slider);

		JSlider slider_1 = new JSlider();
		panelFiltrosPrincipal.add(slider_1);

		cargarPanel = new JScrollPane();
		panel.add(cargarPanel, BorderLayout.CENTER);

		panelTargetas = new JPanel();
		cargarPanel.setViewportView(panelTargetas);
		panelTargetas.setLayout(new GridLayout(0, 2, 10, 10));

		System.out.println(menu.getLista().size()+"esto es lista");
		menu.getLista().size();

		arrayComponentes = new ArrayList<>();

	}


	public void cargarTargetas(int activo, int categoria) {
		
		
			
		if (activo==1) {
			
			for (int i = 0; i < menu.getLista().size(); i++) {
				arrayComponentes.add(new CartaComponentes());


				arrayComponentes.get(i).getLblNombreComp().setText(menu.getLista().get(i).getNombre());
				arrayComponentes.get(i).getLblDescripcion().setText(menu.getLista().get(i).getDescripcion());
				arrayComponentes.get(i).getLblDinero().setText(menu.getLista().get(i).getPrecio()+"");
				if (categoria==2) {
					//panelFiltrosPrincipal.add(new Filtros());
					arrayComponentes.get(i).getLblEspecificacion().setText(
							"Chipset: "+menu.getLista().get(i).getGpu().getGpuChipset()
							+" Consumo W:"+menu.getLista().get(i).getGpu().getGpuConsumoW()
							+" Vram: "+menu.getLista().get(i).getGpu().getGpuVramGb()+"GB");
				}	
				if (categoria==1) {
					
					arrayComponentes.get(i).getLblEspecificacion().setText(
							"Nucleos: "+menu.getLista().get(i).getCpu().getCpuNucleos()
							+" Hilos:"+menu.getLista().get(i).getCpu().getCpuHilos()
							+" Socket: "+menu.getLista().get(i).getCpu().getCpuSocket()
							+" Consumo W: "+menu.getLista().get(i).getCpu().getCpuTdpW());
				}
				if (categoria==3) {
					
					arrayComponentes.get(i).getLblEspecificacion().setText(
							"Socket: "+menu.getLista().get(i).getPlacaBase().getPbSocket()
							+" Formato:"+menu.getLista().get(i).getPlacaBase().getPbFormato()
							+" Tipo de ram: "+menu.getLista().get(i).getPlacaBase().getPbRamTipo()
							+" Chipset: "+menu.getLista().get(i).getPlacaBase().getPbChipset());
				}
				if (categoria==4) {
					
					arrayComponentes.get(i).getLblEspecificacion().setText(
							"Tipo: "+menu.getLista().get(i).getRam().getRamTipo()
							+" Capacidad:"+menu.getLista().get(i).getRam().getRamCapacidadGb()
							+" Frecuencia: "+menu.getLista().get(i).getRam().getRamFrecuenciaMhz());
				}
				if (categoria==5) {
					
					arrayComponentes.get(i).getLblEspecificacion().setText(
							"Capacidad GB: "+menu.getLista().get(i).getAlmacenamiento().getAlmCapacidadGb()
							+" Tipo:"+menu.getLista().get(i).getAlmacenamiento().getAlmTipo());
				}
				if (categoria==6) {
					
					arrayComponentes.get(i).getLblEspecificacion().setText(
							"Resolucion: "+menu.getLista().get(i).getMonitor().getMonResolucion()
							+" Tamaño:"+menu.getLista().get(i).getMonitor().getMonTamanoPulg()
							+" Pulgadas "+" Hz:"+menu.getLista().get(i).getMonitor().getMonHz());
				}
				if (categoria==7) {
					
					arrayComponentes.get(i).getLblEspecificacion().setText(
							"Tipo: "+menu.getLista().get(i).getCascos().getCasConexion()
							+" Microfono:"+menu.getLista().get(i).getCascos().getCasMicrofono());
				}
				if (categoria==8) {
					
					arrayComponentes.get(i).getLblEspecificacion().setText(
							"Almacenamiento: "+menu.getLista().get(i).getConsolas().getConAlmacenamientoGb()+" Gb");
				}
				if (categoria==21) {
					
					arrayComponentes.get(i).getLblEspecificacion().setText(
							"Certificado: "+menu.getLista().get(i).getPsu().getPsuCertificacion()+" Potencia:"+menu.getLista().get(i).getPsu().getPsuPotenciaW()+" W" +" Modular:"+menu.getLista().get(i).getPsu().getPsuModular());
				}
				if (categoria==22) {
					
					arrayComponentes.get(i).getLblEspecificacion().setText("Formato: "+menu.getLista().get(i).getCaja().getCajaFormatoSoportado());
				}
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
		} else {
			for (int i = 0; i < menu.getLista().size(); i++) {
				panelTargetas.remove(arrayComponentes.get(i));
			}

		}
		

		}

	}
