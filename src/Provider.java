import java.util.ArrayList;
import java.util.List;

/**
 * Creates instance of a provider
 * @author: Reaghan
 */
public class Provider extends Person implements java.io.Serializable {

    private List<Service> services;
    /**
     * Create a new member.
     * @param id the provider ID
     * @param name the provider's name
     * @param address the provider's address
     * @param city the provider's city
     * @param state the provider's state
     * @param zipcode the provider's zipcode
     */
    public Provider(int id, String name, String address, String city, String state, String zipcode) {
        //super is used in Java to call the constructor of the parent class (Person in this case) (i think?)
        super(id, name, address, city, state, zipcode);

        this.services = new ArrayList<>();
    }

    public List<Service> getService() {
        return this.services;
    }

    /**
     * Set the provider service.
     * @param service  to set
     */
    public void setName(Service service) {
        this.services.add(service);
    }

    /**
     * Set the provider fee.
     * @param fee  to set
     */
    public void setFee(int fee) {
    }

    public void addService(Service service) { services.add(service); }

    public void getProviderInfo(){
        System.out.println(super.id);
        System.out.println(name);
        System.out.println(address);
        System.out.println(city);
        System.out.println(state);
        System.out.println(zipcode);
        //System.out.println(this.service.getname());
    }

}
