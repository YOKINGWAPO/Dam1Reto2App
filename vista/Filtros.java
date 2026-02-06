import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Filtros extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelFiltro;
	private JLabel lblNombreFiltro;
	private JList listFiltros;

	
	public Filtros() {
		setLayout(new BorderLayout(0, 0));
		
		panelFiltro = new JPanel();
		add(panelFiltro, BorderLayout.CENTER);
		panelFiltro.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNombreFiltro = new JLabel("lblNombreFiltro");
		lblNombreFiltro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreFiltro.setHorizontalAlignment(SwingConstants.CENTER);
		panelFiltro.add(lblNombreFiltro);
		
		listFiltros = new JList();
		panelFiltro.add(listFiltros);

	}


	public JPanel getPanelFiltro() {
		return panelFiltro;
	}


	public void setPanelFiltro(JPanel panelFiltro) {
		this.panelFiltro = panelFiltro;
	}


	public JLabel getLblNombreFiltro() {
		return lblNombreFiltro;
	}


	public void setLblNombreFiltro(JLabel lblNombreFiltro) {
		this.lblNombreFiltro = lblNombreFiltro;
	}


	public JList getListFiltros() {
		return listFiltros;
	}


	public void setListFiltros(JList listFiltros) {
		this.listFiltros = listFiltros;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
