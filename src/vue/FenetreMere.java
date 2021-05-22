package vue;
import javax.swing.JFrame ;
import java.awt.*;

public class FenetreMere extends JFrame {

    public FenetreMere (String parTitre) {
        super (parTitre);
            PanelMain contentPane = new PanelMain();
            setContentPane (contentPane);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
            //setLocation(400,300);
            setSize(400,400);
    }

    public static void main (String  [] args) {
        new FenetreMere ("Bibliothèque IUT");
    }
}