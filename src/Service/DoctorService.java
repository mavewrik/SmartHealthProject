package Service;

import java.io.IOException;

import DAO.doctorDAO;
import DTO.Doctor;

public class DoctorService {
	
	public void Login(String id, String password) {
		Doctor doctor = doctorDAO.getDoctorInfo(id, password);
		//System.out.println(doctor);
		if(doctor.getName().equals(" "))
			System.out.println("Login failed");
		else
			System.out.println("Login success");
		
	}
	public void updateDoctorInfo(Doctor doc){
		Boolean val = doctorDAO.updateDoctorInfo(doc);
		if (val ==true)
			System.out.println("Updated successful");
		else
			System.out.println("Update Failed");
	}
	
	public static void main(String args[])throws IOException{
		DoctorService d = new DoctorService();
		//d.Login("ALV1263", "root");
		Doctor d1 = new Doctor("Alvin","ALV123","opd",false,"ENT",30,"Delhi","9748409298","M","root","Senior","JR Sureon");
		d.updateDoctorInfo(d1);
	}

}
