import java.util.HashSet;

public class ExampleThree {
    public static void main(String[] args){
        HashSet<Integer> primeNumbers = new HashSet<>();
        primeNumbers.add(1);
        primeNumbers.add(3);
        primeNumbers.add(5);
        System.out.println("HashSet1: " + primeNumbers);

        HashSet<Integer> oddNumbers = new HashSet<>();
        oddNumbers.add(1);
        oddNumbers.add(3);
        oddNumbers.add(5);

        System.out.println("HashSet2: " + oddNumbers);

        primeNumbers.removeAll(oddNumbers);

        System.out.println("Difference : " + primeNumbers);
    }
}
