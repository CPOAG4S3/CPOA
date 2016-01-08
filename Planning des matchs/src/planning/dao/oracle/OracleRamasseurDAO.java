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
import planning.dao.IRamasseurDAO;
import planning.metier.Court;
import planning.metier.Ramasseur;

public class OracleRamasseurDAO implements IRamasseurDAO{
    private static DataSource ds;
    private static Connection connexionBD;
    
    @Override
    public List<Ramasseur> getLesRamasseurs() {
        List<Ramasseur> listeRamasseurs = null;
        ResultSet rset = null;
        Statement stmt = null;
        Ramasseur ramasseurCourant;
          try{
            stmt = connexionBD.createStatement();
            listeRamasseurs = new ArrayList<>();
            rset = stmt.executeQuery("SELECT * FROM Ramasseur");
            while(rset.next()){
                ramasseurCourant = new Ramasseur(rset.getString(1), rset.getString(2), rset.getString(3));
                listeRamasseurs.add(ramasseurCourant); 
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
        return listeRamasseurs;   
    }

    @Override
    public void setDataSource(DataSource ds) {
        OracleRamasseurDAO.ds = ds;
    }

    @Override
    public void setConnection(Connection c) {
        OracleRamasseurDAO.connexionBD = c;
    }

    @Override
    public void closeConnection(Connection c) throws SQLException {
        if (c!=null){
            c.close();
        }
    }
    
}
