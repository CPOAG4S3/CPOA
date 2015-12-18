package planning.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import planning.metier.Joueur;

public interface IJoueurDAO {
    
    public List<Joueur> getLesJoueurs();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection c);
    public void closeConnection(Connection c) throws SQLException;
}
