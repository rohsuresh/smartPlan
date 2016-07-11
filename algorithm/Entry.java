/**
 * Created by rohansuresh on 7/1/16.
 */
public class Entry {

    private String name;
    private double hours;
    private double daysLeft;

    public Entry (String n, double h, double d) {
        name = n;
        hours = h;
        daysLeft = d;
    }

    public String getName() {
        return name;
    }

    public double getHours() {
        return hours;
    }

    public double getDaysLeft() {
        return daysLeft;
    }

    public void dayOver(double hoursPerDay) {
        this.hours -= hoursPerDay;
        this.daysLeft--;
    }

}
