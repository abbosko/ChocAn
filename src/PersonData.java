import java.util.HashMap;
import java.util.Map;

public class PersonData implements java.io.Serializable  {
    protected HashMap<Integer, Member> members = new HashMap<>();
    protected HashMap<Integer, Provider> providers = new HashMap<>();

    public HashMap<Integer, Member> getMembers() {
        return members;
    }
    public HashMap<Integer, Provider> getProviders() {
        return providers;
    }

    public int getNumMembers() {
        return members.size();
    }
    public int getNumProviders() {
        return providers.size();
    }

    public void printMembers()
    {
        Map<Integer, Member> hm = members;
        hm.forEach((key, value) -> System.out.println(key + ": " + value.name));
    }

    public void printProviders()
    {
        Map<Integer, Provider> hp = providers;
        hp.forEach((key, value) -> System.out.println(key + ": " + value.name));
    }


}
