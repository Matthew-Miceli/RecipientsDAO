package businesslayer;

import transferobjects.RecipientDTO;


public class RecipientValidation {

    private static final int NAME_MAX_LENGTH = 60;
    private static final int MAX_CATEGORY_LENGTH = 60;
    private static final int MAX_CITY_LENGTH = 60;

    protected void cleanRecipient(RecipientDTO recipient) {
        if (recipient.getName() != null) {
            recipient.setName(recipient.getName().trim());
        }
        if (recipient.getCategory() != null) {
            recipient.setCategory(recipient.getCategory().trim());
        }
        if (recipient.getCity() != null) {
            recipient.setCity(recipient.getCity().trim());
        }
    }

    protected void validateRecipient(RecipientDTO recipient) throws ValidationException {
        validateString(recipient.getName(), "Name", NAME_MAX_LENGTH, false);
        validateString(recipient.getCategory(), "Category", MAX_CATEGORY_LENGTH, false);
        validateString(recipient.getCity(), "City" , MAX_CITY_LENGTH , false);
    }

    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
            throws ValidationException {
        if (value == null && isNullAllowed) {
            //return; // null permitted, nothing to validate
        } else if (value == null && !isNullAllowed) {
            throw new ValidationException(String.format("%s cannot be null",
                    fieldName));
        } else if (value.length() == 0) {
            throw new ValidationException(String.format("%s cannot be empty or only whitespace",
                    fieldName));
        } else if (value.length() > maxLength) {
            throw new ValidationException(String.format("%s cannot exceed %d characters",
                    fieldName, maxLength));
        }
    }

}
