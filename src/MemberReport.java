import java.util.HashMap;
import java.util.List;

/**
* Generates member reports.
 *
* @author Sydney Pierce
 */
public class MemberReport {

    /**
     * Called from generateMemberRpt to print member info.
     *
     * @param mem1 member that report is about
     */
    public void printMemRpt(Member mem1) {

        List<Service> memServices = mem1.getService();  //gets mem1's service list

        System.out.println("Name: " + mem1.name);
        System.out.println("ID: " + mem1.id);
        System.out.println("Address: " + mem1.address);
        System.out.println("City: " + mem1.city);
        System.out.println("State: " + mem1.state);
        System.out.println("Zipcode: " + mem1.zipcode);
        for(Service temp : memServices) {
            System.out.println("Date of Service: 12-01-2021");

            //

            System.out.println("    Service Name: " + temp.getName());    //tab over for format
        }
        System.out.println("");
    }


    /**
     * GenerateMemberRpt generates member reports for all members.
     *
     * @return string indicating the report is generated
     *
     * @param per person data so we can get the hashmap of members
     */
    public String generateMemberRpt(PersonData per) {
        String memMessage = "Member Report: " + System.lineSeparator();
        System.out.println(memMessage);
        HashMap<Integer, Member> memHM = per.getMembers();   //memHM is provider hashmap

//        for(HashMap.Entry<Integer, Member> entry : memHM.entrySet()) {    //iterate through all mems
            memHM.forEach((id, mem) -> printMemRpt(mem));
//        }
        return "Member report generated";
    }

    /**
     * ExportMemberReport shows success of export.
     *
     * @return string indicating success of export
     */
    public String exportMemberReport() {
        return "Member report exported.";
    }
}
