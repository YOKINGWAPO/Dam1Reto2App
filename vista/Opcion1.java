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

public class Opcion1 extends JPanel {
	private Menu menu;
	public Opcion1(Menu menu) {
		setBackground(new Color(0, 255, 128));
		this.menu=menu;
		setLayout(new GridLayout(1, 0, 0, 0));
		
		
	}
}
