import java.util.Collections;
import java.util.LinkedList;

public class LinkedListsortExample {
    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("C");
        linkedList.add("B");
        linkedList.add("D");

        System.out.println(linkedList);

        Collections.sort(linkedList);

        System.out.println(linkedList);

        Collections.sort(linkedList, Collections.reverseOrder());

        System.out.println(linkedList);

    }
}
