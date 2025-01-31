package utils;

import entity.Recipient;
import transferobjects.RecipientDTO;

/**
 *
 * @author mattc
 */
public class RecipientMapper {
    
    
    public static Recipient toRecipient(RecipientDTO recipientDTO){
        if(recipientDTO == null){
            return null;
        }
        return new Recipient(
                recipientDTO.getId(),
                recipientDTO.getName(),
                recipientDTO.getYear(),
                recipientDTO.getCity(),
                recipientDTO.getCategory()
        );
    }
    
    public static RecipientDTO toRecipientDTO(Recipient recipient){
        if(recipient == null){
            return null;
        }
        return new RecipientDTO(
                recipient.getId(),
                recipient.getName(),
                recipient.getYear(),
                recipient.getCity(),
                recipient.getCategory()
        );
    }
}
