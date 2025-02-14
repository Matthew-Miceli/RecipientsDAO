package businesslayer;
import dataaccesslayer.RecipientDAO;
import dataaccesslayer.RecipientDAOImpl;
import java.sql.ResultSetMetaData;
import java.util.List;
import transferobjects.RecipientDTO;

public class RecipientBusinessLogic {

    private RecipientDAO recipientDao = null;
    private RecipientValidation validation = null;

    public RecipientBusinessLogic() {
        recipientDao = new RecipientDAOImpl();
        validation = new RecipientValidation();
    }

    public List<RecipientDTO> getAllRecipients() {
        return recipientDao.getAllRecipients();
    }

    public void addRecipient(RecipientDTO recipient) throws ValidationException {
        validation.cleanRecipient(recipient);
        validation.validateRecipient(recipient);
        recipientDao.createRecipient(recipient);
    }

    public void deleteRecipient(int recipientId) {
        recipientDao.deleteRecipient(recipientId);
    }

    public ResultSetMetaData getMetaData(){
        return recipientDao.getMetaData();
    }
}