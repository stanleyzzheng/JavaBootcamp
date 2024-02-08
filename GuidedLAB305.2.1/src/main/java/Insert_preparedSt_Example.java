import java.sql.*;
public class Insert_preparedSt_Example {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String dburl = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root";
        String password="SzhengSQL123";
        try{
            con = DriverManager.getConnection(dburl, user, password);
            System.out.println("Connection established successfully!");
            String sqlQuery = "INSERT INTO EMPLOYEES(officeCode,firstName,lastName,email,extension,reportsTo,VacationHours,employeeNumber,jobtitle)" +
                    "VALUES(?,?,?,?,?,?,?,?,?)";
            prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setInt(1,6);
            prepStmt.setString(2,"Jamil");
            prepStmt.setString(3,"fink");
            prepStmt.setString(4,"JJ@gmail.com");
            prepStmt.setString(5, "2759");
            prepStmt.setInt(6, 1143);
            prepStmt.setInt(7, 9);
            prepStmt.setInt(8, 0003);
            prepStmt.setString(9, "Manager");
            int affectedRows = prepStmt.executeUpdate();
            System.out.println(affectedRows + " row(s) affected !!");
            prepStmt = con.prepareStatement("SELECT * FROM employees WHERE employeeNumber = ? ");
            prepStmt.setInt(1,0003);
            rs=prepStmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("firstName"));
                System.out.println(rs.getString("lastname"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("officeCode"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try {
            prepStmt.close();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
