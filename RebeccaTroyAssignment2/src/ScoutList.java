import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * This class creates an ArrayList and contains methods to access and edit the objects (scouts) in the ArrayList
 *
 * @author Becky Troy
 */

public class ScoutList {

    /**
     * Default Constructor for class Scoutlist
     */
    public ScoutList() {
    }

    /**
     * Declares and initiates a private ArrayList of type Scout, called scouts
     */
    private ArrayList<Scout> scouts = new ArrayList<>();

    /**
     * Method to add a Scout object to the ArrayList
     */
    public void addScout(Scout scout) {
        scouts.add(scout);
    }

    /**
     * Method to return a Scout object by its index
     */
    public Scout getScout(int index) {
        //Validation statement - ensures the index entered is not empty in the Arraylist
        if((index < (scouts.size()) && (index >= 0))) {
            return scouts.get(index);
        }
        else {
            return null;
        }
    }

    /**
     * Method to remove a Scout object from the Arraylist
     */
    public boolean removeScout(int index) {
        //Validation statement - ensures index entered is not empty in the Arraylist
        if ((index < (scouts.size()) && (index >= 0))) {
            scouts.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to return the number of objects in the Arraylist
     */
    public int numberOfScouts () {
        return scouts.size();
    }

    /**
     * Method to build and return a String with all the Scout objects in the ArrayList
     */
    public String listOfScouts() {
        //If the Arraylist is empty
        if (scouts.size() == 0) {
            return "There are no scouts in the list.";
        }
        else {
            String listOfScouts = "";
            for (int i = 0; i < scouts.size(); i++) {
                listOfScouts = listOfScouts + i + ": " + scouts.get(i).toString() + "\n";
            }
            return listOfScouts;
        }
    }

    /**
     * Method to build and return a String of all Scout objects of a chosen subclass passed through the parameter
     */
    public String listScoutNamesByGroup(int choice) {
        String result = new String();
        //If the Arraylist is empty
        if (scouts.size() == 0) {
            result = "There are no scouts stored in the list.";
        }
        else {
            for (int i = 0; i < scouts.size(); i++) {
                Scout scout = scouts.get(i);
                int index = 0;
                //1 returns Beaver Scouts
                if ((choice == 1) && (scout.toString().contains("Beaver"))) {
                    result = result + (index + 1) + ". " + scout.getName() + "\n";
                }
                //2 returns Cub Scouts
                else if ((choice == 2) && (scout.toString().contains("Cub"))) {
                    result = result + (index + 1) + ". " + scout.getName() + "\n";
                }
                //3 returns Scouters
                else if ((choice == 3) && (scout.toString().contains("Scouter"))) {
                    result = result + (index + 1) + ". " + scout.getName() + "\n";
                }
                else {

                }

            }
            if (!result.contains("\n")) {
                result = "There are no scouts for this group.";
            }
        }
        return result;
    }

    /**
     * Method to calculate and return the total amount of fees received from scouts
     */
    public double calculateTotalFees() {
        double total = 0;
        for (int i = 0; i < scouts.size(); i++) {
            Scout scout = scouts.get(i);
            total = total + scout.calcMembership();
        }
        return total;
    }

    /**
     * Method to count and return the number of objects in the Arraylist of the subclass Beaver Scout
     */
    public int numberOfBeaverScouts() {
        int totalBeavers = 0;
        for (int i = 0; i < scouts.size(); i++) {
            Scout scout = scouts.get(i);
            //Counts the number of Beaver Scouts
            if (scout.toString().contains("Beaver")) {
                totalBeavers += 1;
            }
            else {
            }
        }
        return totalBeavers;
    }

    /**
     * Method to count and return the number of objects in the Arraylist of the subclass Cub Scout
     */
    public int numberOfCubScouts() {
        int totalCubs = 0;
        for (int i = 0; i < scouts.size(); i++) {
            Scout scout = scouts.get(i);
            //Counts the number of Cub Scouts
            if (scout.toString().contains("Cub")) {
                totalCubs += 1;
            }
            else {
            }
        }
        return totalCubs;
    }

    /**
     * Method to count and return the number of objects in the Arraylist of the subclass Scouter
     */
    public int numberOfScouters() {
        int totalScouters = 0;
        for (int i = 0; i < scouts.size(); i++) {
            Scout scout = scouts.get(i);
            //Counts the number of Beaver Scouts
            if (scout.toString().contains("Scouter")) {
                totalScouters += 1;
            }
            else {
            }
        }
        return totalScouters;
    }

    /**
     * Method to build and return a String of all Scout objects with the name attribute as passed through the parameter
     */
    public String listScoutsByName(String String) {
        String result = new String();
        //If the Arraylist is empty
        if (scouts.size() == 0) {
            result = "There are no scouts stored in the list.";
        }
        else {
            for (int i = 0; i < scouts.size(); i++) {
                Scout scout = scouts.get(i);
                int index = 0;
                if ((String.toUpperCase().equals(scout.getName().toUpperCase()))) {
                    result = result + (index + 1) + ". " + scout.toString() + "\n";
                }
                else {
                }
            }
            if (!result.contains("\n")) {
                result = "We're sorry, but there are no Scouts by the name of " + String;
            }
        }
        return result;
    }

    /**
     * Method to update a Scout object in the ArrayList
     */
    public void updateScout(int index, String name, String county, String dateOfBirth, String address, String phoneNumber) {
        Scout s = scouts.get(index);
        s.setName(name);
        s.setCounty(county);
        s.setDateOfBirth(dateOfBirth);
        s.setAddress(address);
        s.setPhoneNumber(phoneNumber);
    }

    /**
     * Method to save all objects in Arraylist to an external .xml file
     */
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("scouts.xml"));
        out.writeObject(scouts);
        out.close();
    }

    /**
     * Method to load all objects in Arraylist from an external .xml file
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("scouts.xml"));
        scouts = (ArrayList<Scout>) is.readObject();
        is.close();
    }
}