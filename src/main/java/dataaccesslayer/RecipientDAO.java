package dataaccesslayer;

import transferobjects.RecipientDTO;

import java.util.List;

public interface RecipientDAO {
    List<RecipientDTO> getAllRecipients();

}
