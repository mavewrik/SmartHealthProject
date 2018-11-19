package Service;

import DAO.patientDAO;
import DAO.doctorDAO;
import DTO.Appointment;
import DTO.Patient;
import DTO.Doctor;
import DTO.Schedule;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;

public class PatientService {
	
	public static void regsiter(String patientName,int patientAge, String patientAddress,String patientPhone,String patientEmail,String patientAilment,String patientPassword,String patientGender,String healthStatus,String type) {
		Patient patient = new Patient(patientName,patientName.substring(3),patientGender, patientPhone, patientAddress,patientAge,patientAilment,patientEmail,patientPassword,healthStatus, "Unassigned", type);
		patientDAO.savePatientInfo(patient);
	}
	
	public static void updatePatientInfo(Patient patient) {
		System.out.println(patient.getAge());
		Boolean val = patientDAO.updatePatientInfo(patient);
		if (val == true)
			System.out.println("Updated Successfull");
		else
			System.out.println("Update failed");
	}
	
	public static int login(String patientId,String password) {
		Patient patient = patientDAO.getPatientInfo(patientId,password);
		if (patient.getName().equals(" "))
			return 1;
		else
			return 0;
	}

	public static void saveAppointment(String patientId,String doctorId,String date,String slot){
		String id  = "12";
		String status = "upcoming";
		Boolean val = patientDAO.saveAppointment(id,patientId,doctorId,date,slot,status);
		if (val == true){
			Patient patient = patientDAO.getPatientInfoById(patientId);
			patient.setStatus("Assigned");
			PatientService.updatePatientInfo(patient);
			System.out.println("Success");}
		else
			System.out.println("Failure");
	}

	public static ArrayList getAppointmentByPatientId(String patientId){
		ArrayList<Appointment> appointmentList = patientDAO.getAppointmentByPatientId(patientId);
		return  appointmentList;
	}

	public static Appointment getAppointmentById(String id){
		Appointment appointment = patientDAO.getAppointmentById(id);
		return appointment;
	}

	public static void cancelAppointment(String id){
		Boolean val = patientDAO.cancelAppointment(id);
	}

	public static Patient getPatientInfo(String patientId){
		Patient patient = patientDAO.getPatientInfoById(patientId);
		return patient;
	}

	public static ArrayList getDoctorsByDepartmentForReassignment(String departmentId){
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
		return docList;
	}

	public static ArrayList getDoctorsByDepartment(String departmentId){
		//Doctor doctor = doctorDAO.getDoctorInfoById(doctorId);
		//ArrayList<Doctor> doctorList = new ArrayList<>();
		ArrayList<Doctor> docList = doctorDAO.getDoctorInfoByDepartment(departmentId);
		return docList;
	}

	public static Doctor getDoctorById(String id){
		Doctor doctor = doctorDAO.getDoctorInfoById(id);
		return doctor;
	}

	public static ArrayList getDoctorsByName(String name){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByName(name);
		return doctorList;
	}

	public static ArrayList getDoctorsByAddress(String address){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByAddress(address);
		return doctorList;
	}

	public static ArrayList getDoctorsBySpecialization(String specialization){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoBySpecialization(specialization);
		return doctorList;
	}

	public static ArrayList getDoctorsByDepartmentAndDay(String department, String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByDepartmentAndDay(department, day);
		return doctorList;
	}

	public static ArrayList getDoctorsByNameAndDay(String name, String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByNameAndDay(name,day);
		return doctorList;
	}

	public static ArrayList getDoctorsBySpecializationAndDay(String specialization, String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoBySpecializationAndDay(specialization,day);
		return doctorList;
	}

	public static ArrayList getDoctorsByIdAndDay(String id, String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByIdAndDay(id,day);
		return doctorList;
	}

	public static ArrayList getDoctorsByAddressAndDay(String address, String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByAddressAndDay(address,day);
		return doctorList;
	}

	public static ArrayList getDoctorSchedule(String doctorId){
		ArrayList<Schedule> scheduleList = doctorDAO.getDoctorSchedule(doctorId);
		return scheduleList;
	}

	public static ArrayList getDoctorSlotByDate(String doctorId,String date){
		ArrayList<String> slots = patientDAO.getScheduleByDay(doctorId,date);
		for(String s:slots){
			System.out.println(s);
		}
		return  slots;
	}

	public  static void rateDoctor(String appointmentId, String rating){
		Appointment appointment = patientDAO.getAppointmentById(appointmentId);
		if(appointment.getStatus().equals("completed")) {
			Boolean val = patientDAO.updateAppointmentRating(appointmentId, rating);
			ArrayList<Appointment> appointmentList = doctorDAO.getAppointmentByDoctorId(appointment.getDoctorId(),"completed");
			int count = appointmentList.size();
			double totalRating =0.0;
			for(Appointment app: appointmentList){
				if(app.getRating()==null)
					continue;
				else
					totalRating+=Double.parseDouble(app.getRating());
			}
			double netRating = totalRating/count;
			Doctor doctor = doctorDAO.getDoctorInfoById(appointment.getDoctorId());
			doctor.setRating(Double.toString(netRating));
			doctorDAO.updateDoctorInfo(doctor);
		}
		else{
			System.out.println("not possible");
		}
	}

	public static String getLastPatientId(){
		String id = patientDAO.getLastIdPatient();
		return id;
	}

	public static String getLastAppointmentId(){
		String id  = patientDAO.getLastIdAppointment();
		return id;
	}

	public static void main(String args[])throws IOException{
		Patient p = PatientService.getPatientInfo("in");
		//PatientService.saveAppointment("1234","ALV123","10/12/2018");
		//PatientService.getDoctorSchedule("ALV123");
		//PatientService.getDoctorSlotByDate("ALV123","10/12/2018");
		//PatientService.cancelAppointment("1");
		//PatientService.rateDoctor("2","4");
	}

}
