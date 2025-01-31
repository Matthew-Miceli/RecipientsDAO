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
 * @author mattc
 */
public class RecipientDAOImpl implements RecipientDAO {
    private Connection connection;

    public RecipientDAOImpl() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public List<RecipientDTO> getAllRecipients() {
        List<RecipientDTO> recipients = new ArrayList<>();
        String sql = "SELECT * FROM Recipients";

        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

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

        return recipients;
    }

    @Override
    public void deleteRecipient(int recipientId) {
        String sql = "DELETE FROM RECIPIENTS WHERE AwardId = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, recipientId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createRecipient(Recipient recipient) {
        String sql = "INSERT INTO RECIPIENTS(AwardId, Name, Year, City, Category) VALUES(?, ?, ?, ?, ?)";

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
