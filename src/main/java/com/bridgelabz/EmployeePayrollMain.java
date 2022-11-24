package com.bridgelabz;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class EmployeePayrollMain {
    public static void main(String[] args) {
        String url
                = "jdbc:mysql://localhost:3306/employee_payroll_service";
        String username = "root";
        String password = "9930516251Aa@";
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
            System.out.println("Driver Loaded !!!");
        }catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find driver in class path ", e);
        }

        try{
            System.out.println("Connecting to database" + url);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");
        } catch (Exception e){
            e.printStackTrace();
        }

        listDrivers();
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements()){
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}