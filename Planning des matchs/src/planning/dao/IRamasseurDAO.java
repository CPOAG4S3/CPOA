package planning.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import planning.metier.Ramasseur;

public interface IRamasseurDAO {
    
    public List<Ramasseur> getLesRamasseurs();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection c);
    public void closeConnection(Connection c) throws SQLException;
}

