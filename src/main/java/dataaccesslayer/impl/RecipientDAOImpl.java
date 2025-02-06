package dataaccesslayer.impl;

import dataaccesslayer.DatabaseConnection;
import dataaccesslayer.RecipientDAO;
import entity.Recipient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import transferobjects.RecipientDTO;
import utils.RecipientMapper;

/**
 * This class implements RecipientDAO and contains all the implementations to the methods
 * @author mattc
 */
public class RecipientDAOImpl implements RecipientDAO {
    private Connection connection;

    /**
     * When a recipientDAO is created, create a connection to the database to be able to use the methods.
     */
    public RecipientDAOImpl() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    /**
     * This method uses a SQL statement to retrieve all the recipients from the sql database.
     * @return recipients a list of recipients
     */
    public List<RecipientDTO> getAllRecipients() {
        List<RecipientDTO> recipients = new ArrayList<>();
        String sql = "SELECT * FROM Recipients";//SQL statement to retrieve all recipients

        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            //For every resultSet, create an Employee and add it to the list of recipients.
            while (resultSet.next()) {
                Recipient recipient = new Recipient(
                        resultSet.getInt("AwardId"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Year"),
                        resultSet.getString("City"),
                        resultSet.getString("Category")
                );

                recipients.add(RecipientMapper.toRecipientDTO(recipient));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipients; //Returns the list of recipients
    }

    /**
     * This method takes an id as a parameter and deletes the recipient from the database
     * @param recipientId The id of the recipient
     */
    @Override
    public void deleteRecipient(int recipientId) {
        String sql = "DELETE FROM RECIPIENTS WHERE AwardId = ?";//SQL statement

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, recipientId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method takes a recipient as a parameter and adds that recipient to the database using a sql query and prepared statement
     * @param recipient the recipient to be added to the database
     */
    @Override
    public void createRecipient(Recipient recipient) {
        String sql = "INSERT INTO RECIPIENTS(AwardId, Name, Year, City, Category) VALUES(?, ?, ?, ?, ?)";//SQL Statement

        try (
                PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            stmt.setInt(1, recipient.getId());
            stmt.setString(2, recipient.getName());
            stmt.setInt(3, recipient.getYear());
            stmt.setString(4, recipient.getCity());
            stmt.setString(5, recipient.getCategory());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
