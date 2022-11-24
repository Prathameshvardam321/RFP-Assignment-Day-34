package com.bridgelabz;
import java.sql.*;
import java.util.Enumeration;

public class EmployeePayrollMain {
    public static void main(String[] args) {
        String url
                = "jdbc:mysql://localhost:3306/employee_payroll_service";
        String username = "root";
        String password = "9930516251Aa@";
        Connection con;
        String query
                = "select * from employee_payroll";
        String query1
                = " update employee_payroll set name = 'Prathmesh' where id = 1;";
        String query2="update employee_payroll set start = '22-08-21' where id = 5;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
            System.out.println("Driver Loaded !!!");
            System.out.println("Connecting to database" + url);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");
            Statement st = con.createStatement();
            st.execute(query);
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            boolean result = st.execute(query); // Execute query
            System.out.println(result);

            ResultSet rs = st.getResultSet();
            if(result) {
                while (rs.next()) {
                    int id = rs.getInt("id"); // Retrieve name from db
                    System.out.println(id); // Print result on console

                    String name = rs.getString("name"); // Retrieve name from db
                    System.out.println(name); // Print result on console

                    int salary
                            = rs.getInt("salary"); // Retrieve name from db
                    System.out.println(salary); // Print result on console

                    Date startDate
                            = rs.getDate("start"); // Retrieve name from db
                    System.out.println(startDate); // Print result on console
                }
            } else {
                System.out.println("Invalid Query");
            }
            st.close(); // close statement
            con.close(); // close connection
            System.out.println("Connection Closed....");
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Catch block");
        }

    }

}