package journey.model;

public class Instructor {
    private String name;
    private boolean acceptAnonymousContact;
    private double rate;
    private int rateCount;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getRateCount() {
        return rateCount;
    }

    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }

    public boolean isAcceptAnonymousContact() {
        return acceptAnonymousContact;
    }

    public void setAcceptAnonymousContact(boolean acceptAnonymousContact) {
        this.acceptAnonymousContact = acceptAnonymousContact;
    }

    public Instructor() {
    }

    public Instructor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
