import java.util.TreeMap;

public class maincomparator {
    public static void main(String[] args) {
        TreeMap<String ,Integer>numbers=new TreeMap<>(new CustomComparator());
        numbers.put("First",1);
        numbers.put("Second",2);
        numbers.put("Third",3);
        numbers.put("Fourth",4);
        System.out.println("TreeMap: "+numbers);
    }
}
