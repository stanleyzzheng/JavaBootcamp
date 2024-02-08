package studyguide1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayToLinkedList implements MyLinkList{
	private LinkedList<String> arrayToList;
	private int node;
	public ArrayToLinkedList(){
		this.arrayToList = new LinkedList<>();
		this.node =0;
	}

	@Override
	public void convert(String[] a) {
		// TODO Auto-generated method stub
		for(String s: a){
			arrayToList.add(s);
			System.out.println("I have added " + s + " to node: " + node);
			this.node++;
		}
	}

	@Override
	public void replace(int idx) {
		// TODO Auto-generated method stub
		String removed = arrayToList.remove(idx);
		arrayToList.add(idx, "");
		System.out.printf("I have replaced the string: %s with a null string%n", removed);
	}

	@Override
	public LinkedList<String> compact() {
		// TODO Auto-generated method stub
		arrayToList.removeAll(new LinkedList<>(Arrays.asList("")));
		return arrayToList;
	}

	@Override
	public void displayList() {
		// TODO Auto-generated method stub
		System.out.println(arrayToList);
		
	}

	@Override
	public void reverseLinkedList() {
		// TODO Auto-generated method stub
		Iterator<String> reversedIterator = arrayToList.descendingIterator();
		Iterator<String> iterator = arrayToList.iterator();
		int i =0;
		System.out.println("Original Linked list order: ");
		while (iterator.hasNext()){
			System.out.println(i + " element=" + iterator.next());
			i++;
		}
		LinkedList<String> reversedList = new LinkedList<>();

		int j =0;
		System.out.println("Reversed Linked list order: ");

		while ((reversedIterator.hasNext())){
			String next = reversedIterator.next();
			System.out.println(j + " element=" + next);
			reversedList.add(next);
			j++;
		}
		this.arrayToList = reversedList;
		
	}
	
  


}