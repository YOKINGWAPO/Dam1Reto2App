import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CartaCategoria extends JPanel {

	private static final long serialVersionUID = 1L;


	public CartaCategoria() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 8, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Ir a categoria");
		panel_1.add(btnNewButton_3);

	}

}
