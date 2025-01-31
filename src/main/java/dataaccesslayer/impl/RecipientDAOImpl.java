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
 *
 * @author mattc
 */
public class RecipientDAOImpl implements RecipientDAO {
    private Connection connection;

    public RecipientDAOImpl(){
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public List<RecipientDTO> getAllRecipients() {
        List<RecipientDTO> recipients = new ArrayList<>();
        String sql = "SELECT * FROM Recipients";

        try(Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while(resultSet.next()){
                Recipient recipient = new Recipient(
                        resultSet.getInt("AwardId"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Year"),
                        resultSet.getString("City"),
                        resultSet.getString("Category")
                );

                recipients.add(RecipientMapper.toRecipientDTO(recipient));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return recipients;
    }
}
