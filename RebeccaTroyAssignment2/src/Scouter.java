import java.util.ArrayList;

public class Scouter extends Scout {

    private String dateOfVetting;

    public Scouter(String name, String county, String dateOfBirth, String address, String phoneNumber, ArrayList<SpecialInterest> specialInterests, String dateOfVetting) {
        super(name, county, dateOfBirth, address, phoneNumber, specialInterests);
        this.dateOfVetting = dateOfVetting;
    }

    public String getCubPhoneNumber() {
        return dateOfVetting;
    }

    public void setCubPhoneNumber(String cubPhoneNumber) {
        this.dateOfVetting = cubPhoneNumber;
    }

    @Override
    public double calcMembership() {
        return 10;
    }

    public String toString() {
        return "Scouter " + super.toString() + "\n" + "   Other details: Date of Garda Vetting: " + dateOfVetting;
    }
}
