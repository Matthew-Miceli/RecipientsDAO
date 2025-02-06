package dataaccesslayer;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This is a singleton class, used to create a thread safe connection to the database.
 * @author mattc
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    /**
     * No args constructor used to load database properties from database.properties file and to create the connection
     */
    private DatabaseConnection(){
        try{
            Properties props = new Properties();
            try(InputStream in = Files.newInputStream(Paths.get("src/database.properties"))) {
                props.load(in);
            }catch (Exception e){
                e.printStackTrace();
            }

            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    /**
     * Checks if an instance of the connection already exists, if it does will return that instance, if not will create a new one.
     * @return instance returns the current instance
     */
    public static synchronized DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }

        return instance;
    }

    /**
     * Returns the connection to the database
     * @return Connection the connection to the database
     */
    public Connection getConnection(){
        return connection;
    }
}
