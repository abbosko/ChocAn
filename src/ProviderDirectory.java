import java.text.DecimalFormat;
import java.util.*;
/**
 * ProviderDirectory class, composed of services.
 *
 * @author justinliu
 *
 */
public class ProviderDirectory implements java.io.Serializable {

    List<Service> services = new ArrayList<>();

    /**
     * Adds service to the service list.
     *
     * @param service service that is getting added
     */
    public void addService(Service service) {
        services.add(service);
    }

    /**
     * Searches services to match the code to a service name.
     *
     * @param code service code getting searched to find service name
     *
     * @return null
     */
    public Service searchByCode(int code) {
        for(Service service : services) {
            if (code == service.getCode()) {
                return service;
            }
        }
        return null;
    }

    /**
     * Displays the provider directory in alphabetical order.
     */
    public void displayDirectory() {

        //alphabetically sorts the list of services
        Collections.sort(services, new SortByServiceName());

        //displays the list of services
        System.out.println("Displaying Provider Directory...");
        System.out.println("Name   Code   Fee");
        DecimalFormat df = new DecimalFormat("0.00");
        for(Service service : services) {
            System.out.println(service.getName() + "   " + service.getCode() + "   " + df.format(service.getFee()));
        }
    }



}
