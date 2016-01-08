package planning.dao.oracle;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import planning.dao.IEquipeRamasseurDAO;
import planning.metier.EquipeRamasseur;

public class OracleEquipeRamasseurDAO implements IEquipeRamasseurDAO{

    @Override
    public boolean ajouterEquipeRamasseur(EquipeRamasseur nouvelleEquipe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setConnection(Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection(Connection c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
