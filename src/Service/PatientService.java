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

	public static void getDoctorsByDepartment(String departmentId){
		//Doctor doctor = doctorDAO.getDoctorInfoById(doctorId);
		ArrayList<Doctor> doctorList = new ArrayList<>();
		ArrayList<Doctor> docList = doctorDAO.getDoctorInfoByDepartment(departmentId);
		for(Doctor doc:docList){
			if(doc.getDesignation().equals("Junior Doctor"))
				continue;
			else
				doctorList.add(doc);
		}
		for(Doctor doc:doctorList){
			System.out.println(doc.getName());
		}
	}

	public static void getDoctorById(String id){
		Doctor doctor = doctorDAO.getDoctorInfoById(id);
	}

	public static void getDoctorsByName(String name){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByName(name);
	}

	public static void getDoctorsByAddress(String address){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByAddress(address);
	}

	public static void getDoctorsBySpecialization(String specialization){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoBySpecialization(specialization);
	}

	public static void getDoctorsByDepartmentAndDay(String department, String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByDepartmentAndDay(department, day);
	}

	public static void getDoctorsByNameAndDay(String name, String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByNameAndDay(name,day);
	}

	public static void getDoctorsBySpecializationAndDay(String specialization, String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoBySpecializationAndDay(specialization,day);
	}

	public static void getDoctorsByIdAndDay(String id, String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByIdAndDay(id,day);
	}

	public static void getDoctorsByAddressAndDay(String address, String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByAddressAndDay(address,day);
	}

	public static void main(String args[])throws IOException{
		PatientService.saveAppointment("1234","ALV123","10/12/2018");
	}

}
