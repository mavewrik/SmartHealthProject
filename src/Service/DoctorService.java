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
	
	public static void main(String args[])throws IOException{
		DoctorService d = new DoctorService();
		d.Login("ALV1263", "root");
	}

}
