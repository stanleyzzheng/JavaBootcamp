package studyguide2;

import java.util.Arrays;

// Employee( ): Initialize the empty array empIDs to store 11 integer values. Assign the 
// value 1 to each element in empIDs. Print "A new JIRA team has been formed".

public class Employee implements EmployeeInterface{
	private int[] empIDs;
	public Employee(){
		empIDs = new int[11];
        Arrays.fill(empIDs, 1);


		System.out.println("A new JIRA team has been formed");

	}
	@Override
	public void calculateAvgAge(int[] age) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i< age.length; i++){
			sum += age[i];
		}
		System.out.printf("The average age of the JIRA team is %.2f%n", (double)sum/(double)age.length);
		
	}

	@Override
	public void promoteEmployee(int id) {
		// TODO Auto-generated method stub
		if(empIDs[id - 1] == -1) System.out.println("Employee " + id+ " has already been promoted");
		else{
			empIDs[id - 1] = -1;
			System.out.println("Employee with id: " +id + " has been promoted!!");
		}
		
	}

}
