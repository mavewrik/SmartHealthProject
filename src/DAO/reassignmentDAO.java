package DAO;
import Connection.DatabaseConnectionClass;
import DTO.Department;
import DTO.Patient;
import DTO.Reassignment;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class reassignmentDAO {

    public static boolean saveReassignmentInfo(String id, String patientId, String referringDoctorId, String referredDoctorId, String status) {

        boolean result = false;
//We need a connection to DB. For this we will use a Singleton Class
        //Step 1. create database connection
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "INSERT INTO reassignment (Id,PatientId, ReferringDoctorId, ReferredDoctorId, Status) VALUES (?, ?, ?, ?, ?);";

        //PreparedStatement stmt = null; //will explain later
        int row = 0;
        //int noOfEmp = listOfEmployees.size();
        if (conn == null) {
            return false;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, id);
            stmt.setString(2, patientId);
            stmt.setString(3, referringDoctorId);
            stmt.setString(4, referredDoctorId);
            stmt.setString(5, status);

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

    public static ArrayList showAllReassignmentInfo() {

        ArrayList listOfReassignment = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM reassignment";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reassignment reassignment = new Reassignment();
                reassignment.setId(rs.getString("Id"));
                reassignment.setPatientId(rs.getString("PatientId"));
                reassignment.setReferringDoctorId(rs.getString("ReferringDoctorId"));
                reassignment.setReferredDoctorId(rs.getString("ReferredDoctorId"));
                reassignment.setStatus(rs.getString("Status"));


                listOfReassignment.add(reassignment);
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

        return listOfReassignment;

    }

    public static boolean updateReassignmentInfo(String id) {

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        boolean result = true;

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "UPDATE reassignment SET Status = ? "
                + "WHERE Id = ? ";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, "Approved");
            stmt.setString(2, id);


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
    public static Reassignment getReassignmentById(String id) {

        Reassignment reassignment = new Reassignment();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM reassignment where Id=?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                reassignment.setId(rs.getString("Id"));
                reassignment.setPatientId(rs.getString("PatientId"));
                reassignment.setReferringDoctorId(rs.getString("ReferringDoctor"));
                reassignment.setReferredDoctorId(rs.getString("ReferredDoctor"));
                reassignment.setStatus(rs.getString("Status"));
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

        return reassignment;

    }


}
