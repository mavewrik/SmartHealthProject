package Service;

import DAO.patientDAO;
import DAO.doctorDAO;
import DTO.Patient;
import DTO.Doctor;

import java.io.IOException;
import java.util.ArrayList;

public class PatientService {
	
	public static void regsiter(String patientName,int patientAge, String patientAddress,String patientPhone,String patientEmail,String patientAilment,String patientPassword,String patientGender,String healthStatus) {
		Patient patient = new Patient(patientName,patientName.substring(3),patientGender, patientPhone, patientAddress,patientAge,patientAilment,patientEmail,patientPassword,healthStatus);
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

	public static void saveAppointment(String patientId,String doctorId,String date){
		Boolean val = patientDAO.saveAppointment(patientId,doctorId,date);
		if (val == true)
			System.out.println("Success");
		else
			System.out.println("Failure");
	}
	public static Patient getPatientInfo(String patientId){
		Patient patient = patientDAO.getPatientInfoById(patientId);
		return patient;
	}

	public static void main(String args[])throws IOException{
		PatientService.saveAppointment("1234","ALV123","10/12/2018");
	}

}
