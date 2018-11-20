package Service;

import DAO.patientDAO;
import DAO.doctorDAO;
import DTO.Appointment;
import DTO.Patient;
import DTO.Doctor;
import DTO.Schedule;
import Exceptions.*;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import LoggerConfig.LoggerConfig;

public class PatientService {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static Boolean regsiter(String patientName,int patientAge, String patientAddress,String patientPhone,String patientEmail,String patientAilment,String patientPassword,String patientGender,String healthStatus,String type) {
		String oldId = patientDAO.getLastIdPatient();
		String id = " ";
		if(oldId.equals(" ")){
			id = "PAT1000";
		}
		else{
			int num = Integer.parseInt(oldId.substring(3));
			id = oldId.substring(0,3)+ String.valueOf(num+1);
		}
		Patient patient = new Patient(patientName,id,patientGender, patientPhone, patientAddress,patientAge,patientAilment,patientEmail,patientPassword,healthStatus, "Unassigned", type);
		Boolean val = patientDAO.savePatientInfo(patient);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Patient registration");
		return val;
	}
	
	public static Boolean updatePatientInfo(Patient patient) {
		System.out.println(patient.getAge());
		Boolean val = patientDAO.updatePatientInfo(patient);
		if (val == true) {
			LOGGER.setLevel(Level.INFO);
			LOGGER.info("Patient data updated");
			//System.out.println("Updated Successfull");
		}
		else {
			LOGGER.setLevel(Level.INFO);
			LOGGER.warning("Patient data updation failed");
			System.out.println("Update failed");
		}

		return val;
	}
	
	public static int login(String patientId,String password)throws InvalidLoginException {
		Patient patient = patientDAO.getPatientInfo(patientId,password);
		if (patient.getName().equals(" ")) {
			throw new InvalidLoginException();
		}
		else
			return 1;
	}

	public static Boolean saveAppointment(String patientId,String doctorId,String date,String slot){
		String oldId = patientDAO.getLastIdAppointment();
		String id = " ";
		if(oldId.equals(" "))
			id = "APT1000";
		else {
			int num = Integer.parseInt(oldId.substring(3));
			id = oldId.substring(0, 3) + String.valueOf(num + 1);
		}
		String status = "upcoming";
		Boolean val = patientDAO.saveAppointment(id,patientId,doctorId,date,slot,status);
		if (val == true){
			Patient patient = patientDAO.getPatientInfoById(patientId);
			patient.setStatus("Assigned");
			PatientService.updatePatientInfo(patient);
			System.out.println("Success");}
		else
			System.out.println("Failure");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("patient appointment saved");
		return val;
	}

	public static ArrayList getAppointmentByPatientId(String patientId) throws AppointmentNotFoundException {
		ArrayList<Appointment> appointmentList = patientDAO.getAppointmentByPatientId(patientId);
		if(appointmentList.size()==0)
			throw new AppointmentNotFoundException("Appointment not found");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Appointment list fetched for a patient");
		return  appointmentList;
	}

	public static Appointment getAppointmentById(String id) throws AppointmentNotFoundException{
		Appointment appointment = patientDAO.getAppointmentById(id);
		if(appointment.getId().equals(" "))
			throw new AppointmentNotFoundException("Appointment not found");
		return appointment;
	}

	public static Boolean cancelAppointment(String id) throws AppointmentNotFoundException{
		Boolean val = patientDAO.cancelAppointment(id);
		System.out.println(val);
		if(val == false)
		    throw new AppointmentNotFoundException("Appointment not found exception");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Appointment list fetched by id");
		return val;
	}

	public static Patient getPatientInfo(String patientId) throws PatientNotFoundException {
		Patient patient = patientDAO.getPatientInfoById(patientId);
		if(patient.getId().equals(" "))
			throw new PatientNotFoundException("Patient not found");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info(" patient info retrieved");
		return patient;
	}

	public static ArrayList getDoctorsByDepartmentForReassignment(String departmentId) throws DoctorListEmptyException {
		//Doctor doctor = doctorDAO.getDoctorInfoById(doctorId);
		ArrayList<Doctor> doctorList = new ArrayList<>();
		ArrayList<Doctor> docList = doctorDAO.getDoctorInfoByDepartment(departmentId);
		if(docList.size()==0)
			throw new DoctorListEmptyException();
		for(Doctor doc:docList){
			if(doc.getDesignation().equals("Junior Doctor"))
				continue;
			else
				doctorList.add(doc);
		}
		for(Doctor doc:doctorList){
			System.out.println(doc.getName());
		}
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor list fetched for a department");
		return docList;
	}

