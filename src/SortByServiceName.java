import java.util.*;
/**
 * SortByServiceName class, alphabetically sorts the list of services.
 *
 * @author justinliu
 */
public class SortByServiceName implements Comparator<Service> {
    public int compare(Service s1, Service s2) {
        String s1Name, s2Name;
        s1Name = s1.getName();
        s2Name = s2.getName();

        return s1Name.compareTo(s2Name);
    }

}
