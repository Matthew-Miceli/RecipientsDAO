package dataaccesslayer;

import entity.Recipient;
import transferobjects.RecipientDTO;

import java.util.List;

public interface RecipientDAO {
    List<RecipientDTO> getAllRecipients();
    void deleteRecipient(int recipientId);
    void createRecipient(Recipient recipient);
}
