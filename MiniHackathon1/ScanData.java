import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class ScanData {
    public static ArrayList<Company> scanCompany() {
        ArrayList<Company> data = new ArrayList<>();

        try {
            String location = "C:\\Users\\Stanl\\IdeaProjects\\Java_Bootcamp\\MiniHackathon1\\Company.csv";
            Map<String, ArrayList<String[]>> result = new HashMap<>();
            File file = new File(location);
            Scanner input = new Scanner(file);
            input.nextLine();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] splitLine = line.split(",");
                Company cObj = new Company();
//                Index,Organization Id,Sales RepId,Name,Website,Country,Description,Founded,Industry,Number of
//                employees
//                cObj.setCode(splitLine[0]);
//                cObj.setCourse_name(splitLine[1]);
//                cObj.setInstructor_name(splitLine[2]);
                cObj.setIndex(splitLine[0]);
                cObj.setOrganizationId(splitLine[1]);
                cObj.setRepId(splitLine[2]);
                if (splitLine[3].contains("\"")) {
                    cObj.setName(splitLine[3] + "," + splitLine[4]);
                    cObj.setWebsite(splitLine[5]);
                    cObj.setCountry(splitLine[6]);
                    cObj.setDescription(splitLine[7]);
                    cObj.setFounded(splitLine[8]);
                    cObj.setIndustry(splitLine[9]);
                    cObj.setNumberOfEmployees(splitLine[10]);

                } else {
                    cObj.setName(splitLine[3]);
                    cObj.setWebsite(splitLine[4]);
                    cObj.setCountry(splitLine[5]);
                    cObj.setDescription(splitLine[6]);
                    cObj.setFounded(splitLine[7]);
                    cObj.setIndustry(splitLine[8]);
                    cObj.setNumberOfEmployees(splitLine[9]);

                }
                data.add(cObj);

            }

//            for (Company c : data) {
//                System.out.println(c.getIndex() + " | " + c.getOrganizationId() + " | " + c.getRepId() + " | " + c
//                .getName() + " | " + c.getWebsite() + " | " + c.getCountry() + " | " + c.getDescription() + " | " +
//                c.getFounded() + " | " + c.getIndustry()+ " | " + c.getNumberOfEmployees());
//                System.out.println("===============================");
//
//            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found! ");
            e.printStackTrace();
        }
        return data;


    }

    public static ArrayList<SalesRep> scanSalesRep() {
        ArrayList<SalesRep> data = new ArrayList<>();

        try {
            String location = "C:\\Users\\Stanl\\IdeaProjects\\Java_Bootcamp\\MiniHackathon1\\SalesReps.csv";
            File file = new File(location);
            Scanner input = new Scanner(file);
            input.nextLine();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] splitLine = line.split(",");
                SalesRep cObj = new SalesRep(splitLine[0], splitLine[1], splitLine[2], splitLine[3], splitLine[4],
                        splitLine[5]);
//                User Id,First Name,Last Name,Email,Phone,Date of birth

                data.add(cObj);

            }
//            for (SalesRep c : data) {
//                System.out.println(c.getUserId() + " | " + c.getFirstName() + " | " + c.getLastName() + " | " + c
//                .getEmail() + " | " + c.getPhone() + " | " + c.getDateOfBirth());
//                System.out.println("===============================");
//
//            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found! ");
            e.printStackTrace();
        }
        return data;

    }

    public static void main(String[] args) {
        ArrayList<Company> companies = scanCompany();
        ArrayList<SalesRep> salesReps = scanSalesRep();
        Map<String, ArrayList<String>> map = new HashMap<>();
        Map<String, String> lastNames = new HashMap<>();
        for (SalesRep rep : salesReps) {
            map.put(rep.getLastName(), new ArrayList<>());
            lastNames.put(rep.getUserId(), rep.getLastName());

        }
//        for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
//            System.out.println(entry.getKey());
//        }
//        System.out.println(map.get("Frey"));
        for (Company c : companies) {
            String repId = c.getRepId();
            String repLastName = lastNames.get(repId);
//            System.out.println(repLastName);
//            System.out.println(repId);
            ArrayList<String> arrayList = map.get(repLastName);
//        Organization Id Company Name Country Industry Number of employees
            String data =
                    "Organization Id: " + c.getOrganizationId() + "\n" + "Company Name: " + c.getName() + "\n" +
                            "Country: " + c.getCountry() + "\n" + "Industry: " + c.getIndustry() + "\n" + "Number of employees " + c.getNumberOfEmployees();
            arrayList.add(data);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a last name");
        String input = scanner.nextLine();
        ArrayList<String> list = map.get(input);
        for(String s: list){
            System.out.println(s);
        }

    }
}
