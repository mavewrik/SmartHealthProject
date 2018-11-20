package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DatabaseConnectionClass;
import DTO.*;

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

    public static boolean addDoctorSchedule(String id,String dayOfAvailability,String inTime,String outTime) {

        boolean result = false;
//We need a connection to DB. For this we will use a Singleton Class
        //Step 1. create database connection
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "INSERT INTO schedule (DoctorId, DayOfAvailability, InTime, OutTime) VALUES (?, ?, ?, ?);";

        //PreparedStatement stmt = null; //will explain later
        int row = 0;
        //int noOfEmp = listOfEmployees.size();
        if (conn == null) {
            return false;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, id);
            stmt.setString(2, dayOfAvailability);
            stmt.setString(3, inTime);
            stmt.setString(4, outTime);

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

        boolean result = false;

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
                + "Surgeon = ?, "
                + "Rating = ?"
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
            stmt.setString(12, doctor.getRating());
            stmt.setString(13, doctor.getId());

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

    public static Doctor getDoctorInfoById(String Id) {

        Doctor doctor = new Doctor();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM doctor where Id=? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, Id);
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

    public static ArrayList getDoctorInfoByAddress(String address) {



        ArrayList listOfDoctor = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM doctor where Address  = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, address);
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

    public static ArrayList getDoctorInfoBySpecialization(String specialization) {



        ArrayList listOfDoctor = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM doctor where Specialization  = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, specialization);
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

    public static ArrayList getDoctorInfoByName(String name) {



        ArrayList listOfDoctor = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM doctor where Name  = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, name);
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

    public static ArrayList getDoctorInfoByDepartment(String department) {



        ArrayList listOfDoctor = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM doctor where Department  = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, department);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs);
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

    public static String getLastIdDoctor() {

        String val =" ";

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT Id FROM doctor ORDER BY Id DESC LIMIT 1";

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

    public static ArrayList getDoctorInfoByDepartmentAndDay(String department,String day) {



        ArrayList listOfDoctor = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        //SELECT id FROM doctor WHERE department = "opd" AND id IN (SELECT DoctorId FROM SCHEDULE WHERE DayOfAvailability = "Monday")
        String selectSQL = "SELECT * FROM doctor where Department  = ? AND Id IN (SELECT DoctorId FROM schedule WHERE DayoFAvailability = ?)";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, department);
            stmt.setString(2, day);
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
                doctor.setRating(rs.getString("Rating"));
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



    public static ArrayList getDoctorInfoBySpecializationAndDay(String specialization,String day) {



        ArrayList listOfDoctor = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        //SELECT id FROM doctor WHERE department = "opd" AND id IN (SELECT DoctorId FROM SCHEDULE WHERE DayOfAvailability = "Monday")
        String selectSQL = "SELECT * FROM doctor where Specialization  = ? AND Id IN (SELECT DoctorId FROM schedule WHERE DayoFAvailability = ?)";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, specialization);
            stmt.setString(2, day);
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

    public static ArrayList getDoctorInfoByAddressAndDay(String address,String day) {



        ArrayList listOfDoctor = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        //SELECT id FROM doctor WHERE department = "opd" AND id IN (SELECT DoctorId FROM SCHEDULE WHERE DayOfAvailability = "Monday")
        String selectSQL = "SELECT * FROM doctor where Address  = ? AND Id IN (SELECT DoctorId FROM schedule WHERE DayoFAvailability = ?)";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, address);
            stmt.setString(2, day);
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

    public static ArrayList getDoctorInfoByNameAndDay(String name,String day) {



        ArrayList listOfDoctor = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        //SELECT id FROM doctor WHERE department = "opd" AND id IN (SELECT DoctorId FROM SCHEDULE WHERE DayOfAvailability = "Monday")
        String selectSQL = "SELECT * FROM doctor where Name  = ? AND Id IN (SELECT DoctorId FROM schedule WHERE DayoFAvailability = ?)";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, name);
            stmt.setString(2, day);
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

    public static ArrayList getDoctorInfoByIdAndDay(String id,String day) {



        ArrayList listOfDoctor = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        //SELECT id FROM doctor WHERE department = "opd" AND id IN (SELECT DoctorId FROM SCHEDULE WHERE DayOfAvailability = "Monday")
        String selectSQL = "SELECT * FROM doctor where Id  = ? AND Id IN (SELECT DoctorId FROM schedule WHERE DayoFAvailability = ?)";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, id);
            stmt.setString(2, day);
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

    public static ArrayList getDoctorSchedule(String doctorId) {



        ArrayList listOfSchedule = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM schedule where DoctorId  = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, doctorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setDoctorId(rs.getString("DoctorId"));
                schedule.setDayOfAvailability(rs.getString("DayOfAvailability"));
                schedule.setInTime(rs.getString("InTime"));
                schedule.setOutTime(rs.getString("OutTime"));

                listOfSchedule.add(schedule);

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

        return listOfSchedule;

    }

    public static int getAppointmentCountByDoctorId(String doctorId) {

        int val =0;

        ArrayList appointmentList = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT COUNT(*) AS count FROM appointment where doctorId  = ? AND STATUS = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, doctorId);
            stmt.setString(2, "completed");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                val = rs.getInt("count");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                conn.close(); //very important
            } catch (SQLException ex1) {
                return 0;
            }
        }

        return val;

    }

    public static ArrayList getAllPatients(String id) {

        Doctor doctor = new Doctor();
        ArrayList listOfPatient = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        //SELECT id FROM doctor WHERE department = "opd" AND id IN (SELECT DoctorId FROM SCHEDULE WHERE DayOfAvailability = "Monday")
        String selectSQL = "SELECT * FROM patient where Id IN (SELECT patientId FROM appointment WHERE doctorId = ?)";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, id);

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

    public static boolean addRequestToHod(String id, String doctorId, String departmentId, String designation, String specialization, String surgeon, String status) {

        boolean result = false;
//We need a connection to DB. For this we will use a Singleton Class
        //Step 1. create database connection
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "INSERT INTO hodservices (Id, DoctorId, DepartmentId, Designation, Specialization, Surgeon, Status) VALUES (?, ?, ?, ?, ?, ?, ?);";

        //PreparedStatement stmt = null; //will explain later
        int row = 0;
        //int noOfEmp = listOfEmployees.size();
        if (conn == null) {
            return false;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, id);
            stmt.setString(2, doctorId);
            stmt.setString(3, departmentId);
            stmt.setString(4, designation);
            stmt.setString(5, specialization);
            stmt.setString(6, surgeon);
            stmt.setString(7, status);
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

    public static PatientLogs showAllPatientLogsByPatientId(String patientId, String appointmentId) {

        PatientLogs patientlogs = new PatientLogs();
        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM patientlogs where PatientId = ? and AppointmentId = ?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, patientId);
            stmt.setString(2, appointmentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                patientlogs.setId(rs.getString("id"));
                patientlogs.setPatientId(rs.getString("PatientId"));
                patientlogs.setInDate(rs.getString("InDate"));
                patientlogs.setInTime(rs.getString("InTime"));
                patientlogs.setOutDate(rs.getString("OutDate"));
                patientlogs.setOutTime(rs.getString("OutTime"));
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

        return patientlogs;

    }

    public static ArrayList getAppointmentByDoctorId(String doctorId, String status) {

        ArrayList appointments = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM appointment where doctorId =? and status = ? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, doctorId);
            stmt.setString(2, status);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(rs.getString("id"));
                appointment.setPatientId(rs.getString("patientId"));
                appointment.setDoctorId(rs.getString("doctorId"));
                appointment.setDate(rs.getString("date"));
                appointment.setSlot(rs.getString("slot"));
                appointment.setStatus(rs.getString("status"));
                appointment.setRating(rs.getString("rating"));
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

    public static ArrayList getAppointmentByCompletedPatientId(String patientId, String status) {

        ArrayList appointments = new ArrayList();

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM appointment where patientId =? and status = ? ";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, patientId);
            stmt.setString(2, status);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(rs.getString("id"));
                appointment.setPatientId(rs.getString("patientId"));
                appointment.setDoctorId(rs.getString("doctorId"));
                appointment.setDate(rs.getString("date"));
                appointment.setSlot(rs.getString("slot"));
                appointment.setStatus(rs.getString("status"));
                appointment.setRating(rs.getString("rating"));
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

    public static String getLastIdReassignment() {

        String val =" ";

        DatabaseConnectionClass databseConnectionClass = DatabaseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "hospitalManagement", "root", "", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT Id FROM reassignment ORDER BY Id DESC LIMIT 1";

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
