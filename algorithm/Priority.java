/**
 * Created by rohansuresh on 7/1/16.
 */
import java.util.ArrayList;

public class Priority {

    private int sleepDesired;
    private final int totalHoursInWeek;
    private int sleepHours;
    private int workingHours;
    private ArrayList<Entry> tasks;

    public ArrayList<Entry> getTasks() {
        return tasks;
    }


    public Priority() {
        sleepDesired = 7;
        totalHoursInWeek = 24 * 7;
        sleepHours = sleepDesired * 7;
        workingHours = totalHoursInWeek - sleepHours;

        Entry hw = new Entry("Work", 1, 4);
        Entry test = new Entry("Test", 2, 3);
        Entry project = new Entry("Project", 10, 6);
        Entry hw2 = new Entry("Work2", 3, 2);
        Entry test2 = new Entry("Test2", 5, 3);
        Entry project2 = new Entry("Project2", 12, 7);
        Entry hw3 = new Entry("Work3", 4, 3);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(hw);
        entries.add(test);
        entries.add(project);
        entries.add(hw2);
        entries.add(test2);
        entries.add(project2);
        entries.add(hw3);
        tasks = entries;
    }

    public void computeWeek() {

        int totalHoursOfWork = 0;
        for(int i = 0; i < tasks.size(); i++) {
            totalHoursOfWork += tasks.get(i).getHours();
        }
        //System.out.println(totalHoursOfWork);

        if (totalHoursOfWork > workingHours) {
            int extra = totalHoursOfWork - workingHours;
            System.out.println("Ouch. Looks like you need to cut back on sleep this week by " + extra + " hours.");
        }

        int day = 3;

        while (day > 0) {
            for (Entry e : tasks) {
                e.dayOver(e.getHours() / e.getDaysLeft());
            }
            day--;
        }
        for (int i = 0; i < tasks.size(); i++) {
            while (tasks.get(i).getHours() <= 0 || tasks.get(i).getDaysLeft() <= 0) {
                tasks.remove(tasks.get(i));
                if(i >= tasks.size()) {
                    break;
                }
            }
            if(i < tasks.size()) {
                System.out.println(tasks.get(i).getName() + ' ' + tasks.get(i).getHours() + ' ' + tasks.get(i).getDaysLeft());
            }
        }
    }

    public static void main (String[] args) {
        Priority p = new Priority();
        p.computeWeek();

    }

}
