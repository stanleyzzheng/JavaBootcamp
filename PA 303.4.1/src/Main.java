import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        number1();
        number2();
        number3();
        number4();
        number5();
        number6();
        number7();
    }

    private static void number7() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your filing status:");
        String filingStatus = scanner.next();
        System.out.println("Input your income:");
        int income = scanner.nextInt();
        switch
    }

    private static void number6() {
        System.out.println("Input number from 1 - 7:");
        Scanner scanner = new Scanner(System.in);
        int dayOfWeek = scanner.nextInt();
        switch(dayOfWeek){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("sunday");
                break;
            default:
                System.out.println("Out of range");
                break;
        }
    }

    public static void number1() {
        int x = 7;
        x = 15;
        if (x < 10) {
            System.out.println("less than 10");
        }

    }

    public static void number2() {
        int x = 7;
        if (x < 10) {
            System.out.println("less than 10");
        } else if (x > 10) {
            System.out.println("Greater than 10");

        }
    }

    public static void number3() {
        int x = 15;
        if (x < 10) {
            System.out.println("Less than 10");
        } else if (10 < x & x < 20) {
            System.out.println("Between 10 and 20");
        } else if (x >= 20) System.out.println("Greater than or equal to 20");
    }

    public static void number4() {
        int x = 15;
        if (x < 10 | x > 20) System.out.println("Out of range");
        if (x > 10 & x < 20) System.out.println("In range");

    }

    public static void number5() {
        Scanner scanner = new Scanner(System.in);
        int grade = scanner.nextInt();

        if (grade >= 90 & grade <= 100) System.out.println("A");
        else if (grade >= 80 & grade <= 89) {
            System.out.println("B");

        } else if (grade >= 70 & grade <= 79) System.out.println("C");
        else if (grade >= 60 & grade <= 69) {
            System.out.println("D");

        } else if (grade < 60 & grade >= 0) {
            System.out.println("F");

        }else{
            System.out.println("Score out of range");
        }


    }
}