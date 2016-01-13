package planning.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import planning.metier.Joueur;
import planning.metier.Match;

public interface IMatchDAO {
    public void ajouterMatch(Match nouveauMatch);
    public void setDataSource(DataSource ds);
    public void setConnection(Connection c);
    public void closeConnection(Connection c) throws SQLException;    

    public List<Match> getLesMatchs(String type, String niveau, String nomCourt);
}
