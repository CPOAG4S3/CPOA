package planning.dao;

//import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
//import sortieminibus.metier.MiniBus;
/**
 *
 * @author Etienne
 */
public interface IMinibusDAO {
    
    //public List<MiniBus> getLesMinibus();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection c);
    public void closeConnection(Connection c) throws SQLException;
}
