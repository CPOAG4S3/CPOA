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
import planning.dao.IArbitreDAO;
import planning.metier.Arbitre;

public class OracleArbitreDAO implements IArbitreDAO{

    private static DataSource ds;
    private static Connection connexionBD;
   
    @Override
    public void setDataSource(DataSource ds) {
        OracleArbitreDAO.ds = ds;
    }

    @Override
    public void setConnection(Connection c) {
        OracleArbitreDAO.connexionBD = c;
    }

    @Override
    public void closeConnection(Connection c) throws SQLException {
        if (c!=null){
            c.close();
        }
    }

    @Override
    public List<Arbitre> getLesArbitres() {
        List<Arbitre> listeArbitres = null;
        ResultSet rset = null;
        Statement stmt = null;
        Arbitre arbitreCourant;
          try{
            stmt = connexionBD.createStatement();
            listeArbitres = new ArrayList<>();
            rset = stmt.executeQuery("SELECT * from Arbitre");
            while(rset.next()){ //Boucle pour chaque ligne
                arbitreCourant = new Arbitre(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getInt(6)); 
                //On utilise le constructeur à 6 arguments pour obtenir toutes les valeurs correspondant a l'objet dans la base
                listeArbitres.add(arbitreCourant); 
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
        return listeArbitres;
    }

    @Override
    public List<Arbitre> getLesArbitresDispo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Arbitre> getLesArbitresDispoITT1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
