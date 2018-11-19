package DAO;

import Connection.DatabaseConnectionClass;
import DTO.Department;
import DTO.Patient;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class departmentDAO {

    public static boolean saveDepartmentInfo(Department department) {

        boolean result = false;
//We need a connection to DB. For this we will use a Singleton Class
        //Step 1. create database connection
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "INSERT INTO department (Name, Id, Hod) VALUES (?, ?, ?);";

        //PreparedStatement stmt = null; //will explain later
        int row = 0;
        //int noOfEmp = listOfEmployees.size();
        if (conn == null) {
            return false;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, department.getName());
            stmt.setString(2, department.getId());
            stmt.setString(3, department.getHod());

            row = stmt.executeUpdate();

            if (row > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        } finally {
            try {
                conn.close(); //very important
            } catch (SQLException ex) {
                result = false;
            }
        }

        return result;

    }

    public static ArrayList getAllDepartment() {

        //Department department = new Doctor();

        ArrayList listOfDepartment = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM department";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getString("Id"));
                department.setName(rs.getString("Name"));
                department.setHod(rs.getString("Hod"));


                listOfDepartment.add(department);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                conn.close(); //very important
            } catch (SQLException ex1) {
                return null;
            }
        }

        return listOfDepartment;

    }

    public static String getLastIdDepartment() {

        String val =" ";

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT Id FROM department ORDER BY Id DESC LIMIT 1";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            //stmt.setString(1, patientId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                val = rs.getString("Id");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                conn.close(); //very important
            } catch (SQLException ex1) {
                return null;
            }
        }

        return val;

    }



    public static Department getDepartmentInfo(String Id) {

        Department department = new Department();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM department where Id=? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, Id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                department.setId(rs.getString("Id"));
                department.setName(rs.getString("Name"));
                department.setHod(rs.getString("Hod"));


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                conn.close(); //very important
            } catch (SQLException ex1) {
                return null;
            }
        }

        return department;

    }
    public static Department getDepartmentByName(String name) {

        Department department = new Department();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM department where Name=? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                department.setId(rs.getString("Id"));
                department.setName(rs.getString("Name"));
                department.setHod(rs.getString("Hod"));


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                conn.close(); //very important
            } catch (SQLException ex1) {
                return null;
            }
        }

        return department;

    }



    public static Department getDepartmentInfoByHod(String hod) {

        Department department = new Department();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM department where Hod=? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, hod);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                department.setId(rs.getString("Id"));
                department.setName(rs.getString("Name"));
                department.setHod(rs.getString("Hod"));


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                conn.close(); //very important
            } catch (SQLException ex1) {
                return null;
            }
        }

        return department;
    }

}
