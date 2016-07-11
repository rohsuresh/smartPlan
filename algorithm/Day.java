/**
 * Created by rohansuresh on 7/1/16.
 */
import java.util.ArrayList;
public class Day {


    Priority p = new Priority();
    private ArrayList<Entry> tasks = p.getTasks();


    public Day(ArrayList<Entry> entries) {
        tasks = entries;
        for (Entry e : tasks) {

        }
    }
}
