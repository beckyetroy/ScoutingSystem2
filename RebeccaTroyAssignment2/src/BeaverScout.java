import java.util.ArrayList;

public class BeaverScout extends Scout {

    private String parentPhone;

    public BeaverScout(String name, String county, String dateOfBirth, String address, String phoneNumber, ArrayList<SpecialInterest> specialInterests, String parentPhone) {
        super(name, county, dateOfBirth, address, phoneNumber, specialInterests);
        this.parentPhone = parentPhone;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    @Override
    public double calcMembership() {
        return 100;
    }

    public String toString() {
        return "Beaver Scout " + super.toString() + "\n" + "   Other details: Parent's phone number: " + parentPhone;
    }
}
