package Service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import DAO.*;
import DTO.*;
import Exceptions.*;

import javax.print.Doc;
import java.util.logging.Level;
import java.util.logging.Logger;
import LoggerConfig.LoggerConfig;

public class DoctorService {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static int Login(String id, String password) throws InvalidLoginException {
		Doctor doctor = doctorDAO.getDoctorInfo(id, password);
		//System.out.println(doctor);
		if(doctor.getName().equals(" ")) {
			LOGGER.setLevel(Level.INFO);
			LOGGER.warning("Doctor login failed");
			throw new InvalidLoginException();
		}
		else {
			LOGGER.setLevel(Level.INFO);
			LOGGER.info("Doctor login succedded");
			return 1;
		}
		
	}

	public static Boolean updateDoctorInfo(Doctor doc){
		Boolean val = doctorDAO.updateDoctorInfo(doc);
		if (val ==true)
			System.out.println("Updated successful");
		else
			System.out.println("Update Failed");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor profile updated");
		return val;
	}

	public static ArrayList getDoctorByDepartmentAndDay(String department,String day) throws DoctorListEmptyException {
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByDepartmentAndDay(department,day);
		if(doctorList.size()==0)
			throw new DoctorListEmptyException();
		for(Doctor doc:doctorList){
			System.out.println(doc.getName());
		}
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor fetches all doctors of a department");
		return doctorList;

	}

	public static ArrayList getPatients(String doctorId) throws PatientListNotFoundException {
		ArrayList<Patient> patientList = doctorDAO.getAllPatients(doctorId);
		if(patientList.size()==0)
			throw new PatientListNotFoundException("patient list not found");
		for (Patient p: patientList){
			System.out.println(p.getName());
		}
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor fetches the assigned patients");
		return patientList;
	}

	public static Boolean reassignment(String patientId, String referringDoctorId, String referredDoctorId){
		String oldId = doctorDAO.getLastIdReassignment();
		String id = " ";
		if(oldId.equals(" ")){
			id = "REQ2000";
		}
		else {
			int num = Integer.parseInt(oldId.substring(3));
			id = oldId.substring(0, 3) + String.valueOf(num + 1);
		}
		String status = "Pending";
		Boolean val = reassignmentDAO.saveReassignmentInfo(id,patientId,referringDoctorId, referredDoctorId,status);
		if(val) {
			Patient patient = patientDAO.getPatientInfoById(patientId);
			patient.setStatus("Reassignment pending");
			PatientService.updatePatientInfo(patient);
			System.out.println("success");
		}
		else
			System.out.println("failure");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor raises reassign request");
		return val;
	}

	public static Boolean isHod(String id){
		Doctor doctor = doctorDAO.getDoctorInfoById(id);
		Boolean result = false;
		if(doctor.isHod())
			result = true;
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Check for doctor being HOD");
		return result;
	}

	public static Boolean isJuniorDoctor(String doctorId){
		Doctor doctor = doctorDAO.getDoctorInfoById(doctorId);
		Boolean result = false;
		if (doctor.getDesignation().equals("Junior Doctor"))
			result = true;
		System.out.println(result);
		return result;
	}
	public static ArrayList getAllDepartment() throws DepartmentListNotFoundException {
		ArrayList<Department> departmentList = departmentDAO.getAllDepartment();
		if(departmentList.size()==0)
			throw new DepartmentListNotFoundException("Deartment list is empty");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("All departments fetched");
		return departmentList;
	}

	public static Department getDepartmentByName(String name) throws DepartmentNotFoundException{
		Department department = departmentDAO.getDepartmentByName(name);
		if(department.getId().equals(" "))
			throw new DepartmentNotFoundException("Invalid department ");
		return department;
	}

	public static Doctor getDoctorInfo(String id) throws DoctorNotFoundException{
		Doctor doctor = doctorDAO.getDoctorInfoById(id);
		if(doctor.getId().equals(" "))
			throw new DoctorNotFoundException("Doctor not found");
		return doctor;
	}


