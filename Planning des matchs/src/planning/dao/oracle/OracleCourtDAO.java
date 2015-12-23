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
import planning.dao.ICourtDAO;
import planning.metier.Court;

public class OracleCourtDAO implements ICourtDAO {

    private static DataSource ds;
    private static Connection connexionBD;
   
    @Override
    public void setDataSource(DataSource ds) {
        OracleCourtDAO.ds = ds;
    }

    @Override
    public void setConnection(Connection c) {
        OracleCourtDAO.connexionBD = c;
    }

    @Override
    public void closeConnection(Connection c) throws SQLException {
        if (c!=null){
            c.close();
        }
    }

    @Override
    public List<Court> getLesCourts() {
        List<Court> listeCourts = null;
        ResultSet rset = null;
        Statement stmt = null;
        Court courtCourant;
          try{
            stmt = connexionBD.createStatement();
            listeCourts = new ArrayList<>();
            rset = stmt.executeQuery("SELECT * from Court");
            while(rset.next()){
                courtCourant = new Court(rset.getString(1), rset.getString(2));
                listeCourts.add(courtCourant); 
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
        return listeCourts;
    }
}
