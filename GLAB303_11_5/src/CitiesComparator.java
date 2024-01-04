import java.util.Comparator;

public class CitiesComparator implements Comparator<String> {
    @Override
    public int compare(String cities_one, String cities_two) {
        int value = cities_one.compareTo(cities_two);

        if(value > 0) return -1;
        else if (value < 0) return 1;
        else return 0;
    }
}
