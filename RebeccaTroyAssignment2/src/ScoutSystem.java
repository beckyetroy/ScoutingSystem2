import java.util.ArrayList;
import java.util.Scanner;

public class ScoutSystem {
    private Scanner input = new Scanner(System.in);
    private ScoutList scoutList = new ScoutList();

    public ScoutSystem() {
        runMenu();
    }

    public static void main(String[] args) {
        new ScoutSystem();
    }

    private int mainMenu() {
        System.out.println("Scouting Ireland Menu");
        System.out.println("*********************************************************");
        System.out.println("    1) Register a new Scout");
        System.out.println("    2) List all Scouts");
        System.out.println("    3) Delete a Scout");
        System.out.println("    4) Update Scout Details");
        System.out.println("---------------------------------------------------------");
        System.out.println("    5) List Scouts by Group (Beaver/Cub/Scouter)");
        System.out.println("    6) Calculate Total Annual Fees Received from Scouts");
        System.out.println("    7) View Total Number of Scouts by Group");
        System.out.println("    8) View Summary Report of Scouts");
        System.out.println("    9) Search Scout by Name");
        System.out.println("---------------------------------------------------------");
        System.out.println("    10) Save Scouts to file");
        System.out.println("    11) Load Scouts from XML");
        System.out.println("---------------------------------------------------------");
        System.out.println("    0) Exit");
        System.out.print("===>> ");
        int option = input.nextInt();
        return option;
    }

    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addScout();
                    break;
                case 2:
                    System.out.println(scoutList.listOfScouts());
                    break;
                case 3:
                    deleteScout();
                    break;
                case 4:
                    updateScout();
                    break;
                case 5:
                    listScoutsByGroup();
                    break;
                case 6:
                    feesReport();
                    break;
                case 7:
                    numberOfScoutsByGroup();
                    break;
                case 8:
                    summaryReport();
                    break;
                case 9:
                    searchScoutByName();
                    break;
                case 10:
                    try{
                        scoutList.save();
                    }
                    catch(Exception e){
                        System.out.println("Error writing to file: " + e);
                    }
                    System.out.println("Save complete");
                    break;
                case 11:
                    try{
                        scoutList.load();
                    }
                    catch(Exception e){
                        System.out.println("Error writing to file: " + e);
                    }
                    System.out.println("Load complete");
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();  //this second read is required - bug in Scanner class; a String read is
            // ignored straight after reading an int.
            //display the main menu again
            option = mainMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    private void addScout() {
        //dummy read of String to clear the buffer - bug in Scanner class.
        input.nextLine();
        System.out.println("What kind of Scout would you like to add?");
        System.out.println("    1. Beaver Scout");
        System.out.println("    2. CubScout");
        System.out.println("    3. Scouter");
        System.out.println("    ");
        System.out.println("    0. Cancel");
        System.out.println("    ");
        System.out.print("Please enter [1-3]: ");
        int Choice = input.nextInt();
        if (Choice == 1) {
            System.out.println("Are you sure you would like to add a Beaver Scout?");
            System.out.println("NOTE: This choice cannot be changed later.");
            input.nextLine();
            System.out.print("Please enter [y/n]: ");
            String Confirmation = input.nextLine();
            if ((Confirmation.toUpperCase().equals("Y")) || (Confirmation.toUpperCase().equals("YES"))) {
                System.out.println("    ");
                System.out.println("You have chosen to add a Beaver Scout.");
            }
            else if ((Confirmation.toUpperCase().equals("N")) || (Confirmation.toUpperCase().equals("NO"))) {
                addScout();
            }
            else {
                System.out.println("Invalid choice entered. Please try again.");
                addScout();
            }
        }
        else if (Choice == 2) {
            System.out.println("Are you sure you would like to add a Cub Scout?");
            System.out.println("NOTE: This choice cannot be changed later.");
            input.nextLine();
            System.out.print("Please enter [y/n]: ");
            String Confirmation = input.nextLine();
            if ((Confirmation.toUpperCase().equals("Y")) || (Confirmation.toUpperCase().equals("YES"))) {
                System.out.println("    ");
                System.out.println("You have chosen to add a Cub Scout.");
            }
            else if ((Confirmation.toUpperCase().equals("N")) || (Confirmation.toUpperCase().equals("NO"))) {
                addScout();
            }
            else {
                System.out.println("Invalid choice entered. Please try again.");
                addScout();
            }
        }
        else if (Choice == 3) {
            System.out.println("Are you sure you would like to add a Scouter?");
            System.out.println("NOTE: This choice cannot be changed later.");
            input.nextLine();
            System.out.print("Please enter [y/n]: ");
            String Confirmation = input.nextLine();
            if ((Confirmation.toUpperCase().equals("Y")) || (Confirmation.toUpperCase().equals("YES"))) {
                System.out.println("    ");
                System.out.println("You have chosen to add a Scouter.");
            }
            else if ((Confirmation.toUpperCase().equals("N")) || (Confirmation.toUpperCase().equals("NO"))) {
                addScout();
            }
            else {
                System.out.println("Invalid choice entered. Please try again.");
                addScout();
            }
        }
        else if (Choice == 0) {
            runMenu();
        }
        else {
            System.out.println("Invalid choice entered. Please try again.");
            addScout();
        }

        System.out.println("Please enter the following Scout details...");
        System.out.print("  Scout Name:  ");
        String name = input.nextLine();
        System.out.print("  County:  ");
        String county = input.nextLine();
        System.out.print("  Date of Birth:  ");
        String dateOfBirth = input.nextLine();
        System.out.print("  Address:  ");
        String address = input.nextLine();
        System.out.print("  Phone Number:  ");
        String phoneNumber = input.nextLine();

        System.out.println("    ");
        System.out.println("Please enter the following details regarding the scout's special interest...");
        System.out.print("  Interest Category:  ");
        String interestCategory = input.nextLine();
        System.out.print("  Details:  ");
        String details = input.nextLine();
        System.out.print("  Date Badge Received:  ");
        String dateBadgeReceived = input.nextLine();

        SpecialInterest specialInterest = new SpecialInterest(interestCategory, details, dateBadgeReceived);
        ArrayList<SpecialInterest> specialInterests = new ArrayList<>();
        specialInterests.add(specialInterest);

        System.out.println("    ");
        System.out.println("Do you wish to add another special interest?");
        System.out.print("Please enter [y/n]: ");
        String Confirmation = input.nextLine();

        while ((Confirmation.toUpperCase().equals("Y")) || (Confirmation.toUpperCase().equals("YES"))) {
            System.out.println("    ");
            System.out.println("Please enter the following details regarding the scout's special interest...");
            System.out.print("  Interest Category:  ");
            String interestCategoryExtra = input.nextLine();
            System.out.print("  Details:  ");
            String detailsExtra = input.nextLine();
            System.out.print("  Date Badge Received:  ");
            String dateBadgeReceivedExtra = input.nextLine();

            SpecialInterest specialInterestExtra = new SpecialInterest(interestCategory, details, dateBadgeReceived);
            specialInterests.add(specialInterestExtra);

            System.out.println("    ");
            System.out.println("Do you wish to add another special interest?");
            System.out.print("Please enter [y/n]: ");
            Confirmation = input.nextLine();
        }

        System.out.println("Special Interest(s) added.");
        System.out.println("    ");

        if (Choice == 1) {
            System.out.println("Additional Details...");
            System.out.print("  Parent's Phone Number: ");
            String parentPhone = input.nextLine();

            scoutList.addScout(new BeaverScout(name, county, dateOfBirth, address, phoneNumber, specialInterests, parentPhone));
        }

        if (Choice == 2) {
            System.out.println("Additional Details...");
            System.out.print("  Cub's Phone Number: ");
            String cubPhoneNumber = input.nextLine();

            scoutList.addScout(new CubScout(name, county, dateOfBirth, address, phoneNumber, specialInterests, cubPhoneNumber));
        }

        if (Choice == 3) {
            System.out.println("Additional Details...");
            System.out.print("  Date of Garda Vetting: ");
            String dateOfVetting = input.nextLine();

            scoutList.addScout(new Scouter(name, county, dateOfBirth, address, phoneNumber, specialInterests, dateOfVetting));
        }

        System.out.println("Scout added successfully.");
        runMenu();
    }

