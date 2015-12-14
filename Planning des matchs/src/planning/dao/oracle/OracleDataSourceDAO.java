package planning.dao.oracle;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;

public class OracleDataSourceDAO extends OracleDataSource {
    private static OracleDataSourceDAO ods;
    
    private OracleDataSourceDAO() throws SQLException {
        
    }
    
    public static OracleDataSourceDAO getOracleDataSourceDAO(){
        FileInputStream fichier = null;
        try{
            Properties props = new Properties();
            fichier = new FileInputStream(".\\src\\planning\\dao\\oracle\\connexion.properties");
                props.load(fichier);
                ods = new OracleDataSourceDAO();
                ods.setDriverType(props.getProperty("pilote"));
                ods.setPortNumber(new Integer(props.getProperty("port")));
                ods.setServiceName(props.getProperty("service"));
                ods.setUser(props.getProperty("user"));
                ods.setPassword(props.getProperty("pwd"));
                ods.setServerName(props.getProperty("serveur"));
                return ods;
            } catch (SQLException | IOException ex){
                
            }
            finally{
                try{
                    fichier.close();
                }catch(IOException ex){
            }
        }
        return ods ;
    }
}
