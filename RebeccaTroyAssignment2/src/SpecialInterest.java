public class SpecialInterest {

    private String interestCategory;
    private String details;
    private String dateBadgeReceived;

    public SpecialInterest (String interestCategory, String details, String dateBadgeReceived) {
        this.interestCategory = interestCategory;
        this.details = details;
        this.dateBadgeReceived = dateBadgeReceived;
    }

    public String getInterestCategory() {
        return interestCategory;
    }

    public void setInterestCategory(String interestCategory) {
        this.interestCategory = interestCategory;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDateBadgeReceived() {
        return dateBadgeReceived;
    }

    public void setDateBadgeReceived(String dateBadgeReceived) {
        this.dateBadgeReceived = dateBadgeReceived;
    }

    public String toString() {
        return "Interest Category: " + interestCategory + ", Details: " + details + ", Date Badge Received: " + dateBadgeReceived + ".";
    }
}
