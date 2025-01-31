package transferlayer;

import entity.Recipient;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import utils.RecipientsMapper;

/**
 *
 * @author mattc
 */
public class RecipientDAO {
    List<Recipient> recipients = null;
    private DatabaseConnection connection;

    public List<RecipientDTO> getAllRecipients() {
        
        try (
                PreparedStatement myStmt = connection.getConnection().prepareStatement("SELECT * FROM recipients", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
            try (
                    ResultSet resultSet = myStmt.executeQuery();//Runs the SQL query
                    ) {

                while (resultSet.next()) {
                    recipients.add(
                            new Recipient(
                                    resultSet.getInt("Id"),
                                    resultSet.getString("Name"),
                                    resultSet.getInt("Year"),
                                    resultSet.getString("City"),
                                    resultSet.getString("Category")
                            )
                    );
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipients.stream().map(RecipientsMapper::toRecipientDTO).collect(Collectors.toList());
    }
}
