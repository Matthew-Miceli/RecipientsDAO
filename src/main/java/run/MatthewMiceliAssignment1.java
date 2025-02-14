package run;
import businesslayer.RecipientBusinessLogic;
import businesslayer.ValidationException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import transferobjects.RecipientDTO;
import java.util.List;

/**
 * This class is in charge of retrieving and displaying all the recipients data
 * and creating and deleting 1 test instance.
 *
 * @author mattc
 */
public class MatthewMiceliAssignment1 {

    static int idMax;
    static int nameMax;
    static int yearMax;
    static int cityMax;
    static int categoryMax;

    /**
     * No args constructor. Not used
     */
    public MatthewMiceliAssignment1() {
    }

    /**
     * This method is the beginning of execution for the program.
     *
     * @param args not used
     */
    public static void main(String[] args) throws ValidationException {
        RecipientBusinessLogic logic = new RecipientBusinessLogic(); //Instantiate new recipient DAO to get access to all data access methods

        RecipientDTO testRecipient = new RecipientDTO(70, "Matthew Miceli", 2004, "Ottawa", "Studies");// Test recipient

        System.out.println("\n--- Recipients Table --- ");//Heading
        displayRecipients(logic.getAllRecipients());//Calls recipientDAO and retrieves a list of recipients and sends them to display recipient

        System.out.println("\nCreating Test Recipient...");//Heading
        logic.addRecipient(testRecipient);//Creates new recipient using the test Recipient
        displayRecipients(logic.getAllRecipients());

        System.out.println("\nDeleting Test Recipient...");//Heading
        logic.deleteRecipient(testRecipient.getId());//Deleting test recipient using its ID
        displayRecipients(logic.getAllRecipients());

        displayMetaData(logic.getMetaData());

    }

    /**
     * This method is in charge of displaying all information related to
     * recipients.sS
     *
     * @param recipients list of recipients
     */
    public static void displayRecipients(List<RecipientDTO> recipients) {

        //Checks if the list of recipients if empty
        if (recipients.isEmpty()) {
            System.out.println("No Recipients Found.");
            return;
        }

        idMax = "Id".length();
        nameMax = "Name".length();
        yearMax = "Year".length();
        cityMax = "City".length();
        categoryMax = "Category".length();

        //Lists through all recipients and gets the max length for each column for proper formatting
        for (RecipientDTO r : recipients) {
            idMax = Math.max(idMax, String.valueOf(r.getId()).length());
            nameMax = Math.max(nameMax, r.getName().length());
            yearMax = Math.max(yearMax, String.valueOf(r.getYear()).length());
            cityMax = Math.max(cityMax, r.getCity().length());
            categoryMax = Math.max(categoryMax, r.getCategory().length());
        }

        //This String is used for formatting when printing the column names and instances.
        String format = "%-" + (idMax + 2) + "s"
                + "%-" + (nameMax + 2) + "s"
                + "%-" + (yearMax + 2) + "s"
                + "%-" + (cityMax + 2) + "s"
                + "%-" + (categoryMax + 2) + "s%n";

        //Prints Column names
        System.out.printf(format, "ID", "Name", "Year", "City", "Category");
        System.out.println();
        System.out.println("-".repeat(idMax + nameMax + yearMax + cityMax + categoryMax));

        //Loops through all recipients and prints out a row for each one using the format string defined previously
        for (RecipientDTO r : recipients) {
            System.out.printf(format, String.valueOf(r.getId()), r.getName(), String.valueOf(r.getYear()), r.getCity(), r.getCategory());
        }
    }
   
    /**
     * Displays all of the meta data for the recipients table
     * @param metaData meta data for recipients table
     */
    public static void displayMetaData(ResultSetMetaData metaData) {
        try {
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("\nPrintint Meta Data for Recipients Table");
            //Prints out all columns names, types and class names.
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-20s", metaData.getColumnName(i));
                System.out.printf("%-8s", metaData.getColumnTypeName(i));
                System.out.printf("%-8s", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }
            System.out.println();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
