package planning.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import planning.metier.Reservation;

public interface IReservationDAO {
    public List<Reservation> getListeReservationsEntrainements();
    public boolean ajouterReservation(Reservation nouvelleReservation);
    public void setDataSource(DataSource ds);
    public void setConnection(Connection c);
    public void closeConnection(Connection c) throws SQLException;    
}
