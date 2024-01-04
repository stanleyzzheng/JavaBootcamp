import java.util.TreeSet;

public class TreesetExampleTwo {
    public static void main(String[] args){
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);
        System.out.println("TreeSet: " + numbers);

        boolean value1 = numbers.remove(5);
        System.out.println("Is 5 removed? " + value1);

        boolean value2 = numbers.removeAll(numbers);

        System.out.println("Are all elements removed? " + value2);
    }
}
