package transferlayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author mattc
 */
public class DatabaseConnection {
    java.sql.Connection connection;
    
    public DatabaseConnection() {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("src/main/java/database.properties"));) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = props.getProperty("jdbc.url");//sets the url for the database
        String username = props.getProperty("jdbc.username");//sets the usersame for the database
        String password = props.getProperty("jdbc.password");//sets the password for the database
        
        try{
             connection = DriverManager.getConnection(url, username, password); 
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }   
    }
    
    public java.sql.Connection getConnection(){
        return connection;
    }
    
}
