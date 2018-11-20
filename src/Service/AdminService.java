package Service;
import DAO.*;
import DTO.*;
import Exceptions.*;

import javax.print.Doc;
import java.awt.geom.PathIterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.logging.Level;
import java.util.logging.Logger;
import LoggerConfig.LoggerConfig;

public class AdminService {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static int adminLogin(String username, String password) throws InvalidLoginException {
        Admin admin = adminDAO.getAdminInfo(username, password);
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Admin logged in");
        if (admin.getName() == null) {
            //return 0;
            throw new InvalidLoginException();

        }
        else
            return 1;
    }

    public static int addDoctor(String name, String department, boolean hod, String specialization, int age, String address, String phoneNumber, String gender, String password,String designation,String surgeon) {
        String oldId = DoctorService.getLastDoctorId();
        String id = " ";
        if(oldId.equals(" "))
            id = "DOC1000";
        else {
            int num = Integer.parseInt(oldId.substring(3));
            id = oldId.substring(0, 3) + String.valueOf(num + 1);
        }
        Doctor doctor = new Doctor(name, id, department, hod, specialization, age, address, phoneNumber, gender, password,designation,surgeon,"0");
        Boolean val = doctorDAO.saveDoctorInfo(doctor);
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Doctor added by admin");
        if(val)
            return 1;
        else
            return 0;
    }

    public static ArrayList<Doctor> showAllDoctor() throws DoctorListEmptyException {

            ArrayList<Doctor> doctorList = doctorDAO.showAllDoctorInfo();
            if(doctorList.size()==0)
                throw new DoctorListEmptyException();
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Doctor list fetched");
        return doctorList;
    }

    public static ArrayList<Patient> showAllPatient() throws PatientListNotFoundException {
        ArrayList<Patient> patientList = patientDAO.showAllPatientInfo();
        if(patientList.size()==0)
            throw new PatientListNotFoundException("Patient list is empty");
        /*for (Patient patient : doctorList) {
            System.out.println(patient.getName());

        }*/
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Patient list fetched");
        return patientList;
    }
    public static Boolean addDepartment(String name,String hod){
        String oldId = departmentDAO.getLastIdDepartment();
        String id = " ";
        if(oldId.equals(" ")){
            id = "DEP1000";
        }
        else{
            int num = Integer.parseInt(oldId.substring(3));
            id = oldId.substring(0,3)+ String.valueOf(num+1);
        }
        Department department = new Department(id,name,hod);
        Boolean val = departmentDAO.saveDepartmentInfo(department);
        if(val ==true)
            System.out.println("SUCCESS");
        else
            System.out.println("failure");
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Department added by admin");
        return val;
    }
    public static Department getDepartmentById(String id) throws DepartmentNotFoundException {
        Department department = departmentDAO.getDepartmentInfo(id);
        if(department.getId()==" ")
            throw new DepartmentNotFoundException("Department not found");
        System.out.println(department.getName());
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Departmnt retrieved by a id");
        return department;
    }

    public static Department getDepartmentByHod(String hod) throws DepartmentNotFoundException{
        Department department = departmentDAO.getDepartmentInfoByHod(hod);
        if(department.getId()==" ")
            throw  new DepartmentNotFoundException("Department not found");
        System.out.println(department.getName());
        return department;
    }

    public static ArrayList getAllDepartment() throws DepartmentListNotFoundException {
        ArrayList<Department> departmentList = departmentDAO.getAllDepartment();
        if(departmentList.size() ==0)
            throw new DepartmentListNotFoundException("Department list is empty");
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Department list fetched by admin");
        return departmentList;
    }

    public static ArrayList showAllReassignment() throws ReassignmentListEmptyException{
        ArrayList<Reassignment> reassignmentList = reassignmentDAO.showAllReassignmentInfo();
        if(reassignmentList.size()==0)
            throw new ReassignmentListEmptyException("Reassignment list is empty");
        for (Reassignment re: reassignmentList){
            System.out.println(re.getId());
        }
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Reassignment list fetched by admin");
        return reassignmentList;
    }

    public static Boolean updateReassignmentStatus(String id){
        Boolean val = reassignmentDAO.updateReassignmentInfo(id);
        if (val){
            Reassignment reassignment = reassignmentDAO.getReassignmentById(id);
            Patient patient = patientDAO.getPatientInfoById(reassignment.getPatientId());
            patient.setStatus("Reassignment approved");
            patientDAO.updatePatientInfo(patient);
            System.out.println("success");}
        else
            System.out.println("failure");
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Reassignment list updated");
        return val;
    }

    public static Boolean addMedicine(String patientId, String medicine, String appointmentId){
        Boolean val = adminDAO.addMedicineInfo(patientId,medicine,appointmentId);
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Medicine added a particular patient");
        return val;
    }

    public static Boolean addTest(String patientId, String test, String appointmentId){
        Boolean val = adminDAO.addTestInfo(patientId,test, appointmentId);
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Test added a particular patient");
        return val;
    }

    public static Boolean addPatientLogs(String patientId,String inDate, String inTime, String outDate, String outTime, String appointmentId){
        //String id ="12";
        String oldId = adminDAO.getLastIdPatientLogs();
        String id = " ";
        if(oldId.equals(" ")){
            id = "LOG1000";
        }
        else{
            int num = Integer.parseInt(oldId.substring(3));
            id = oldId.substring(0,3)+ String.valueOf(num+1);
        }
        Boolean val = adminDAO.addPatientLogsInfo(id, patientId, inDate, inTime, outDate, outTime, appointmentId);
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Admin creates the patient logs");
        return val;
    }

    public static ArrayList showAllPatientLogs() throws PatientLogsNotFoundException{
        ArrayList<PatientLogs> logs = adminDAO.showAllPatientLogs();
        if(logs.size()==0)
            throw new PatientLogsNotFoundException("patient logs is empty");
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Admin view all patient logs");
        return logs;
    }

    public static ArrayList showAllMedicineByPatientId(String patientId, String appointmentId) throws MedicineNotFoundException{
        ArrayList<String> medicineList = adminDAO.showAllMedicineByPatientId(patientId, appointmentId);
        if(medicineList.size()==0)
            throw new MedicineNotFoundException("Medicine list is empty");
        return medicineList;
    }

    public static ArrayList ShowAllTestByPatientId(String patientId, String appointmentId) throws TestNotFoundException{
        ArrayList<String> testList = adminDAO.showAllTestByPatientId(patientId, appointmentId);
        if(testList.size()==0)
            throw new TestNotFoundException("Test list is empty");
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
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Admin allocates doctor to a patient");
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
		/*try{
		    int v = AdminService.adminLogin("root","root1");
        }
        catch (InvalidLoginException e){
		    System.out.print(e.toString());
        }*/
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
