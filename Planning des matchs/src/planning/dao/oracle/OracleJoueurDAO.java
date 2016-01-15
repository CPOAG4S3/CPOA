package planning.dao.oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import planning.dao.IJoueurDAO;
import planning.metier.Joueur;

public class OracleJoueurDAO implements IJoueurDAO{
    private static DataSource ds;
    private static Connection connexionBD;
   
    @Override
    public void setDataSource(DataSource ds) {
        OracleJoueurDAO.ds = ds;
    }

    @Override
    public void setConnection(Connection c) {
        OracleJoueurDAO.connexionBD = c;
    }

    @Override
    public void closeConnection(Connection c) throws SQLException {
        if (c!=null){
            c.close();
        }
    }

    @Override
    public List<Joueur> getLesJoueurs() {
        List<Joueur> listeJoueurs = null;
        ResultSet rset = null;
        Statement stmt = null;
        Joueur joueurCourant;
          try{
            stmt = connexionBD.createStatement();
            listeJoueurs = new ArrayList<>();
            rset = stmt.executeQuery("SELECT * from Joueur");
            while(rset.next()){ //Boucle pour chaque ligne
                joueurCourant = new Joueur(rset.getString(1), rset.getString(2), rset.getString(3)); //Crée un objet joueur à partir des données de la table SQL
                listeJoueurs.add(joueurCourant);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OracleJoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                stmt.close();
                rset.close();
            }catch(SQLException ex){
                Logger.getLogger(OracleJoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listeJoueurs;
    }
    
    @Override
    public Joueur OracleJoueurDAO(String numJoueur) {
        ResultSet rset = null;
        Statement stmt = null;
        Joueur joueurCourant = null;
          try{
            stmt = connexionBD.createStatement();
            rset = stmt.executeQuery("SELECT * from Joueur WHERE num_licence = '" + numJoueur + "'");
            while(rset.next()){ 
                joueurCourant = new Joueur(rset.getString(1), rset.getString(2), rset.getString(3)); //Crée un objet joueur à partir des données de la table SQL
            }
        } catch (SQLException ex) {
            Logger.getLogger(OracleJoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                stmt.close();
                rset.close();
            }catch(SQLException ex){
                Logger.getLogger(OracleJoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return joueurCourant;
    }

}
