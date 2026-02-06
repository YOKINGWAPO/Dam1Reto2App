import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Opcion2 extends JPanel{
	private Menu menu;
	public Opcion2(Menu menu) {
		setBackground(new Color(255, 255, 255));
		this.menu=menu;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Socket");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JList list = new JList();
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(7, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Procesadores");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Placa Base");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Grafica");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ram");
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Almacenamiento");
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Fuente de Alimentacion");
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Caja");
		panel_1.add(btnNewButton_6);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
	}
}
