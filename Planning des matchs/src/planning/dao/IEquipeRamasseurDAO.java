package planning.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import planning.metier.EquipeRamasseur;

public interface IEquipeRamasseurDAO {
    public boolean ajouterEquipeRamasseur(EquipeRamasseur nouvelleEquipe);
    public void setDataSource(DataSource ds);
    public void setConnection(Connection c);
    public void closeConnection(Connection c) throws SQLException;    
}
