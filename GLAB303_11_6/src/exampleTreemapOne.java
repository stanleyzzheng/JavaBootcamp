import java.util.TreeMap;

public class exampleTreemapOne {
    public static void main(String[] args) {
        TreeMap<String,Integer> numbers = new TreeMap<>();
        numbers.put("One", 1);
        numbers.put("Two",2);
        numbers.put("Three",3);
        System.out.println("TreeMap: " + numbers);

        int value = numbers.remove("two");
        System.out.println("Removed value: " + value);

        boolean result = numbers.remove("Three", 3);
        System.out.println("Is the entry {Three=3} removed " + result);
        System.out.println("Updated TreeMap: " + numbers);
    }
}
