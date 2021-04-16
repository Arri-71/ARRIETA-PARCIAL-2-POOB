package entities;

public class Course {
    private String shortName;
    private int credits;

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Course(String shortName) {
        this.shortName = shortName;
        this.credits = this.credits;
    }
}
