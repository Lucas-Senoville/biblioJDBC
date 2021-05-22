package vue;

import modele.Connexion;
import oracle.jdbc.driver.OracleDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class PanelConnexion extends JPanel implements ActionListener {
    JLabel labelBienvenue;
    JLabel pseudo;
    JLabel mdp;
    JTextField zoneLogin;
    JTextField zoneDeMdp;
    JButton boutonConnexion;
    JLabel resultatConnexion;

    public PanelConnexion(){
        //Declaration du gridbaglayout et de la contrainte
        setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints ();
        contraintes.insets = new Insets (6,6,6,6);
        contraintes.anchor = GridBagConstraints.WEST;

        //labelBienvenue
        labelBienvenue = new JLabel("Bienvenue dans votre Bibliotheque en ligne");
        contraintes.gridy=0; contraintes.gridwidth = 4;	contraintes.gridx=3;
        this.add(labelBienvenue);

        //zone login
        pseudo = new JLabel("Login : ");
        zoneLogin = new JTextField(20);
        pseudo.setDisplayedMnemonic('L');
        pseudo.setLabelFor(zoneLogin);

        contraintes.gridy=2; contraintes.gridwidth = 4;	contraintes.gridx=0;
        this.add(pseudo, contraintes);

        contraintes.gridy=3; contraintes.gridwidth = 4;	contraintes.gridx=0;
        this.add(zoneLogin, contraintes);

        //zone mdp
        mdp = new JLabel("Mot de passe : ");
        zoneDeMdp = new JTextField(20);
        mdp.setDisplayedMnemonic('M');
        mdp.setLabelFor(zoneDeMdp);

        contraintes.gridy=5; contraintes.gridwidth = 4;	contraintes.gridx=0;
        this.add(mdp, contraintes);

        contraintes.gridy=6; contraintes.gridwidth = 4;	contraintes.gridx=0;
        this.add(zoneDeMdp, contraintes);

        //zone boutton
        boutonConnexion = new JButton("Se connecter");
        contraintes.gridy=7; contraintes.gridwidth =2;	contraintes.gridx=0;
        this.add(boutonConnexion, contraintes);
        boutonConnexion.addActionListener(this);

        //zone resultatConnexion
        resultatConnexion = new JLabel("");
        contraintes.gridy=8; contraintes.gridwidth =2;	contraintes.gridx=0;
        this.add(resultatConnexion,contraintes);

    }//panelConnexion

    @Override
    public void actionPerformed(ActionEvent parEvent) {
        if (parEvent.getSource () == boutonConnexion) {
            Connexion conn = new Connexion(zoneLogin.getText(), zoneDeMdp.getText());
            try {
                conn.verifConnexion();
            } catch (SQLException throwables) {
                resultatConnexion.setText("Erreur de connexion avec la base de donnée");
                resultatConnexion.setForeground(Color.red);
            }

            try {
                if(conn.requeteConnexion()){
                    resultatConnexion.setText("Vous êtes connectés");
                    resultatConnexion.setForeground(Color.green);
                }
                else{
                    resultatConnexion.setText("Identifiant ou mot de passe incorrecte");
                    resultatConnexion.setForeground(Color.red);
                }
            } catch (SQLException throwables) {
                System.out.println(throwables.getMessage());
            }

        }
    }
}//fin class
