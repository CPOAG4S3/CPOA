package planning.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import planning.metier.Arbitre;

public interface IArbitreDAO {
    public List<Arbitre> getLesArbitres();
    public List<Arbitre> getLesArbitresDispo();
    public List<Arbitre> getLesArbitresDispoITT1();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection c);
    public void closeConnection(Connection c) throws SQLException;    
}
