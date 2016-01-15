package planning.dao.oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import planning.dao.IMatchDAO;
import planning.metier.Joueur;

import planning.metier.Match;

public class OracleMatchDAO implements IMatchDAO {
    private static DataSource ds;
    private static Connection connexionBD;
    
    @Override
    public void ajouterMatch(Match nouveauMatch) {
        ResultSet rset = null;
        Statement stmt = null;
        String insertTableSQL = "INSERT INTO match VALUES("
                + nouveauMatch.getNumMatch()      + ", "
                + "TO_DATE('" + nouveauMatch.getHoraire() + " 00:00:00','YYYY-MM-DD HH24:MI:SS'), "
                + "'" + nouveauMatch.getNiveau()        + "', "
                + "'" + nouveauMatch.getTypeMatch()     + "', "
                + "'" + nouveauMatch.getNomCourtMatch() + "', "
                + "'" + nouveauMatch.getParticipant1()  + "', "
                + "'" + nouveauMatch.getParticipant2()  + "', "
                + "'" + nouveauMatch.getEquipe1()       + "', "
                + "'" + nouveauMatch.getEquipe2()       + "', "
                + "'', '', "
                + "'" + nouveauMatch.getEquipeRamasseur1() + "', "
                + "'" + nouveauMatch.getEquipeRamasseur2() + "', "
                + "'" + nouveauMatch.getArbitreLigne1()    + "', "
                + "'" + nouveauMatch.getArbitreFilet()     + "', "
                + "'" + nouveauMatch.getArbitreChaise()    + "', "
                + "'" + nouveauMatch.getArbitreLigne2()    + "', "
                + "'" + nouveauMatch.getArbitreLigne3()    + "', "
                + "'" + nouveauMatch.getArbitreLigne4()    + "', "
                + "'" + nouveauMatch.getArbitreLigne5()    + "', "
                + "'" + nouveauMatch.getArbitreLigne6()    + "')";
        try{
            stmt = connexionBD.createStatement();      
            
            rset = stmt.executeQuery(insertTableSQL);
        } catch (SQLException ex) {
            Logger.getLogger(OracleJoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                stmt.close();
                rset.close();
            }catch(SQLException ex){
                Logger.getLogger(OracleJoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void setDataSource(DataSource ds) {
        OracleMatchDAO.ds = ds;
    }

    @Override
    public void setConnection(Connection c) {
        OracleMatchDAO.connexionBD = c;
    }

    @Override
    public void closeConnection(Connection c) throws SQLException {
        if (c!=null){
            c.close();
        }
    }

    @Override
    public List<Match> getLesMatchs(String type, String niveau, String nomCourt) { /* Méhode qui retourne une liste 
                                                                                    des matchs pour un type de match, un court et un niveau */
        List<Match> listeMatchs = null;
        ResultSet rset = null;
        Statement stmt = null;
        Match matchCourant;
          try{
            stmt = connexionBD.createStatement();
            listeMatchs = new ArrayList<>();
            rset = stmt.executeQuery("SELECT num_match, tranche_horaire_match, type_Match, participant1, participant2, equipe1, equipe2 FROM Match "
                                   + "WHERE niveau = '" + niveau + "' " 
                                   + "AND type_match = '" + type + "' "
                                   + "AND nom_court_match = '" + nomCourt + "'");
            while(rset.next()){ //Boucle pour chaque ligne
                matchCourant = new Match(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), 
                        rset.getString(5), rset.getString(6), rset.getString(7));
                listeMatchs.add(matchCourant);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OracleJoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                stmt.close();
                rset.close();
            }catch(SQLException ex){
                Logger.getLogger(OracleJoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listeMatchs;
    }    
}