	public static ArrayList getDoctorsByDepartment(String departmentId) throws DoctorListEmptyException{
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
		return doctorList;
	}

	public static Boolean updateRequestToHod(String doctorId, String designation,String specialization,String surgeon){
		Doctor doc = doctorDAO.getDoctorInfoById(doctorId);
		Department department = departmentDAO.getDepartmentByName(doc.getDepartment());
		String oldId = hodDAO.getLastIdHodService();
		int num=0;
		String id = " ";
		if(oldId.equals(" ")) {
			id = "REQ1000";
		}

		else {
			num = Integer.parseInt(oldId.substring(3));
			id = oldId.substring(0, 3) + String.valueOf(num + 1);
		}
		String status = "pending";
		Boolean val = doctorDAO.addRequestToHod(id,doctorId,department.getId(),designation,specialization,surgeon,status);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Update request made by the doctor");
		return val;
	}

	public static PatientLogs getPatientLogsByPatientId(String patientId, String appointmentId) throws PatientLogsNotFoundException{
        PatientLogs patientLogs = doctorDAO.showAllPatientLogsByPatientId(patientId, appointmentId);
        if(patientLogs.getId().equals(" "))
        	throw new PatientLogsNotFoundException("Patient logs not found");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Patient logs retrieved by the doctor");
        return patientLogs;
    }

    public static ArrayList getMedicineByPatientId(String patientId, String appointmentId) throws MedicineNotFoundException{
	    ArrayList<String> medicine = adminDAO.showAllMedicineByPatientId(patientId, appointmentId);
	    if(medicine.size()==0)
	    	throw new MedicineNotFoundException("Medicine not found");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor retrieves the medicines");
	    return medicine;
    }

    public static ArrayList getTestByPatientId(String patientId, String appointmentId) throws TestNotFoundException{
	    ArrayList<String> test = adminDAO.showAllMedicineByPatientId(patientId, appointmentId);
	    if(test.size()==0)
	    	throw new TestNotFoundException("Test not found");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor retrieves the tests done for a patient");
	    return test;
    }

    public static ArrayList getAppointmentByCompletedPatientId(String patientId) throws AppointmentNotFoundException{
		ArrayList<Appointment> appointmentArrayList = doctorDAO.getAppointmentByCompletedPatientId(patientId, "completed");
		if (appointmentArrayList.size()==0)
			throw new AppointmentNotFoundException("Appointment not found");
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Appointment list fetched");
		return appointmentArrayList;
	}

	public static String getLastDoctorId(){
		String id  = doctorDAO.getLastIdDoctor();
		return id;
	}
	public static String getLastAssignmentId(){
		String id = doctorDAO.getLastIdReassignment();
		return id;
	}
	public static int addSchedule(String doctorId, String dayOfAvailability, String inTime, String outTime){
		Boolean val = doctorDAO.addDoctorSchedule( doctorId, dayOfAvailability, inTime, outTime);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Doctor adds a schedule");
		if(val == true)
			return 1;
		else
			return 0;
	}
	
	public static void main(String args[])throws IOException{
		DoctorService d = new DoctorService();
		DoctorService.updateRequestToHod("WRK123","N.A","Dentist","N.A");
		//d.getDoctorByDepartmentAndDay("opd","Monday");
		//DoctorService.getPatients("ALV123");
		//DoctorService.isJuniorDoctor("WRK123");
		//DoctorService.getDoctorsByDepartment("WRK123");
		//DoctorService.reassignment("1234","ALV123","WRK123");
		//d.Login("ALV1263", "root");
		//Doctor d1 = new Doctor("Alvin","ALV123","opd",false,"ENT",30,"Delhi","9748409298","M","root","Senior","JR Sureon");
		//d.updateDoctorInfo(d1);
	}

}
