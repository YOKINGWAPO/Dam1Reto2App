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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import java.awt.Container;



public class Opcion1 extends JPanel {
	

	private Menu menu;
	private JScrollPane cargarPanel;
	private JPanel panelTargetas;
	private cartaComponentes cartaComponentes; 
	
	
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
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Filtros");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Categorias");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblNewLabel_1);
		
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
		int cont=0;
		while (!(cont==menu.getLista().size())) {
				cont++;
				//cartaComponentes.getLblNombreComp().setText("");
				System.out.println(cont);
				panelTargetas.add(new cartaComponentes());
		}
		
	}
}
