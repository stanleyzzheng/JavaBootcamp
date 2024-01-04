import java.util.HashMap;

public class ExampletwoHashMap {
    public static void main(String[] args){
        HashMap<String,String> newHashMap = new HashMap<>();
        newHashMap.put("key1", "Lenovo");
        newHashMap.put("key2", "Motorola");
        newHashMap.put("key3", "Nokia");
        newHashMap.put("key4", null);
        newHashMap.put(null, "Sony");
        System.out.println("Original map contains: " + newHashMap);

        System.out.println("Size of original Map is: " + newHashMap.size());

        HashMap<String,String> copyHashMap = new HashMap<>();
        copyHashMap.putAll(newHashMap);
        System.out.println("copyHashMap mappings= " + copyHashMap);

    }
}
