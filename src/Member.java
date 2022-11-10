import java.util.ArrayList;
import java.util.List;
/**
 * Member Class. Extension from Person. Also implements java's serialize class for persistence.
 *
 * @author Sani Ghulamani
 */

public class Member extends Person implements java.io.Serializable {

    private List<Service> services;
    private boolean status;

    /**
     * Constructor for Member.
     *
     * @param id id number of member.
     * @param name name of member.
     * @param address address of member.
     * @param city city of member.
     * @param state state of member.
     * @param zipcode status of member.
     * @param status status of member.
     */

    public Member(int id, String name, String address, String city, String state, String zipcode, boolean status) {
        //super is used in Java to call the constructor of the parent class (Person in this case) (i think?)
        super(id, name, address, city, state, zipcode);

        this.services = new ArrayList<>();
        this.status = status;
    }

    public List<Service> getService() {
        return this.services;
    }

    public boolean getStatus()
    {
        return this.status;
    }

    public void addService(Service service) { services.add(service); }

}