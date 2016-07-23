/**
 * Created by rohansuresh on 7/1/16.
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class Priority {

    private int sleepDesired;
    private int schoolHours;
    private int schoolHoursInWeek;
    private int misc;
    private int miscInWeek;
    private final int totalHoursInWeek;
    private int sleepHours;
    private int workingHours;
    private ArrayList<Entry> tasks;

    public ArrayList<Entry> getTasks() {
        return tasks;
    }


    public Priority() {
        misc = 2;
        miscInWeek = misc * 7;
        schoolHours = 7;
        schoolHoursInWeek = schoolHours * 5;
        sleepDesired = 8;
        totalHoursInWeek = 24 * 7;
        sleepHours = sleepDesired * 7;
        workingHours = totalHoursInWeek - sleepHours - miscInWeek - schoolHoursInWeek;

        // Entry (Name, total Hours, days Left)
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
        //entries.add(hw3);
        tasks = entries;
    }

    public void computeWeek() {

        int totalHoursOfWork = 0;
        for(int i = 0; i < tasks.size(); i++) {
            totalHoursOfWork += tasks.get(i).getHours();
        }

        System.out.println(totalHoursOfWork);
        System.out.println(workingHours);

        if (totalHoursOfWork > workingHours) {
            int extra = totalHoursOfWork - workingHours;
            System.out.println("Ouch. Looks like you need to cut back on sleep this week by " + extra + " hours.");
        }

        int day = 5;
        int schoolPerDay = 7;
        int misc = 2;

        LinkedList<Entry> doToday = new LinkedList<>();
        ArrayList<LinkedList> eachDay = new ArrayList<>();
        double perDay;

        /*for (int i = 0; i < day; i++) {
            for (int j = 0; j < tasks.size(); j++) {
                perDay = tasks.get(j).getHours() / tasks.get(j).getDaysLeft();
                doToday.add(new Entry(tasks.get(j).getName(), perDay, tasks.get(j).getDaysLeft()));
            }
            eachDay.add(doToday);
        }*/

        int i = 0;
        while (i < day) {
            LinkedList<Entry> today = new LinkedList<Entry>();
            for (int j = 0; j < tasks.size(); j++) {
                perDay = tasks.get(j).getHours() / tasks.get(j).getDaysLeft();
                //doToday.add(new Entry(tasks.get(j).getName(), perDay, tasks.get(j).getDaysLeft()));
                today.add(new Entry(tasks.get(j).getName(), perDay, tasks.get(j).getDaysLeft()));
                //System.out.println(today.size());
                //System.out.println()
                eachDay.add(i, today);
                //eachDay.add(new LinkedList(new Entry(tasks.get(j).getName(), perDay, tasks.get(j).getDaysLeft())));
            }
            //eachDay.add(today);
            for (int entry = 0; entry < tasks.size(); entry++) {
                tasks.get(entry).dayOver(tasks.get(entry).getHoursPerDay());
                while (tasks.get(entry).getHours() <= 0 || tasks.get(entry).getDaysLeft() <= 0) {
                    tasks.remove(tasks.get(entry));
                    if(entry >= tasks.size()) {
                        break;
                    }
                }
            }
            i++;
        }


        for (int e = 0; e < day; e++) {
            for (int k = 0; k < eachDay.get(e).size(); k++) {
                System.out.println("Day " + e + ": " + eachDay.get(e).get(k).toString());
            }
        }

        /*while (day > 0) {
            for (int i = 0; i < tasks.size(
            ); i++) {
                tasks.get(i).dayOver(tasks.get(i).getHours() / tasks.get(i).getDaysLeft());
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
        }*/
    }

    public static void main (String[] args) {
        Priority p = new Priority();
        p.computeWeek();

    }

}