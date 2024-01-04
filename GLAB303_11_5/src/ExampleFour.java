import java.util.HashSet;

public class ExampleFour {
    public static void main(String[] args){
        HashSet<String> hset = new HashSet<>();

        hset.add("Apple");
        hset.add("Mango");
        hset.add("Grapes");
        hset.add("Orange");
        hset.add("Fig");
        hset.add("Apple");
        hset.add("Mango");
        hset.add(null);
        hset.add(null);
        for(String str:hset){
            System.out.println("---> " + str);
        }
    }
}
