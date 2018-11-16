package DAO;

import Connection.DatabaseConnectionClass;
import DTO.UpdateDoctorRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class hodDAO {

    public static boolean updateDoctorRequest(String id, String status) {

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        boolean result = true;

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "UPDATE hodservices SET Status = ? "
                + "WHERE Id = ? ";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1,status);
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

    public static ArrayList getDoctorRequestByDepartment(String departmentId) {

        //Department department = new Doctor();

        ArrayList listOfRequest = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM hodservices where DepartmentId = ? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, departmentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UpdateDoctorRequest request = new UpdateDoctorRequest();
                request.setId(rs.getString("Id"));
                request.setDepartmentId(rs.getString("DepartmentId"));
                request.setDoctorId(rs.getString("DoctorId"));
                request.setDesignation(rs.getString("Designation"));
                request.setSpecialization(rs.getString("Specialization"));
                request.setSurgeon(rs.getString("Surgeon"));
                request.setStatus(rs.getString("Status"));


                listOfRequest.add(request);

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

        return listOfRequest;

    }

    public static UpdateDoctorRequest getDoctorRequestById(String id) {

        //Department department = new Doctor();

        UpdateDoctorRequest request = new UpdateDoctorRequest();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM hodservices where Id = ? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                request.setId(rs.getString("Id"));
                request.setDepartmentId(rs.getString("DepartmentId"));
                request.setDoctorId(rs.getString("DoctorId"));
                request.setDesignation(rs.getString("Designation"));
                request.setSpecialization(rs.getString("Specialization"));
                request.setSurgeon(rs.getString("Surgeon"));
                request.setStatus(rs.getString("Status"));

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

        return request;

    }
}

