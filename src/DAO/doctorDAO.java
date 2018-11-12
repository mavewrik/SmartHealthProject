package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        String insertSQL = "INSERT INTO doctor (Name, Id, Gender, PhoneNumber, Age, Address, Department, Specialization, Hod, Password, Designation, Surgeon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

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
            stmt.setString(11, doctor.getDesignation());
            stmt.setString(12, doctor.getSurgeon());
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
    public static ArrayList showAllDoctorInfo() {

        ArrayList listOfDoctor = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM doctor";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getString("Id"));
                doctor.setName(rs.getString("Name"));
                doctor.setGender(rs.getString("Gender"));
                doctor.setPhoneNumber(rs.getString("PhoneNumber"));
                doctor.setAddress(rs.getString("Address"));
                doctor.setAge(rs.getInt("Age"));
                doctor.setDepartment(rs.getString("Department"));
                doctor.setSpecialization(rs.getString("Specialization"));
                doctor.setHod(rs.getBoolean("Hod"));
                doctor.setPassword(rs.getString("Password"));
                doctor.setDesignation(rs.getString("Designation"));
                doctor.setSurgeon(rs.getString("Surgeon"));

                listOfDoctor.add(doctor);
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

        return listOfDoctor;

    }
    public static boolean updateDoctorInfo(Doctor doctor) {

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        boolean result = true;

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "UPDATE doctor SET Name = ? , "
                + "Gender = ? ,"
                + "PhoneNumber = ? ,"
                + "Address = ? ,"
                + "Age = ? ,"
                + "Department = ? ,"
                + "Specialization = ? ,"
                + "Hod = ? ,"
                + "password = ? ,"
                + "Designation = ? ,"
                + "Surgeon = ?"
                + "WHERE Id = ? ";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getGender());
            stmt.setString(3, doctor.getPhoneNumber());
            stmt.setString(4, doctor.getAddress());
            stmt.setInt(5, doctor.getAge());
            stmt.setString(6, doctor.getDepartment());
            stmt.setString(7, doctor.getSpecialization());
            stmt.setBoolean(8, doctor.isHod());
            stmt.setString(9, doctor.getPassword());
            stmt.setString(10, doctor.getDesignation());
            stmt.setString(11, doctor.getSurgeon());
            stmt.setString(12, doctor.getId());

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
                doctor.setPassword(rs.getString("Password"));
                doctor.setDesignation(rs.getString("Designation"));
                doctor.setSurgeon(rs.getString("Surgeon"));

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
