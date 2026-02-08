import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EventosCartaComponentes {

    private CartaComponentes carta;
    private ImageIcon original;

    public EventosCartaComponentes(CartaComponentes carta) {
        this.carta = carta;

        JLabel lbl = carta.getLblImagen();
        if (lbl.getIcon() instanceof ImageIcon) {
            original = (ImageIcon) lbl.getIcon();
        }

        carta.getPanelImagen().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                escalar();
            }
        });
    }

    private void escalar() {
        if (original == null) return;

        int anchoPanel = carta.getPanelImagen().getWidth();
        if (anchoPanel <= 0) return;

        Image img = original.getImage();
        Image escalada = img.getScaledInstance(
                anchoPanel,
                -1,
                Image.SCALE_SMOOTH
        );

        carta.getLblImagen().setIcon(new ImageIcon(escalada));
    }
}
