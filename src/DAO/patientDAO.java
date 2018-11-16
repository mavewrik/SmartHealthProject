package DAO;

import DTO.Appointment;
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
        String insertSQL = "INSERT INTO patient (Name, Id, Gender, PhoneNumber, Address, Password, Ailment, Email, Age, HealthStatus, Status, Type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

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
            stmt.setString(10, patient.getHealthStatus());
            stmt.setString(11, "Unassigned");
            stmt.setString(12,patient.getType());
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

    public static boolean saveAppointment(String id,String patientId, String doctorId, String day, String slot, String status) {

        boolean result = false;
//We need a connection to DB. For this we will use a Singleton Class
        //Step 1. create database connection
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "INSERT INTO Appointment (id,patientId, doctorId, date, slot, status) VALUES (?, ?, ?, ?, ?, ?);";

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
            stmt.setString(3, doctorId);
            stmt.setString(4, day);
            stmt.setString(5, slot);
            stmt.setString(6, status);
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


    public static ArrayList getAppointmentByPatientId(String patientid) {

        ArrayList appointments = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM appointment where patientId =? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, patientid);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(rs.getString("id"));
                appointment.setPatientId(rs.getString("patientId"));
                appointment.setDoctorId(rs.getString("doctorId"));
                appointment.setDate(rs.getString("date"));
                appointment.setSlot(rs.getString("slot"));
                appointment.setStatus(rs.getString("status"));

                appointments.add(appointment);
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

        return appointments;

    }

    public static Appointment getAppointmentById(String id) {

        Appointment appointment = new Appointment();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM appointment where id =? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                appointment.setId(rs.getString("id"));
                appointment.setPatientId(rs.getString("patientId"));
                appointment.setDoctorId(rs.getString("doctorId"));
                appointment.setDate(rs.getString("date"));
                appointment.setSlot(rs.getString("slot"));
                appointment.setStatus(rs.getString("status"));


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

        return appointment;

    }


    public static ArrayList getScheduleByDay(String doctorId, String day) {

        ArrayList slots = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT slot FROM appointment where doctorId = ? and date = ? and status = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, doctorId);
            stmt.setString(2, day);
            stmt.setString(3, "upcoming");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String slot = " ";
                slot = rs.getString("slot");
                slots.add(slot);
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

        return slots;

    }

    public static boolean cancelAppointment(String id) {

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        boolean result = true;

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "UPDATE appointment SET status = ?  "
                + "WHERE Id = ? ";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, "cancelled");
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


    
    public static boolean updatePatientInfo(Patient patient) {

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        boolean result = true;

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "UPDATE patient SET Name = ? , "
                + "Gender = ? ,"
        		+ "PhoneNumber = ? ,"
                + "Address = ? ,"
        		+ "Age = ? ,"
                + "Password = ? ,"
                + "Ailment = ? ,"
                + "HealthStatus = ? ,"
                + "Email = ? "
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
            stmt.setString(6, patient.getPassword());
            stmt.setString(7, patient.getAilment());
            stmt.setString(8, patient.getEmail());
            stmt.setString(9, patient.getId());
            stmt.setString(10, patient.getHealthStatus());

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

    public static boolean updateDoctorInfo(Patient patient) {

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        boolean result = true;

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "UPDATE patient SET Name = ? , "
                + "Gender = ? ,"
                + "PhoneNumber = ? ,"
                + "Address = ? ,"
                + "Age = ? ,"
                + "Ailment = ? ,"
                + "Email = ? ,"
                + "Password = ? ,"
                + "HealthStatus = ?"
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
            stmt.setString(6, patient.getAilment());
            stmt.setString(7, patient.getEmail());
            stmt.setString(8, patient.getPassword());
            stmt.setString(9, patient.getId());
            stmt.setString(10, patient.getHealthStatus());

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

    public static ArrayList showAllPatientInfo() {

        ArrayList listOfPatient = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM patient";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getString("Id"));
                patient.setName(rs.getString("Name"));
                patient.setGender(rs.getString("Gender"));
                patient.setPhoneNumber(rs.getString("PhoneNumber"));
                patient.setAddress(rs.getString("Address"));
                patient.setPassword(rs.getString("Password"));
                patient.setEmail(rs.getString("Email"));
                patient.setAge(rs.getInt("Age"));
                patient.setAilment(rs.getString("Ailment"));
                patient.setHealthStatus(rs.getString("HealthStatus"));
                patient.setStatus(rs.getString("Status"));
                patient.setType(rs.getString("Type"));
                listOfPatient.add(patient);
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

        return listOfPatient;

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
                patient.setEmail(rs.getString("Email"));
                patient.setAge(rs.getInt("Age"));
                patient.setAilment(rs.getString("Ailment"));
                patient.setHealthStatus(rs.getString("HealthStatus"));
                patient.setStatus(rs.getString("Status"));
                patient.setStatus(rs.getString("Type"));
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

    public static Patient getPatientInfoById(String patientId) {

        Patient patient = new Patient();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM patient where Id=? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, patientId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                patient.setId(rs.getString("Id"));
                patient.setName(rs.getString("Name"));
                patient.setGender(rs.getString("Gender"));
                patient.setPhoneNumber(rs.getString("PhoneNumber"));
                patient.setAddress(rs.getString("Address"));
                patient.setPassword(rs.getString("Password"));
                patient.setEmail(rs.getString("Email"));
                patient.setAge(rs.getInt("Age"));
                patient.setAilment(rs.getString("Ailment"));
                patient.setHealthStatus(rs.getString("HealthStatus"));
                patient.setStatus(rs.getString("Status"));
                patient.setStatus(rs.getString("Type"));
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

    public static boolean updateAppointmentRating(String id,  String rating) {

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        boolean result = true;

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "UPDATE appointment SET rating = ? "
                + "WHERE Id = ? ";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, id);
            stmt.setString(2, rating);

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
