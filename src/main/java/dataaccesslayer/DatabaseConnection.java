package dataaccesslayer;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author mattc
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

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

    public static synchronized DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

}
