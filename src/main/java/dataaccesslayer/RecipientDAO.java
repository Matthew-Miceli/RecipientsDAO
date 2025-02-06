package dataaccesslayer;

import entity.Recipient;
import transferobjects.RecipientDTO;

import java.util.List;

/**
 * This interface holds all the need to implement methods for RecipientDAOImpl
 */
public interface RecipientDAO {
    List<RecipientDTO> getAllRecipients();
    void deleteRecipient(int recipientId);
    void createRecipient(Recipient recipient);
}