	public static ArrayList getDoctorsByDepartment(String departmentId) throws DoctorListEmptyException{
		//Doctor doctor = doctorDAO.getDoctorInfoById(doctorId);
		//ArrayList<Doctor> doctorList = new ArrayList<>();
		ArrayList<Doctor> docList = doctorDAO.getDoctorInfoByDepartment(departmentId);
		/*for(Doctor d: docList){
			System.out.println(d.getId());
		}*/
		if(docList.size()==0)
			throw new DoctorListEmptyException();
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor list fetched for a department");
		return docList;
	}

	public static Doctor getDoctorById(String id) throws DoctorNotFoundException {
		Doctor doctor = doctorDAO.getDoctorInfoById(id);
		if(doctor.getId().equals(" "))
			throw new DoctorNotFoundException("Doctor not found");
		return doctor;
	}

	public static ArrayList getDoctorsByName(String name)throws DoctorListEmptyException{
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByName(name);
		if(doctorList.size()==0)
			throw new DoctorListEmptyException();
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor retrieved by name");
		return doctorList;
	}

	public static ArrayList getDoctorsByAddress(String address) throws DoctorListEmptyException{
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByAddress(address);
		if(doctorList.size()==0)
			throw new DoctorListEmptyException();
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor retrieved by address");
		return doctorList;
	}

	public static ArrayList getDoctorsBySpecialization(String specialization)throws DoctorListEmptyException{
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoBySpecialization(specialization);
		if(doctorList.size()==0)
			throw new DoctorListEmptyException();
		return doctorList;
	}

	public static ArrayList getDoctorsByDepartmentAndDay(String department, String day)throws DoctorListEmptyException{
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByDepartmentAndDay(department, day);
		if(doctorList.size()==0)
			throw new DoctorListEmptyException();
		return doctorList;
	}

	public static ArrayList getDoctorsByNameAndDay(String name, String day)throws DoctorListEmptyException{
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByNameAndDay(name,day);
		if(doctorList.size()==0)
			throw new DoctorListEmptyException();
		return doctorList;
	}

	public static ArrayList getDoctorsBySpecializationAndDay(String specialization, String day)throws DoctorListEmptyException{
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoBySpecializationAndDay(specialization,day);
		if(doctorList.size()==0)
			throw new DoctorListEmptyException();
		return doctorList;
	}

	public static ArrayList getDoctorsByIdAndDay(String id, String day)throws DoctorListEmptyException{
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByIdAndDay(id,day);
		if(doctorList.size()==0)
			throw new DoctorListEmptyException();
		return doctorList;
	}

	public static ArrayList getDoctorsByAddressAndDay(String address, String day)throws DoctorListEmptyException{
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByAddressAndDay(address,day);
		if(doctorList.size()==0)
			throw new DoctorListEmptyException();
		return doctorList;
	}

	public static ArrayList getDoctorSchedule(String doctorId){
		ArrayList<Schedule> scheduleList = doctorDAO.getDoctorSchedule(doctorId);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor schedule fetched for a doctor");
		return scheduleList;

	}

	public static ArrayList getDoctorSlotByDate(String doctorId,String date){
		ArrayList<String> slots = patientDAO.getScheduleByDay(doctorId,date);
		for(String s:slots){
			System.out.println(s);
		}
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor list fetched for a particular date");
		return  slots;
	}

	public  static Boolean rateDoctor(String appointmentId, String rating){
		Appointment appointment = patientDAO.getAppointmentById(appointmentId);
		Boolean val1=false;
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
			val1 = doctorDAO.updateDoctorInfo(doctor);
		}
		else{
			System.out.println("not possible");
		}
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor rated by a patient");
		return val1;
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
		//Patient p = PatientService.getPatientInfo("in");
		try {
			ArrayList<Doctor> d = PatientService.getDoctorsByDepartment("sdd");
		}
		catch(DoctorListEmptyException e){

		}
		//PatientService.saveAppointment("1234","ALV123","10/12/2018");
		//PatientService.getDoctorSchedule("ALV123");
		//PatientService.getDoctorSlotByDate("ALV123","10/12/2018");
		//PatientService.cancelAppointment("1");
		//PatientService.rateDoctor("2","4");
	}

}
