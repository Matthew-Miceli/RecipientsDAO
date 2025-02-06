package utils;

import entity.Recipient;
import transferobjects.RecipientDTO;

/**
 * This class maps Recipients to RecipientDTOs and vice versa.
 * @author mattc
 */
public class RecipientMapper {

    /**
     * This method takes a recipientDTO and maps it to a recipient
     * @param recipientDTO A recipient data transfer object
     * @return recipient A Recipient object
     */
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

    /**
     * This method takes a recipient and maps it to a recipientDTO
     * @param recipient A recipient object
     * @return recipientDTO A Recipient data transfer object
     */
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
