package Service;
import DTO.*;

import java.io.IOException;

import DAO.adminDAO;
import DAO.doctorDAO;
public class AdminService {

	public static int adminLogin(String username,String password) {
		Admin admin = adminDAO.getAdminInfo(username, password);
		
		if (admin.getName() == null)
			return 0;
		else
			return 1;
	}
	
	public void addDoctor(String name,String id,String department,boolean hod,String specialization, int age,String address, String phoneNumber,String gender,String password) {
		Doctor doctor = new Doctor(name,id,department,hod,specialization,age,address,phoneNumber,gender,password);
		doctorDAO.saveDoctorInfo(doctor);
	}
	
	/*public static void main(String args[])throws IOException{
		AdminService a = new AdminService();
		//a.adminLogin("root", "roo1t");
		a.addDoctor("Alvin","ALV123","opd",false,"ENT",25,"Delhi","9748409298","M","root");
	}*/
	
	
	
}
