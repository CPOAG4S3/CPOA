package planning.metier;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import planning.dao.IJoueurDAO;
import planning.dao.oracle.OracleDataSourceDAO;
import planning.dao.oracle.OracleJoueurDAO;

public class main {
    private static OracleDataSourceDAO dataSourceDAO;
    private static IJoueurDAO joueurDAO;
    private static Connection connexionBD;
    
    public static void main (String String[]){
        try{
           dataSourceDAO = OracleDataSourceDAO.getOracleDataSourceDAO();
           joueurDAO = new OracleJoueurDAO();
           joueurDAO.setDataSource(dataSourceDAO);
           connexionBD = dataSourceDAO.getConnection();
           joueurDAO.setConnection(connexionBD);
        }
        catch(SQLException ex){
        }
        afficherListeJoueurs();
    }
   public static void afficherListeJoueurs(){
       List<Joueur> listeJoueurs = joueurDAO.getLesJoueurs();
        listeJoueurs.stream().forEach((joueur) -> {
            System.out.println(joueur);
        });
   }
}

