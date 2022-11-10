/**
 * Person Class.
 *
 * @author Abbie Bosko
 */
public class Person implements java.io.Serializable  {
    //fields need to be protected (not private) so subclasses (Member, Provider) can access them
    protected String name;
    protected int id;
    protected String address;
    protected String city;
    protected String state;
    protected String zipcode;
    /**
     * Function to create Person.
     *
     * @param id Id number of person.
     * @param name Name of person.
     * @param address Address of person.
     * @param city City of person.
     * @param state State of person.
     * @param zipcode Zipcode of person.
     */

    public Person(int id, String name, String address, String city, String state, String zipcode) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
