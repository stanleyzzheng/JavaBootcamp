import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class myRunner {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            String location = "C:\\Users\\Stanl\\IdeaProjects\\Java_Bootcamp\\GLAB303_13_1\\src\\CourseData.csv";
            File file = new File(location);
            Scanner input = new Scanner(file);
            ArrayList<Course> data = new ArrayList<>();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] splitLine = line.split(",");
                Course cObj = new Course();
                cObj.setCode(splitLine[0]);
                cObj.setCourse_name(splitLine[1]);
                cObj.setInstructor_name(splitLine[2]);
                data.add(cObj);

            }
            for (Course c : data) {
                System.out.println(c.getCode() + " | " + c.getCourse_name() + "|" + c.getInstructor_name());
                System.out.println("===============================");

            }
        }catch (FileNotFoundException e){
            System.out.println("File not found! ");
            e.printStackTrace();
        }

    }
}
