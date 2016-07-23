/**
 * Created by rohansuresh on 7/1/16.
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Day {


    Priority p = new Priority();
    //private ArrayList<Entry> tasks = p.getTasks();
    private int size;


    public Day(LinkedList<Entry> entries) {
        //tasks = entries;
        /*for (Entry e : tasks) {


        }*/
        size = entries.size();
    }

    public int getSize() {
        return size;
    }
}
