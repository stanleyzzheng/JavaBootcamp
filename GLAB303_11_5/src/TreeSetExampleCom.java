import javax.accessibility.AccessibleIcon;
import java.util.TreeSet;

public class TreeSetExampleCom {
    public static void main(String[] args){
        TreeSet<String> cities = new TreeSet<>(new CitiesComparator());
        cities.add("UAE");
        cities.add("Mumbai");
        cities.add("NewYork");
        cities.add("Hyderabad");
        cities.add("Karachi");
        cities.add("Xanada");
        cities.add("Lahore");
        cities.add("Zagazig");
        cities.add("Yingkou");

        System.out.println("TreeSet: " + cities);
    }
}
