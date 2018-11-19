package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DatabaseConnectionClass;
import DTO.Admin;
import DTO.Patient;
import DTO.PatientLogs;

public class adminDAO {
	
    public static Admin getAdminInfo(String username,String password) {

        Admin admin = new Admin();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM admin where username=? and password = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                admin.setName(rs.getString("name"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));

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

        return admin;

    }

    public static boolean addMedicineInfo(String patientId, String medicine, String appointmentId) {

        boolean result = false;
//We need a connection to DB. For this we will use a Singleton Class
        //Step 1. create database connection
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "INSERT INTO medicine (PatientId, Medicine, AppointmentId) VALUES (?, ?, ?);";

        //PreparedStatement stmt = null; //will explain later
        int row = 0;
        //int noOfEmp = listOfEmployees.size();
        if (conn == null) {
            return false;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, patientId);
            stmt.setString(2, medicine);
            stmt.setString(3, appointmentId);

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

    public static boolean addTestInfo(String patientId, String test, String appointmentId) {

        boolean result = false;
//We need a connection to DB. For this we will use a Singleton Class
        //Step 1. create database connection
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "INSERT INTO test (PatientId, Test, AppointmentId) VALUES (?, ?, ?);";

        //PreparedStatement stmt = null; //will explain later
        int row = 0;
        //int noOfEmp = listOfEmployees.size();
        if (conn == null) {
            return false;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, patientId);
            stmt.setString(2, test);
            stmt.setString(3, appointmentId);

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

    public static boolean addPatientLogsInfo(String id,String patientId, String inDate, String inTime, String outDate, String outTime, String appointmentId) {

        boolean result = false;
//We need a connection to DB. For this we will use a Singleton Class
        //Step 1. create database connection
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "INSERT INTO patientlogs (Id, PatientId, InDate, InTime, OutDate, OutTime, AppointmentId) VALUES (?, ?, ?, ?, ?, ?, ?);";

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
            stmt.setString(3, inDate);
            stmt.setString(4, inTime);
            stmt.setString(5, outDate);
            stmt.setString(6, outTime);
            stmt.setString(7, appointmentId);
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

    public static ArrayList showAllPatientLogs() {

        ArrayList logs = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM patientlogs";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PatientLogs patientlogs = new PatientLogs();
                patientlogs.setId(rs.getString("id"));
                patientlogs.setPatientId(rs.getString("PatientId"));
                patientlogs.setInDate(rs.getString("InDate"));
                patientlogs.setInTime(rs.getString("InTime"));
                patientlogs.setOutDate(rs.getString("OutDate"));
                patientlogs.setOutTime(rs.getString("OutTime"));
                patientlogs.setAppointmentId(rs.getString("AppointmentId"));
                logs.add(patientlogs);
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

        return logs;

    }

    public static ArrayList showAllMedicineByPatientId(String patientId, String appointmentId) {

        ArrayList medicineList = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM medicine where PatientId =? and AppointmentId = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, patientId);
            stmt.setString(2, appointmentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String medicine =" ";
                medicine = rs.getString("Medicine");
                medicineList.add(medicine);
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

        return medicineList;

    }

    public static ArrayList showAllTestByPatientId(String patientId, String appointmentId) {

        ArrayList testList = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM test where PatientId =? and AppointmentId = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, patientId);
            stmt.setString(2, appointmentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String test =" ";
                test = rs.getString("Test");
                testList.add(test);
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

        return testList;

    }

    public static String getLastIdPatientLogs() {

        String val =" ";

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT Id FROM patientlogs ORDER BY Id DESC LIMIT 1";

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


}
