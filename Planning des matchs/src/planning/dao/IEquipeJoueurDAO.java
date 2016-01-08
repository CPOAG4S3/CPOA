package planning.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import planning.metier.EquipeJoueurs;

public interface IEquipeJoueurDAO {
    public List<EquipeJoueurs> getLesEquipesJoueurs();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection c);
    public void closeConnection(Connection c) throws SQLException;    
}