    private void deleteScout() {
        String scoutDetails = scoutList.listOfScouts();
        System.out.println(scoutDetails);

        if(!scoutDetails.equals("There are no scouts in the list.")) {
            input.nextLine();

            System.out.print("Enter the index of the scout to Delete ==> ");
            int index = input.nextInt();

            if (scoutList.removeScout(index)) {
                scoutList.removeScout(index);
                System.out.println("The scout has been deleted.");
            }
            else {
                System.out.println("There is no scout for this index number.");
            }
        }
        else {
        }
    }

    private void updateScout() {
        String scoutDetails = scoutList.listOfScouts();
        System.out.println(scoutDetails);

        if (!scoutDetails.equals("There are no scouts in the list.")) {

            System.out.print("Please enter the index of the scout to update ==> ");
            int index = input.nextInt();
            input.nextLine();
            if (scoutList.numberOfScouts() > 0 && (index < scoutList.numberOfScouts())) {
                System.out.println("Please update the following Scout details...");
                System.out.print("  Scout Name (Blank to remain unchanged):  ");
                String name = input.nextLine();
                if (name.equals("")) {
                    name = scoutList.getScout(index).getName();
                }
                else {
                    name = name;
                }

                System.out.print("  County (Blank to remain unchanged):  ");
                String county = input.nextLine();
                if (county.equals("")) {
                    county = scoutList.getScout(index).getCounty();
                }
                else {
                    county = county;
                }

                System.out.print("  Date of Birth (Blank to remain unchanged):  ");
                String dateOfBirth = input.nextLine();
                if (dateOfBirth.equals("")) {
                    dateOfBirth = scoutList.getScout(index).getDateOfBirth();
                }
                else {
                    dateOfBirth = dateOfBirth;
                }

                System.out.print("  Address (Blank to remain unchanged):  ");
                String address = input.nextLine();
                if (address.equals("")) {
                    address= scoutList.getScout(index).getAddress();
                }
                else {
                    address = address;
                }

                System.out.print("  Phone Number (Blank to remain unchanged):  ");
                String phoneNumber = input.nextLine();
                if (phoneNumber.equals("")) {
                    phoneNumber= scoutList.getScout(index).getPhoneNumber();
                }
                else {
                    phoneNumber = phoneNumber;
                }
                scoutList.updateScout(index, name, county, dateOfBirth, address, phoneNumber);
                System.out.println("Update Successful");
            } else {
                System.out.println("Incorrect Index - no scout exists for that index");
            }
        }
    }

