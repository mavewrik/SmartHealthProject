package Service;
import DTO.*;

import java.io.IOException;
import java.util.ArrayList;

import DAO.adminDAO;
import DAO.doctorDAO;
import DAO.patientDAO;
public class AdminService {

    public static int adminLogin(String username, String password) {
        Admin admin = adminDAO.getAdminInfo(username, password);

        if (admin.getName() == null)
            return 0;
        else
            return 1;
    }

    public void addDoctor(String name, String id, String department, boolean hod, String specialization, int age, String address, String phoneNumber, String gender, String password,String designation,String surgeon) {
        Doctor doctor = new Doctor(name, id, department, hod, specialization, age, address, phoneNumber, gender, password,designation,surgeon);
        doctorDAO.saveDoctorInfo(doctor);
    }

    public void showAllDoctor() {
        ArrayList<Doctor> doctorList = doctorDAO.showAllDoctorInfo();
        for (Doctor doc : doctorList) {
            System.out.println(doc.getName());

        }
    }

    public void showAllPatient(){
        ArrayList<Patient> doctorList = patientDAO.showAllPatientInfo();
        for (Patient patient : doctorList) {
            System.out.println(patient.getName());

        }
    }

	
	/*public static void main(String args[])throws IOException{
		AdminService a = new AdminService();
		//a.showAllDoctor();
        a.showAllPatient();
		//a.adminLogin("root", "roo1t");
		//a.addDoctor("Alvin","ALV123","opd",false,"ENT",25,"Delhi","9748409298","M","root");
	}*/
	
	
	
}
