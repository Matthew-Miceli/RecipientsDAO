package dataaccesslayer;

import java.sql.ResultSetMetaData;
import transferobjects.RecipientDTO;
import java.util.List;

/**
 * This interface holds all the need to implement methods for RecipientDAOImpl
 */
public interface RecipientDAO {
    /**
     * Gets all of the recipients
     * @return recipients, a list of recipientDTOs
     */
    List<RecipientDTO> getAllRecipients();
    /**
     * Deletes a recipient
     * @param recipientId the id of the recipient
     */
    void deleteRecipient(int recipientId);
    /**
     * Creates recipient
     * @param recipient recipient
     */
    void createRecipient(RecipientDTO recipient);
    /**
     * Gets the meta data of the result set
     * @return meta data of result set
     */
    ResultSetMetaData getMetaData();
}
