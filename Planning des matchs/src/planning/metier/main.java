package planning.metier;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import planning.dao.IArbitreDAO;
import planning.dao.IJoueurDAO;

import planning.dao.oracle.OracleArbitreDAO;
import planning.dao.oracle.OracleJoueurDAO;

import planning.dao.oracle.OracleDataSourceDAO;


public class main {
    private static OracleDataSourceDAO dataSourceDAO;
    private static IJoueurDAO joueurDAO;
    private static IArbitreDAO arbitreDAO;
    private static Connection connexionBD;
    
   public static void main (String String[]) throws SQLException{
         
        setConnexionJoueur();
        afficherListeJoueurs();
        
        setConnexionArbitre();
        afficherListeArbitres();
    }
   public static void setConnexionJoueur(){
       try{
           dataSourceDAO = OracleDataSourceDAO.getOracleDataSourceDAO();
           joueurDAO = new OracleJoueurDAO();
           joueurDAO.setDataSource(dataSourceDAO);
           connexionBD = dataSourceDAO.getConnection();
           joueurDAO.setConnection(connexionBD);
        }
        catch(SQLException ex){
        }
   }
   public static void afficherListeJoueurs(){
       List<Joueur> listeJoueurs = joueurDAO.getLesJoueurs();
        listeJoueurs.stream().forEach((joueur) -> {
            System.out.println(joueur);
        });
   }
   
   public static void setConnexionArbitre(){
       try{
           dataSourceDAO = OracleDataSourceDAO.getOracleDataSourceDAO();
           arbitreDAO = new OracleArbitreDAO();
           arbitreDAO.setDataSource(dataSourceDAO);
           connexionBD = dataSourceDAO.getConnection();
           arbitreDAO.setConnection(connexionBD);
        }
        catch(SQLException ex){
        }
   }
   public static void afficherListeArbitres(){
       List<Arbitre> listeArbitres = arbitreDAO.getLesArbitres(); //Ligne Importante pour la partie vue
        listeArbitres.stream().forEach((joueur) -> {
            System.out.println(joueur);
        });
   }
}

