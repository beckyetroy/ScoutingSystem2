import java.util.ArrayList;

public abstract class Scout implements iScoutMember {

    private String name;
    private String county;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private ArrayList<SpecialInterest> specialInterests = new ArrayList<>();

    public Scout(String name, String county, String dateOfBirth, String address, String phoneNumber, ArrayList<SpecialInterest> specialInterests) {
        this.name = name;
        this.county = county;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialInterests.addAll(specialInterests);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<SpecialInterest> getSpecialInterest() {
        return specialInterests;
    }

    public void setSpecialInterest(ArrayList<SpecialInterest> specialInterests) {
        this.specialInterests = specialInterests;
    }

    public String listOfSpecialInterests() {
        String listOfSpecialInterests = "";
            for (int i = 0; i < specialInterests.size(); i++) {
                listOfSpecialInterests = listOfSpecialInterests + "\n" + "      " + i + ": " + specialInterests.get(i).toString();
            }
            return listOfSpecialInterests;
    }

    public String toString() {
        return "name: '" + name
                + "', County: '" + county
                + "', Date of Birth: '" + dateOfBirth
                + "', Address: '" + address
                + "', Contact Number: '" + phoneNumber + "'" + "\n"
                + "   Special Interest(s) Details: " + listOfSpecialInterests();
    }
}
