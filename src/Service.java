/**
 * Service Class.
 *
 * @author Abbie Bosko
 */
public class Service implements java.io.Serializable {

    private String serviceName;
    private int serviceCode;
    private float serviceFee;


    /**
     * Function to create Service.
     *
     * @param serviceName Name of service.
     * @param serviceCode Code for service.
     * @param serviceFee Dollar amount of service fee.
     */
    public Service(String serviceName, int serviceCode, float serviceFee) {
        int maxLength = 20;
        if (serviceName.length() > maxLength){
            serviceName = serviceName.substring(0,maxLength);
        }

        this.serviceName = serviceName;
        this.serviceCode = serviceCode;
        this.serviceFee = serviceFee;
    }
    /**
     * Function to get service code.
     *
     * @return Service code.
     */

    public int getCode() {
        return this.serviceCode;
    }
    /**
     * Function to get service fee amount.
     *
     * @return Amount of service fee.
     */

    public float getFee() {
        return this.serviceFee;
    }
    /**
     * Function to get name of service.
     *
     * @return Name of service.
     */

    public String getName() {
        return this.serviceName;
    }



}
