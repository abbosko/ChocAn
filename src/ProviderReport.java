import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Generates provider reports.
 *
 * @author Sydney Pierce
 */
public class ProviderReport {

    /**
     * Called from generateProviderRpt to print provider info.
     *
     * @param pvd1 provider that report is about
     */
    public void printPvdRpt(Provider pvd1) {
        List<Service> pvdServices = pvd1.getService();  //gets pvd1's service list
        int numOfServices = pvdServices.size();
        float totalFee = 0.0f;
        DecimalFormat df = new DecimalFormat("0.00"); //format to 2 dec places

        System.out.println("Name: " + pvd1.name);
        System.out.println("ID: " + pvd1.id);
        System.out.println("Address: " + pvd1.address);
        System.out.println("City: " + pvd1.city);
        System.out.println("State: " + pvd1.state);
        System.out.println("Zipcode: " + pvd1.zipcode);
        for(Service temp : pvdServices) {
            System.out.println("Date of Service: 12-01-2021");

            //date & time received by computer
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println("Date & Time Received: " + dtf.format(now));

            System.out.println("    Service Code: " + temp.getCode());    //tab over for format
//            numOfServices++;
            System.out.println("    Fee: " + df.format(temp.getFee()));
            totalFee += temp.getFee();
        }

        System.out.println("Total Num Consultations: " + numOfServices);
        System.out.println("Total Fee: " + df.format(totalFee));
        System.out.println("");
    }

    /**
     * GenerateProviderRpt creates provider reports for all providers.
     *
     * @return string indicating report is generated
     *
     * @param per person data so we can get the hashmap of providers
     */
    public String generateProviderRpt(PersonData per) {
        String provMessage = "Provider Report: " + System.lineSeparator();
        System.out.println(provMessage);
        HashMap<Integer, Provider> pvdHM = per.getProviders();   //pvdHM is provider hashmap

//        for(HashMap.Entry<Integer, Provider> entry : pvdHM.entrySet()) {    //iterate through all pvds
            pvdHM.forEach((id, pvd) -> printPvdRpt(pvd));
//        }
        return ("Provider report generated.");
    }

    /**
     * Shows success of export.
     *
     * @return string indicating success
     */
    public String exportProviderReport() {
        return "Provider report exported.";
    }
}