    private void listScoutsByGroup() {
        input.nextLine();
        System.out.println("Choose a group to search by:");
        System.out.println("    1. Beaver Scout");
        System.out.println("    2. CubScout");
        System.out.println("    3. Scouter");
        System.out.println("    ");
        System.out.println("    0. Cancel");
        System.out.println("    ");
        System.out.print("Please enter [1-3]: ");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println("Beaver Scouts:");
        }
        else if (choice == 2) {
            System.out.println("Cub Scouts:");
        }
        else if (choice == 3) {
            System.out.println("Scouters:");
        }
        else {
        }
        System.out.println(scoutList.listScoutNamesByGroup(choice));
    }

    private void feesReport() {
        System.out.println("Fees Report");
        System.out.println("Total Fees Received by members: €" + scoutList.calculateTotalFees());
    }

    private void numberOfScoutsByGroup() {
        input.nextLine();
        System.out.println("Choose a group to see their Total Number:");
        System.out.println("    1. Beaver Scout");
        System.out.println("    2. CubScout");
        System.out.println("    3. Scouter");
        System.out.println("    ");
        System.out.print("Please enter [1-3]: ");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println("You have chosen Beaver Scouts.");
            System.out.println("    ");
            System.out.println("Beaver Scout Report");
            System.out.println("   Total Number of Beaver Scouts: " + scoutList.numberOfBeaverScouts());
        }
        else if (choice == 2) {
            System.out.println("You have chosen Cub Scouts.");
            System.out.println("    ");
            System.out.println("Cub Scout Report");
            System.out.println("   Total Number of Cub Scouts: " + scoutList.numberOfCubScouts());
        }
        else if (choice == 3) {
            System.out.println("You have chosen Scouters.");
            System.out.println("    ");
            System.out.println("Scouter Report");
            System.out.println("   Total Number of Scouters: " + scoutList.numberOfScouters());
        }
        else {
        }
    }

    private void summaryReport() {
        input.nextLine();
        System.out.println("Scout Member Summary Report");
        System.out.println("    Total Number of Scout Members: "  + scoutList.numberOfScouts());
        System.out.println("    ");
        System.out.println("    Beaver Scout Report");
        System.out.println("        Total Number of Beaver Scouts: " + scoutList.numberOfBeaverScouts());
        System.out.println("    ");
        System.out.println("    Cub Scout Report");
        System.out.println("        Total Number of Cub Scouts: " + scoutList.numberOfCubScouts());
        System.out.println("    ");
        System.out.println("    Scouter Report");
        System.out.println("        Total Number of Scouters: " + scoutList.numberOfScouters());
    }

    private void searchScoutByName() {
        input.nextLine();
        System.out.print("Please enter the Scout's name to search by ==> ");
        String Name = input.nextLine();
        System.out.println(scoutList.listScoutsByName(Name));
    }
}
