package Service;
import DAO.*;
import DTO.*;

import javax.print.Doc;
import java.awt.geom.PathIterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AdminService {

    public static int adminLogin(String username, String password) {
        Admin admin = adminDAO.getAdminInfo(username, password);

        if (admin.getName() == null)
            return 0;
        else
            return 1;
    }

    public static void addDoctor(String name, String id, String department, boolean hod, String specialization, int age, String address, String phoneNumber, String gender, String password,String designation,String surgeon) {
        Doctor doctor = new Doctor(name, id, department, hod, specialization, age, address, phoneNumber, gender, password,designation,surgeon,"0");
        doctorDAO.saveDoctorInfo(doctor);
    }

    public static ArrayList<Doctor> showAllDoctor() {
        ArrayList<Doctor> doctorList = doctorDAO.showAllDoctorInfo();
        /*for (Doctor doc : doctorList) {
            System.out.println(doc.getName());

        }*/
        return doctorList;
    }

    public static ArrayList<Patient> showAllPatient(){
        ArrayList<Patient> patientList = patientDAO.showAllPatientInfo();
        /*for (Patient patient : doctorList) {
            System.out.println(patient.getName());

        }*/
        return patientList;
    }
    public static void addDepartment(String id,String name,String hod){
        Department department = new Department(id,name,hod);
        Boolean val = departmentDAO.saveDepartmentInfo(department);
        if(val ==true)
            System.out.println("SUCCESS");
        else
            System.out.println("failure");
        //return val;
    }
    public static Department getDepartmentById(String id){
        Department department = departmentDAO.getDepartmentInfo(id);
        System.out.println(department.getName());
        return department;
    }

    public static Department getDepartmentByHod(String hod){
        Department department = departmentDAO.getDepartmentInfoByHod(hod);
        System.out.println(department.getName());
        return department;
    }

    public static ArrayList getAllDepartment(){
        ArrayList<Department> departmentList = departmentDAO.getAllDepartment();
        return departmentList;
    }

    public static ArrayList showAllReassignment(){
        ArrayList<Reassignment> reassignmentList = reassignmentDAO.showAllReassignmentInfo();
        for (Reassignment re: reassignmentList){
            System.out.println(re.getId());
        }
        return reassignmentList;
    }

    public static void updateReassignmentStatus(String id){
        Boolean val = reassignmentDAO.updateReassignmentInfo(id);
        if (val){
            Reassignment reassignment = reassignmentDAO.getReassignmentById(id);
            Patient patient = patientDAO.getPatientInfoById(reassignment.getPatientId());
            patient.setStatus("Reassignment approved");
            patientDAO.updatePatientInfo(patient);
            System.out.println("success");}
        else
            System.out.println("failure");
    }

    public static void addMedicine(String patientId, String medicine, String appointmentId){
        Boolean val = adminDAO.addMedicineInfo(patientId,medicine,appointmentId);
    }

    public static void addTest(String patientId, String test, String appointmentId){
        Boolean val = adminDAO.addTestInfo(patientId,test, appointmentId);
    }

    public static void addPatientLogs(String patientId,String inDate, String inTime, String outDate, String outTime, String appointmentId){
        String id ="12";
        Boolean val = adminDAO.addPatientLogsInfo(id, patientId, inDate, inTime, outDate, outTime, appointmentId);
    }

    public static ArrayList showAllPatientLogs(){
        ArrayList<PatientLogs> logs = adminDAO.showAllPatientLogs();
        return logs;
    }

    public static ArrayList showAllMedicineByPatientId(String patientId, String appointmentId){
        ArrayList<String> medicineList = adminDAO.showAllMedicineByPatientId(patientId, appointmentId);
        return medicineList;
    }

    public static ArrayList ShowAllTestByPatientId(String patientId, String appointmentId){
        ArrayList<String> testList = adminDAO.showAllTestByPatientId(patientId, appointmentId);
        return testList;
    }

    public static void allocateDoctor(String patientId, String department, String date, String day, String slot){
        ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByDepartmentAndDay(department, day);
        for(Doctor d: doctorList){
            System.out.println(d.getName());
            System.out.println(d.getRating());
        }
        Collections.sort(doctorList, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return (int)(Double.parseDouble(o2.getRating())- Double.parseDouble(o1.getRating()));
            }
        });
        Doctor doc = null;
        int flag = 0;
        for(Doctor doctor: doctorList){
           ArrayList <String> slotList = patientDAO.getScheduleByDay(doctor.getId(), date);
           if(slotList.size() == 0){
               doc = doctor;
               break;
           }
           else{
               for(String sl: slotList){
                   if(sl.equals(slot)){
                       doc = doctor;
                       flag =1;
                       break;
                   }
               }
           }
           if(flag ==1)
               break;
        }
        String id = "9";
        System.out.println(doc.getName());
        Boolean val = patientDAO.saveAppointment(id,patientId,doc.getId(),date,slot,"upcoming");
    }

    public static String getLastPatientLogsId(){
        String id = adminDAO.getLastIdPatientLogs();
        return id;
    }

    public static String getLastDepartmentId(){
        String id = departmentDAO.getLastIdDepartment();
        return id;
    }

	
	public static void main(String args[])throws IOException{
		AdminService a = new AdminService();
		//AdminService.showAllReassignment();
        //AdminService.updateReassignmentStatus("1234");
		//a.showAllDoctor();
        //a.showAllPatient();
        //a.addDepartment("1234","ENT","ALV123");
        //a.getDepartmentByHod("ALV123");
        //a.getDepartmentById("1234");
		//a.adminLogin("root", "roo1t");
		//a.addDoctor("Alvin","ALV123","opd",false,"ENT",25,"Delhi","9748409298","M","root");
	}
	
	
	
}
