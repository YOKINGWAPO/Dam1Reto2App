import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class Opcion6 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel cargaPanel;
	private Menu menu;
	private CategoriasDao categoriasDao;
	private ArrayList<CartaCategoria> arrayCategorias;
	
	public Opcion6(Menu menu) {
		
		this.menu=menu;
		
		setLayout(new BorderLayout(0, 0));
		
		cargaPanel = new JPanel();
		add(cargaPanel, BorderLayout.CENTER);
		cargaPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		//System.out.println(menu.getListaCategoria().size());
		cargarTargetas();
	}
	
	private void cargarTargetas() {
		 
		arrayCategorias = new ArrayList<>();
		
		for (int i = 0; i < menu.getListaCategoria().size(); i++) {
			arrayCategorias.add(new CartaCategoria(menu));
			arrayCategorias.get(i).getLblCategoria().setText(menu.getListaCategoria().get(i).getNombre());
			
			arrayCategorias.get(i).setIdCategoria(menu.getListaCategoria().get(i).getId_categoria());
			
			 try {
				 
				 byte[] img = menu.getListaCategoria().get(i).getImagen();
				 BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(img));
				 arrayCategorias.get(i).getLblImagenCategoria().setIcon(new ImageIcon(imagen));

				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			 cargaPanel.add(arrayCategorias.get(i));
			
			//cartaComponentes.getLblNombreComp().setText("Hola");
			
			
		}
		
		
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
