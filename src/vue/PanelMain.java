package vue;

import javax.swing.*;
import java.awt.*;
import controleur.Controleur;

public class PanelMain extends JPanel {
    PanelConnexion panelCentre;

    public PanelMain() {
        setLayout(new BorderLayout(20,20));
        panelCentre = new PanelConnexion ();
        this.add(panelCentre,BorderLayout.CENTER);
        setBackground(Color.gray);
        Controleur controleur = new Controleur(panelCentre);
    }
}
