import java.util.ArrayList;

public class CubScout extends Scout {

    private String cubPhoneNumber;

    public CubScout(String name, String county, String dateOfBirth, String address, String phoneNumber, ArrayList<SpecialInterest> specialInterests, String cubPhoneNumber) {
        super(name, county, dateOfBirth, address, phoneNumber, specialInterests);
        this.cubPhoneNumber = cubPhoneNumber;
    }

    public String getCubPhoneNumber() {
        return cubPhoneNumber;
    }

    public void setCubPhoneNumber(String cubPhoneNumber) {
        this.cubPhoneNumber = cubPhoneNumber;
    }

    @Override
    public double calcMembership() {
        return 150;
    }

    public String toString() {
        return "Cub Scout " + super.toString() + "\n" + "   Other details: Cub Phone number: " + cubPhoneNumber;
    }
}
