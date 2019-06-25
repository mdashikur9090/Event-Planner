package event.planner.controlar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class DatabaseConfiguration {
    
    private  final String driver = "com.mysql.jdbc.Driver";
    private  final String url = "jdbc:mysql://localhost/event_planner";
    private  final String user = "root";
    private  final String pass = "";
    
    public Connection con = null;
    public static Statement statement =null;

    public DatabaseConfiguration() {
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            statement = con.createStatement();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
}
