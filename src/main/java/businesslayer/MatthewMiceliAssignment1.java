package businesslayer;

import dataaccesslayer.impl.RecipientDAOImpl;
import transferobjects.RecipientDTO;
import java.util.List;

/**
 * @author mattc
 */
public class MatthewMiceliAssignment1 {

    public static void main(String[] args) {
        RecipientDAOImpl employeeDAO = new RecipientDAOImpl();

        System.out.println("\n--- Recipients Table --- ");
        displayRecipients(employeeDAO.getAllRecipients());
    }

    public static void displayRecipients(List<RecipientDTO> recipients) {
        if (recipients.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        int idMax = "Id".length();
        int nameMax = "Name".length();
        int yearMax = "Year".length();
        int cityMax = "City".length();
        int categoryMax = "Category".length();

        for (RecipientDTO r : recipients) {
            idMax = Math.max(idMax, String.valueOf(r.getId()).length());
            nameMax = Math.max(nameMax, r.getName().length());
            yearMax = Math.max(yearMax, String.valueOf(r.getYear()).length());
            cityMax = Math.max(cityMax, r.getCity().length());
            categoryMax = Math.max(categoryMax, r.getCategory().length());
        }

        String format = "%-" + (idMax + 2) + "s"
                + "%-" + (nameMax + 2) + "s"
                + "%-" + (yearMax + 2) + "s" +
                "%-" + (cityMax + 2) + "s" +
                "%-" + (categoryMax + 2) + "s%n";

        System.out.printf(format, "ID", "Name", "Year", "City", "Category");
        System.out.println();
        System.out.println("-".repeat(idMax + nameMax + yearMax + cityMax + categoryMax));

        for(RecipientDTO r: recipients){
            System.out.printf(format, String.valueOf(r.getId()), r.getName(), String.valueOf(r.getYear()), r.getCity(), r.getCategory());
        }

    }
}
