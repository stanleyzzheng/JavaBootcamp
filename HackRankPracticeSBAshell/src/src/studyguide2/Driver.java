package studyguide2;

import java.util.Scanner;  // Import the Scanner class

//=====================================================
// Specifications:
//
//
// Implement 1 class: Employee.  class should implement the interface EmployeeInterface.
//
// 1. Class Employee should have the variable int[ ] empIDs. The 1-based index of a employee
// is the employee's ID. It should have the following methods:
//
// Employee( ): Initialize the empty array empIDs to store 11 integer values. Assign the 
// value 1 to each element in empIDs. Print "A new JIRA team has been formed".
//
// void calculateAvgAge(int[] age): age contains the age of every Employee. Print the average 
// age of the jira team with two digits after the decimal in the form 
// "The average age of the JIRA team is {avgAge}".
//
// void promoteEmployee(int id): Assign -1 to empIds[id].  Print "Employee with id: {id} has 
// promoted". If the emp has already been promoted, print "Player {id} has already been promoted".

//
//=====================================================

//
/* Sample Input For Testing

26 32 36 33 24 31 30 35 36 21 28


=====================================================
Sample of Correct Output
=====================================================
A new JIRA team has been formed
26 32 36 33 24 31 30 35 36 21 28
The average age of the JIRA team is 30.18
Employee with id: 11 has been promoted!!
Employee with id: 3 has been promoted!!
Employee with id: 7 has been promoted!!
Employee 7 has already been promoted
*/

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee e = new Employee();

        int[] age1 = new int[11];

        for (int i = 0; i < 1; i++) {
            String[] age = sc.nextLine().split(" ");
            if (i == 0) {
                int j = 0;
                for (String s : age)
                    age1[j++] = Integer.parseInt(s);
            }
        }
        e.calculateAvgAge(age1);
        e.promoteEmployee(11);
        e.promoteEmployee(3);
        e.promoteEmployee(7);
        e.promoteEmployee(7);
        sc.close();
    }
}	