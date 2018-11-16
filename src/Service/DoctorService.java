package Service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import DAO.*;
import DTO.*;

import javax.print.Doc;

public class DoctorService {
	
	public void Login(String id, String password) {
		Doctor doctor = doctorDAO.getDoctorInfo(id, password);
		//System.out.println(doctor);
		if(doctor.getName().equals(" "))
			System.out.println("Login failed");
		else
			System.out.println("Login success");
		
	}
	public static void updateDoctorInfo(Doctor doc){
		Boolean val = doctorDAO.updateDoctorInfo(doc);
		if (val ==true)
			System.out.println("Updated successful");
		else
			System.out.println("Update Failed");
	}
	public static ArrayList getDoctorByDepartmentAndDay(String department,String day){
		ArrayList<Doctor> doctorList = doctorDAO.getDoctorInfoByDepartmentAndDay(department,day);
		for(Doctor doc:doctorList){
			System.out.println(doc.getName());
		}
		return doctorList;
	}

	public static ArrayList getPatients(String doctorId){
		ArrayList<Patient> patientList = doctorDAO.getAllPatients(doctorId);
		for (Patient p: patientList){
			System.out.println(p.getName());
		}
		return patientList;
	}

	public static void reassignment(String patientId, String referringDoctorId, String referredDoctorId){
		String id = "1234";
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
	}

	public static Boolean isHod(String id){
		Doctor doctor = doctorDAO.getDoctorInfoById(id);
		Boolean result = false;
		if(doctor.isHod())
			result = true;
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
	public static ArrayList getAllDepartment(){
		ArrayList<Department> departmentList = departmentDAO.getAllDepartment();
		return departmentList;
	}

	public static Department getDepartmentByName(String name){
		Department department = departmentDAO.getDepartmentByName(name);
		return department;
	}

	public static Doctor getDoctorInfo(String id){
		Doctor doctor = doctorDAO.getDoctorInfoById(id);
		return doctor;
	}


	public static ArrayList getDoctorsByDepartment(String departmentId){
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
		return doctorList;
	}

	public static void updateRequestToHod(String doctorId, String designation,String specialization,String surgeon){
		Doctor doc = doctorDAO.getDoctorInfoById(doctorId);
		Department department = departmentDAO.getDepartmentByName(doc.getDepartment());
		String id = "12";
		String status = "pending";
		Boolean val = doctorDAO.addRequestToHod(id,doctorId,department.getId(),designation,specialization,surgeon,status);
	}

	public static PatientLogs getPatientLogsByPatientId(String patientId){
        PatientLogs patientLogs = doctorDAO.showAllPatientLogsByPatientId(patientId);
        return patientLogs;
    }

    public static ArrayList getMedicineByPatientId(String patientId, String appointmentId){
	    ArrayList<String> medicine = adminDAO.showAllMedicineByPatientId(patientId, appointmentId);
	    return medicine;
    }

    public static ArrayList getTestByPatientId(String patientId, String appointmentId){
	    ArrayList<String> test = adminDAO.showAllMedicineByPatientId(patientId, appointmentId);
	    return test;
    }

    public static ArrayList getAppointmentByCompletedPatientId(String patientId){
		ArrayList<Appointment> appointmentArrayList = doctorDAO.getAppointmentByCompletedPatientId(patientId, "completed");
		return appointmentArrayList;
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
