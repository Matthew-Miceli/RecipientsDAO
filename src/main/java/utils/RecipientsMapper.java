package utils;

import entity.Recipient;
import transferlayer.RecipientDTO;

/**
 *
 * @author mattc
 */
public class RecipientsMapper {
    
    
    public Recipient toRecipient(RecipientDTO recipientDTO){
        return new Recipient(
                recipientDTO.getId(),
                recipientDTO.getName(),
                recipientDTO.getYear(),
                recipientDTO.getCity(),
                recipientDTO.getCategory()
        );
    }
    
    public RecipientDTO toRecipientDTO(Recipient recipient){
        return new RecipientDTO(
                recipient.getId(),
                recipient.getName(),
                recipient.getYear(),
                recipient.getCity(),
                recipient.getCategory()
        );
    }
}
