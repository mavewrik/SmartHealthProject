package Service;

import DAO.patientDAO;
import DTO.Patient;

import java.io.IOException;

public class PatientService {
	
	public static void regsiter(String patientName,int patientAge, String patientAddress,String patientPhone,String patientEmail,String patientAilment,String patientPassword,String patientGender) {
		Patient patient = new Patient(patientName,patientName.substring(3),patientGender, patientPhone, patientAddress,patientAge,patientAilment,patientEmail,patientPassword);
		patientDAO.savePatientInfo(patient);
	}
	
	public void updatePatientInfo(Patient patient) {
		Boolean val = patientDAO.updatePatientInfo(patient);
		if (val == true)
			System.out.println("Updated Successfull");
		else
			System.out.println("Update failed");
	}
	
	public static void login(String patientId,String password) {
		Patient patient = patientDAO.getPatientInfo(patientId,password);
		if (patient.getName().equals(" "))
			System.out.println("Login failure");
		else
			System.out.println("Login Success");
	}
	/*public static void main(String args[])throws IOException {
		PatientService p1 = new PatientService();
		Patient p = new Patient("Swagatam","1234","M","9748409298","Kolkata",20,"","swag@iitd.ac.in","swag");
		p1.updatePatientInfo(p);
	}*/
}
