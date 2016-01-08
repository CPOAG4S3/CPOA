package planning.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import planning.metier.Match;

public interface IMatchDAO {
    public void ajouterMatch(Match nouveauMatch);
    public void setDataSource(DataSource ds);
    public void setConnection(Connection c);
    public void closeConnection(Connection c) throws SQLException;    
}
