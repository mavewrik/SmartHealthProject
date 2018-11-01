package DAO;

import DTO.Patient;
import Connection.DatabaseConnectionClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class patientDAO {
	
    public static boolean savePatientInfo(Patient patient) {

        boolean result = false;
//We need a connection to DB. For this we will use a Singleton Class
        //Step 1. create database connection
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "INSERT INTO patient (Name, Id, Gender, PhoneNumber, Address, Password, Ailment, Email, Age) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        //PreparedStatement stmt = null; //will explain later
        int row = 0;
        //int noOfEmp = listOfEmployees.size();
        if (conn == null) {
            return false;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getId());
            stmt.setString(3, patient.getGender());
            stmt.setString(4, patient.getPhoneNumber());
            stmt.setString(5, patient.getAddress());
            stmt.setString(6, patient.getPassword());
            stmt.setString(7, patient.getAilment());
            stmt.setString(8, patient.getEmail());
            stmt.setInt(9, patient.getAge());
            
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
    
    public static boolean updatePatientInfo(Patient patient) {

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        boolean result = true;

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "UPDATE patient SET Name = ? , "
                + "Gender = ? ,"
        		+ "PhoneNumber = ? ,"
                + "Address = ? ,"
        		+ "Age = ?"
                + "WHERE Id = ? ";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getGender());
            stmt.setString(3, patient.getPhoneNumber());
            stmt.setString(4, patient.getAddress());
            stmt.setInt(5, patient.getAge());
            stmt.setString(6, patient.getId());

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
    
    public static Patient getPatientInfo(String patientId, String password) {

        Patient patient = new Patient();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM patient where Id=? and password=?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, patientId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                patient.setId(rs.getString("Id"));
                patient.setName(rs.getString("Name"));
                patient.setGender(rs.getString("Gender"));
                patient.setPhoneNumber(rs.getString("PhoneNumber"));
                patient.setAddress(rs.getString("Address"));
                patient.setPassword(rs.getString("Password"));
                

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

        return patient;

    }
    
   /* public static void main(String args[])throws IOException{
    
    		Patient p =new Patient("Swagatam","1234","M","9748409298","Delhi",40);
    		//patientDAO.savePatientInfo(p);
    		//patientDAO.updateEmployeeInfo(p);
    		Patient p1 = patientDAO.getPatientInfo("12341");
    		if (p1.getName().equals("Swagatam"))
    			System.out.println("Success");
    		else
    			System.out.println("Not");
    }*/

}
