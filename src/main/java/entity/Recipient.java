package entity;

/**
 * This class holds all the properties of a recipient and all of its setters and getters.
 * @author mattc
 */
public class Recipient {

    private int id;
    private String name;
    private int year;
    private String city;
    private String category;

    /**
     * No args constructor
     * Not Used.
     */
    public Recipient() {
    }

    /**
     * All args constructor
     * @param id id of recipient
     * @param name name of recipient
     * @param year year of appointment of recipient
     * @param city city of recipient
     * @param category category of recipient
     */
    public Recipient(int id, String name, int year, String city, String category) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.city = city;
        this.category = category;
    }

    /**
     * returns id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * sets id
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns year
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * sets year
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * returns city
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * sets city
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * returns category
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * sets category
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

}
