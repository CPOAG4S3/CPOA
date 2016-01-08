package planning.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import planning.metier.Court;

public interface ICourtDAO {
    public List<Court> getLesCourts();
    public List<Court> getLesCourtsMatch();
    public List<Court> getLesCourtsEntrainement();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection c);
    public void closeConnection(Connection c) throws SQLException;    
}