import java.io.*;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    // Using Scanner to get Input from User
    static Scanner input = new Scanner(System.in);

    //"global" data instance
    static GlobalController globalController = new GlobalController();

    public static void main(String[] args){

        persistenceIn();

        mainMenu();

        // closing scanner
        input.close();

        persistenceOut();
        System.out.println("Saving Data and Exiting...");

    }//End of main

    private static void mainMenu()
    {
        int menuItem;
        String message = "Enter" + System.lineSeparator() +
                "1: for Operator " + System.lineSeparator() +
                "2: for Manager " + System.lineSeparator()  +
                "3: for Provider " + System.lineSeparator() +
                "4: for Run Main Accounting Procedure " + System.lineSeparator() +
                "5: to Exit" + System.lineSeparator();

        menuItem = printMessageAndGetMenuInput(message, 5);

        switch(menuItem)
        {
            case 1:
                operatorMenu();
                break;
            case 2:
                managerMenu();
                break;
            case 3:
                int id = printMessageAndGetIntInput("Enter Provider ID");
                if(globalController.verifyProviderID(id))
                {
                    Provider p = globalController.getProvider(id);
                    providerMenu(p);
                }
                else
                {
                    System.out.println("Invalid ID. Returning to Main Menu...");
                    mainMenu();
                }
                break;
            case 4:
                RunMainAcc();
                break;
            case 5:
                return;
        }
    }

    private static void printInvalid()
    {
        System.out.println("Invalid, please try again." + System.lineSeparator());
    }

    //constraint: must be sequential integer options from 1-numOptions
    private static int printMessageAndGetMenuInput(String message, int numOptions)
    {
        int menuItem;
        while(true)
        {
            System.out.println(message);

            try
            {
                menuItem = input.nextInt();

                if(menuItem<1 || menuItem>numOptions)
                {
                    printInvalid();
                    continue;
                }

                break;
            }
            catch(InputMismatchException e){
                printInvalid();
                input.nextLine();
            }
        }

        return menuItem;
    }

    private static String printMessageAndGetStringInput(String message)
    {
        String in;
        System.out.println(message);
        in = input.nextLine();
        return in;
    }

    private static Float printMessageAndGetFloatInput(String message)
    {
        float in;
        while(true)
        {
            System.out.println(message);

            try
            {
                in = input.nextFloat();
                break;
            }
            catch(InputMismatchException e){
                printInvalid();
                input.nextLine();
            }
        }

        return in;
    }

    private static int printMessageAndGetIntInput(String message)
    {
        int in;
        while(true)
        {
            System.out.println(message);

            try
            {
                in = input.nextInt();
                break;
            }
            catch(InputMismatchException e){
                printInvalid();
                input.nextLine();
            }
        }

        return in;
    }

    private static void operatorMenu()
    {
        int type;
        String message = "Operator Menu" + System.lineSeparator() +
                            "Enter" + System.lineSeparator() +
                            "1: for Member Data " + System.lineSeparator() +
                            "2: for Provider Data " + System.lineSeparator() +
                            "3: to View All Members" + System.lineSeparator() +
                            "4: to View All Providers" + System.lineSeparator() +
                            "5: to Exit Program " + System.lineSeparator();

        type = printMessageAndGetMenuInput(message, 5);

        switch(type)
        {
            case 3:
                globalController.printAllMembers();
                operatorMenu();
                return;
            case 4:
                globalController.printAllProviders();
                operatorMenu();
                return;
            case 5:
                return;
            default:
                break;
        }

        int option;
        message = "Enter" + System.lineSeparator() +
                "1: to Add" + System.lineSeparator() +
                "2: to Remove" + System.lineSeparator() +
                "3: to Edit" + System.lineSeparator();

        option = printMessageAndGetMenuInput(message, 3);

        switch (option)
        {
            case 1:
                addPerson(type);
                break;
            case 2:
                deletePerson(type);
                break;
            case 3:
                if (type==1)
                {
                    editMember();
                }
                else
                {
                    editProvider();
                }
                break;
        }

        operatorMenu();
    }


    private static void managerMenu()
    {
        int option;
        String message = "Enter" + System.lineSeparator() +
                "1: to Display Report" + System.lineSeparator() +
                "2: to Exit" + System.lineSeparator();

        option = printMessageAndGetMenuInput(message, 2);

        switch(option) {
            case 1:
                globalController.managerReport();
                break;
            case 2:
                return;
            default:
                break;
        }

        managerMenu();
    }

    private static void RunMainAcc() {
        int opt;
        String message = "Enter "+ System.lineSeparator() +
                "1: Display Reports" + System.lineSeparator() +
                "2: Export Reports" + System.lineSeparator() +
                "3: to Exit";

        opt = printMessageAndGetMenuInput(message, 3);
        switch(opt) {
            case 1:
                globalController.displayReports();
                break;
            case 2:
                globalController.exportReports();
                break;
            case 3:
                return;
            default:
                break;
        }
        RunMainAcc();
    }

    //type: 1->Member, 2->Provider
    private static void addPerson(int type)
    {
        String name;
        String address;
        String city;
        String state;
        String zipcode;
        int id;
        boolean status;

        //throwaway new line first
        input.nextLine();
        name = printMessageAndGetStringInput("Enter Name");
        address = printMessageAndGetStringInput("Enter Address");
        city = printMessageAndGetStringInput("Enter City");
        state = printMessageAndGetStringInput("Enter State");
        zipcode = printMessageAndGetStringInput("Enter Zipcode");

        if (type==1)
        {
            int statusFlag = printMessageAndGetIntInput("Enter 1 if member is valid or enter 0 if member is suspended");
            if (statusFlag == 1) {
                status = true;
            } else {
                status =  false;
            }
            //adding a constant so that the digits are always 9 digits
            id = globalController.getNumMembers() + 100000000;
            Member m = new Member(id, name, address, city, state, zipcode, status);
            globalController.add(m);
        }
        else
        {
            id = globalController.getNumProviders() + 100000000;
            Provider p = new Provider(id, name, address, city, state, zipcode);
            int serviceFlag = printMessageAndGetIntInput("Enter 1 to add a service or 0 to exit");
            while(serviceFlag == 1) {
                input.nextLine();
                String serviceName = printMessageAndGetStringInput("Enter the name of service");
                float serviceFee = printMessageAndGetFloatInput("Enter the service fee");
                int serviceCode = globalController.directory.services.size() + 100000;
                Service s = new Service(serviceName, serviceCode, serviceFee);
                globalController.directory.addService(s);
                serviceFlag = printMessageAndGetIntInput("Add another service? Enter 1 if yes or 0 to exit");
            }
            globalController.add(p);
        }

        System.out.println(System.lineSeparator() + "Successfully added." + System.lineSeparator());
    }


    private static void deletePerson(int type) {

        int id = printMessageAndGetIntInput("Enter ID to delete");
        boolean success;

        if (type==1)
        {
            success = globalController.deleteMember(id);
        }
        else
        {
            success = globalController.deleteProvider(id);
        }

        if (!success)
        {
            deletePerson(type);
        }
        else
        {
            System.out.println(System.lineSeparator() + "Successfully deleted." + System.lineSeparator());
        }
    }

    private static void editMember()
    {
        int id = printMessageAndGetIntInput("Enter ID to edit");
        if(!globalController.verifyMemberID(id))
        {
            System.out.println("Please try again.");
            editMember();
        }
        else
        {
            int option;
            String message = "Enter Field to Edit" + System.lineSeparator() +
                    "1: for Name" + System.lineSeparator() +
                    "2: for Address" + System.lineSeparator() +
                    "3: for City" + System.lineSeparator() +
                    "4: for State" + System.lineSeparator() +
                    "5: for Zipcode" + System.lineSeparator();

            option = printMessageAndGetMenuInput(message, 5);
            input.nextLine();
            String in = printMessageAndGetStringInput("Enter New Information");
            globalController.editMember(id, option, in);
            System.out.println(System.lineSeparator() + "Successfully edited." + System.lineSeparator());
        }
    }


    private static void editProvider()
    {
        int id = printMessageAndGetIntInput("Enter ID to edit");
        if(!globalController.verifyProviderID(id))
        {
            System.out.println("Please try again.");
            editProvider();
        }
        else
        {
            int option;
            String message = "Enter Field to Edit" + System.lineSeparator() +
                    "1: for Name" + System.lineSeparator() +
                    "2: for Address" + System.lineSeparator() +
                    "3: for City" + System.lineSeparator() +
                    "4: for State" + System.lineSeparator() +
                    "5: for Zipcode" + System.lineSeparator();

            option = printMessageAndGetMenuInput(message, 5);
            input.nextLine();
            String in = printMessageAndGetStringInput("Enter New Information");
            globalController.editProvider(id, option, in);
            System.out.println(System.lineSeparator() + "Successfully edited." + System.lineSeparator());
        }
    }


    //for debugging only, remove in production
    private static void printMembers() {
        globalController.printAllMembers();
    }


    private static void providerMenu(Provider p) {
        int option;
        String message = "Provider Menu" + System.lineSeparator() +
                "Enter" + System.lineSeparator() +
                "1: to Validate Member" + System.lineSeparator() +
                "2: to Request Provider Directory" + System.lineSeparator() +
                "3: to Bill ChocAn" + System.lineSeparator() +
                "4: to Exit" + System.lineSeparator();

        option = printMessageAndGetMenuInput(message, 4);

        if (option==4)
        {
            return;
        }

        switch (option)
        {
            case 1:
                System.out.println("Enter Member ID (9 digits):");
                int memberID = input.nextInt();
                System.out.println(globalController.verifyMemberIdAndStatus(memberID));
                break;
            case 2:
                globalController.displayDirectory();
                break;
            case 3:
                System.out.println("Enter Member ID (9 digits):");
                int memID = input.nextInt();
                System.out.println(globalController.verifyMemberIdAndStatus(memID));
                String status = globalController.verifyMemberIdAndStatus(memID);
                if (status == "Invalid number." || status == "Member suspended.") {
                    break;
                }
                Member member = globalController.getMember(memID);
                globalController.billChocAn(member, p);
                break;
        }
        providerMenu(p);
    }

    private static void persistenceOut() {
        try {
            FileOutputStream fileOut = new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(globalController);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in data.ser");
        }
        catch (FileNotFoundException i) {
            System.out.println("No File Found for Persistence");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void persistenceIn() {
        try {
            FileInputStream fileIn = new FileInputStream("data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            globalController = (GlobalController) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
