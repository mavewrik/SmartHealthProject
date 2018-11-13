package Service;
import DTO.*;

import java.io.IOException;
import java.util.ArrayList;

import DAO.adminDAO;
import DAO.doctorDAO;
import DAO.patientDAO;
import DAO.departmentDAO;
public class AdminService {

    public static int adminLogin(String username, String password) {
        Admin admin = adminDAO.getAdminInfo(username, password);

        if (admin.getName() == null)
            return 0;
        else
            return 1;
    }

    public static void addDoctor(String name, String id, String department, boolean hod, String specialization, int age, String address, String phoneNumber, String gender, String password,String designation,String surgeon) {
        Doctor doctor = new Doctor(name, id, department, hod, specialization, age, address, phoneNumber, gender, password,designation,surgeon);
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
    }
    public static void getDepartmentById(String id){
        Department department = departmentDAO.getDepartmentInfo(id);
        System.out.println(department.getName());
    }

    public static void getDepartmentByHod(String hod){
        Department department = departmentDAO.getDepartmentInfoByHod(hod);
        System.out.println(department.getName());
    }

	
	public static void main(String args[])throws IOException{
		AdminService a = new AdminService();
		//a.showAllDoctor();
        //a.showAllPatient();
        //a.addDepartment("1234","ENT","ALV123");
        a.getDepartmentByHod("ALV123");
        //a.getDepartmentById("1234");
		//a.adminLogin("root", "roo1t");
		//a.addDoctor("Alvin","ALV123","opd",false,"ENT",25,"Delhi","9748409298","M","root");
	}
	
	
	
}
