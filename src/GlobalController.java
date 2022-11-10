import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GlobalController implements java.io.Serializable {

    private PersonData data = new PersonData();
    protected ProviderDirectory directory = new ProviderDirectory();

    public void add(Member mem)
    {
        data.members.put(mem.id, mem);
    }

    public boolean deleteMember(int id)
    {
        if (verifyMemberID(id)) {
            data.members.remove(id);
            return true;
        } else {
            return false;
        }
    }

    public void editMember(int id, int option, String input)
    {
        Member mem = data.members.get(id);
        switch(option)
        {
            //Name
            case 1:
                mem.name = input;
                break;
            //Address
            case 2:
                mem.address = input;
                break;
            //City
            case 3:
                mem.city = input;
                break;
            //State
            case 4:
                mem.state = input;
                break;
            //Zipcode
            case 5:
                mem.zipcode = input;
                break;
        }
    }

    public void add(Provider p)
    {
        data.providers.put(p.id, p);
    }

    public boolean deleteProvider(int id)
    {
        if (verifyProviderID(id)) {
            data.providers.remove(id);
            return true;
        } else {
            return false;
        }
    }


    public void editProvider(int id, int option, String input)
    {
        Provider p = data.providers.get(id);
        switch(option)
        {
            //Name
            case 1:
                p.name = input;
                break;
            //Address
            case 2:
                p.address = input;
                break;
            //City
            case 3:
                p.city = input;
                break;
            //State
            case 4:
                p.state = input;
                break;
            //Zipcode
            case 5:
                p.zipcode = input;
                break;
        }
    }

    public boolean verifyMemberID(int id)
    {
        //checking to see if provider exists in map
        Member m = data.members.get(id);
        if (m != null) {
            return true;
        } else {
            return false;
        }
    }

    public String verifyMemberIdAndStatus(int id)
    {

        Member m = data.members.get(id);
        if (m != null) {
            if (m.getStatus()) {
                return "Validated";
            }
            else {
                return "Member suspended.";
            }
        }

        return "Invalid number.";
    }

    public Member getMember(int id) {
        Member m = data.members.get(id);
        if (m != null) {
            return m;
        } else {
            System.out.println("Member not found");
            return null;
        }
    }

    public Provider getProvider(int id) {
        Provider p = data.providers.get(id);
        if (p != null) {
            return p;
        } else {
            System.out.println("Provider not found");
            return null;
        }
    }


    public boolean verifyProviderID(int id)
    {
        //checking to see if provider exists in map
        Provider p = data.providers.get(id);
        if (p != null) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumMembers()
    {
        return data.getNumMembers();
    }

    public int getNumProviders()
    {
        return data.getNumProviders();
    }

    public void printAllMembers()
    {
        data.printMembers();
    }

    public void printAllProviders() { data.printProviders();}


    //Provider Functions
    public void displayDirectory() {
        directory.displayDirectory();
    }

    public Service lookUpService() {
        Scanner input = new Scanner(System.in);

        //Provider uses Provider Directory to enter proper code of the service
        directory.displayDirectory();
        System.out.println("Enter service code");
        int serviceCode = input.nextInt();

        //Searches the provider directory for the corresponding service
        Service service = null;
        service = directory.searchByCode(serviceCode);
        while(service == null) {
            System.out.println("Invalid service code\n");
            System.out.println("Enter service code");
            serviceCode = input.nextInt();
            service = directory.searchByCode(serviceCode);
        }

        return service;
    }


    public void billChocAn(Member member, Provider provider) {

        //Provider keys in date of service provided
        System.out.println("Enter in the date that the service was provided (MM-DD-YYYY).");
        Scanner scan = new Scanner(System.in);
        String dateOfService = scan.nextLine();

        //Finds service from the code entered
        Service service = lookUpService();

        //Displays name of service, asking for verification
        System.out.println(service.getName());
        System.out.println("Is this the correct service? Enter 1 if yes, or 0 if no");
        int verification = scan.nextInt();

        while(verification == 0) {
            service = lookUpService();
            System.out.println(service.getName());
            System.out.println("Is this the correct service? Enter 1 if yes, or 0 if no");
            verification = scan.nextInt();
        }

        //Provider can enter comments about the service provided
        scan.nextLine();
        System.out.println("Enter any comments about the service provided (100 characters). If none, press enter.");
        String providerComments = scan.nextLine();

        //Software writes record to disk (prints to terminal)
        System.out.println("Printing service record...\n");
        System.out.println("Date of Service: " + dateOfService);
        System.out.println("Provider Number: " + provider.id);
        System.out.println("Member Number: " + member.id);
        System.out.println("Service Code: " + service.getCode());
        System.out.println("Comments:\n" + providerComments + "\n");

        //Software displays fee of service
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Service Fee: $" + df.format(service.getFee()) + "\n");

        //Provider enters information on form
        System.out.println("Please Complete the Verification Form:");
        System.out.println("The current date and time (MM-DD-YYYY HH:MM:SS):");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        System.out.println("Enter the date the service was provided (MM-DD-YYYY):");
        String verifyDateOfService = scan.nextLine();
        while (!verifyDateOfService.equals(dateOfService)) {
            System.out.println("Date of service does not match");
            System.out.println("Enter the date the service was provided (MM-DD-YYYY):");
            verifyDateOfService = scan.nextLine();
        }

        System.out.println("Enter member name:");
        String memberName = scan.nextLine();
        while (!memberName.equals(member.name)) {
            System.out.println("Member name does not match");
            System.out.println("Enter member name:");
            memberName = scan.nextLine();
        }

        System.out.println("Enter member number:");
        int memberNum = scan.nextInt();
        while (memberNum != member.id) {
            System.out.println("Member number does not match");
            System.out.println("Enter member number:");
            memberNum = scan.nextInt();
        }

        System.out.println("Enter service code:");
        int serviceCode = scan.nextInt();
        while (serviceCode != service.getCode()) {
            System.out.println("Service code does not match");
            System.out.println("Enter service code:");
            serviceCode = scan.nextInt();
        }

        System.out.println("Enter fee to be paid:");
        float serviceFee = scan.nextFloat();
        while (serviceFee != service.getFee()) {
            System.out.println("Service fee does not match");
            System.out.println("Enter fee to be paid:");
            serviceFee = scan.nextFloat();
        }

        //Adds service to the member and provider
        member.addService(service);
        provider.addService(service);

        System.out.println("Successfully Billed");

    }

    // added Report Controller functions here
    public void displayReports() {
        MemberReport memberReport = new MemberReport();
        memberReport.generateMemberRpt(data);
        ProviderReport providerReport = new ProviderReport();
        providerReport.generateProviderRpt(data);
        EftReport eftReport = new EftReport();
        eftReport.generateEftTReport();
        SummaryReport summaryReport = new SummaryReport();
        summaryReport.generateSummaryReport(data, getNumProviders());

    };

    public void managerReport() {
        SummaryReport summaryReport = new SummaryReport();
        summaryReport.generateSummaryReport(data, getNumProviders());
        summaryReport.exportSumRpt();
    }

    public void exportReports() {
        MemberReport memberReport = new MemberReport();
        String message1 = memberReport.exportMemberReport();
        ProviderReport providerReport = new ProviderReport();
        String message2 = providerReport.exportProviderReport();
        EftReport eftReport = new EftReport();
        String message3 = eftReport.exportEftReport();
        SummaryReport summaryReport = new SummaryReport();
        String message4 = summaryReport.exportSumRpt();

        System.out.println(message1);
        System.out.println(message2);
        System.out.println(message3);
        System.out.println(message4);
        System.out.println("");
    };



}