package modele;
import oracle.jdbc.driver.OracleDriver;
import java.sql.*;

public class Connexion {
    private String identifiant;
    private String mdp;
    Connection conn;

    public Connexion (String parIdentifiant,String parMdp){
        identifiant = parIdentifiant;
        mdp = parMdp;
    }

    public void verifConnexion () throws SQLException {
        /*
            Permet de se connecter à la base de donnée
        */
        DriverManager.registerDriver(new OracleDriver());
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:info",
                    "lsenovil", "azerty");
        }
        catch (SQLException e){
            conn = DriverManager.getConnection("jdbc:oracle:thin:@madere:1521:info",
                    "lsenovil", "azerty");
        }
    }

    public Boolean requeteConnexion () throws SQLException{
        /*
        * Methode qui prend l'identifiant et le mot de passe donnée dans le constructeur et qui retourne un booléen en fonction du resultat de cette requete
         */
        Boolean succes = false;     //Succes est faux si la requete SQL est incorrect et inversement si la requete est bonne
        try {
            String req = "SELECT email,mdp FROM Etudiant WHERE email='"+identifiant+"' AND mdp='"+mdp+"'";
            Statement stmt = conn.createStatement();
            ResultSet requete = stmt.executeQuery(req);
            if (requete.next()){
                succes = true;
            }
        }
        catch (SQLException e){
            System.out.println("erreur");
        }
        return succes;
    }
}
