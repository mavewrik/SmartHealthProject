package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DatabaseConnectionClass;
import DTO.Doctor;
import DTO.Patient;

public class doctorDAO {
	
	public static boolean saveDoctorInfo(Doctor doctor) {

        boolean result = false;
//We need a connection to DB. For this we will use a Singleton Class
        //Step 1. create database connection
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "INSERT INTO doctor (Name, Id, Gender, PhoneNumber, Age, Address, Department, Specialization, Hod, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        //PreparedStatement stmt = null; //will explain later
        int row = 0;
        //int noOfEmp = listOfEmployees.size();
        if (conn == null) {
            return false;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getId());
            stmt.setString(3, doctor.getGender());
            stmt.setString(4, doctor.getPhoneNumber());
            stmt.setInt(5, doctor.getAge());
            stmt.setString(6, doctor.getAddress());
            stmt.setString(7, doctor.getDepartment());
            stmt.setString(8, doctor.getSpecialization());
            stmt.setBoolean(9, doctor.isHod());
            stmt.setString(10, doctor.getPassword());
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
	
	public static Doctor getDoctorInfo(String Id,String password) {

        Doctor doctor = new Doctor();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM doctor where Id=? and password=?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, Id);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

            	doctor.setId(rs.getString("Id"));
            	doctor.setName(rs.getString("Name"));
            	doctor.setGender(rs.getString("Gender"));
            	doctor.setPhoneNumber(rs.getString("PhoneNumber"));
            	doctor.setAddress(rs.getString("Address"));
            	doctor.setAge(rs.getInt("Age"));
            	doctor.setDepartment(rs.getString("Department"));
            	doctor.setSpecialization(rs.getString("Specialization"));
            	doctor.setHod(rs.getBoolean("Hod"));

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

        return doctor;

    }

}
