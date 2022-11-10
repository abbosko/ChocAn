import java.text.DecimalFormat;
import java.util.*;

/**
 * Summary Report Class.
 *
 * @author Brandon Nguyen
 */
public class SummaryReport {
    int totNumServ = 0;
    int numProv = 0;
    float absTotalFee = 0.0f;

    DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Function to print summary report.
     *
     * @param prvd provider that report is about
     */
    public void printSumRpt(Provider prvd) {
        List<Service> pvdServices = prvd.getService();
        int numOfServices = pvdServices.size();
//        int totNumServ = 0;
        float totalFees = 0.0f;
//        float absTotalFee = 0.0f;
        System.out.println("Name: " + prvd.name);
        System.out.println("Number of  Consultations: " + numOfServices);
            for(Service sub: pvdServices) {
                System.out.println(" Service Code: " + sub.getCode());
//                numOfServices++;
                System.out.println(" Fee: " + df.format(sub.getFee()));
                totalFees += sub.getFee();
                numProv++;
                totNumServ++;
                absTotalFee += sub.getFee();
            }
        System.out.println("Total fees for them: " + df.format(totalFees));
        System.out.println("");
    }

    /**
     * GenerateSummaryReport creates summary report.
     *
     * @param per person data so we can get the hashmap of providers
     * @param numProviders number of providers on summary report.
     */

    public String generateSummaryReport(PersonData per, int numProviders) {
        String sumMessage = "Summary Report: " + System.lineSeparator();
        System.out.println(sumMessage);
        HashMap<Integer, Provider> prov = per.getProviders();
        prov.forEach((id, pvd) -> printSumRpt(pvd));
        System.out.println("Total number of providers: " + numProviders);
        System.out.println("Total number of Consultations: " +totNumServ);
        System.out.println("Total fees: " + df.format(absTotalFee));
        /*
        */
        return("Summary Report Generated.");
    }
    /**
     * Shows success of export.
     *
     * @return string indicating success
     */
    public String exportSumRpt() {
        return "Summary Report Exported.";
    }
}
