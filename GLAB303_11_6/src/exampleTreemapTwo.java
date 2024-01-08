import java.util.TreeMap;

public class exampleTreemapTwo {
    public static void main(String[] args) {
        TreeMap<String, Integer> numbers = new TreeMap<>();
        numbers.put("First", 1);
        numbers.put("Second", 2);
        numbers.put("Three", 3);
        System.out.println("TreeMap: " + numbers);

        String firstKey = numbers.firstKey();
        System.out.println("First Key: " + firstKey);

        String lastKey = numbers.lastKey();
        System.out.println("Last key: " + lastKey);

        System.out.println("First Entry: " + numbers.firstEntry());

        // Using the lastEntry() method
        System.out.println("Last Entry: " + numbers.lastEntry());    }
}
