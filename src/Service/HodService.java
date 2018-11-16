package Service;

import DAO.departmentDAO;
import DAO.doctorDAO;
import DAO.hodDAO;
import DTO.Department;
import DTO.UpdateDoctorRequest;
import DTO.Doctor;
import java.io.IOException;
import java.util.ArrayList;

public class HodService {

    public static void updateDoctorRequest(String id){
        Boolean val = hodDAO.updateDoctorRequest(id);
        if(val) {
            UpdateDoctorRequest request = hodDAO.getDoctorRequestById(id);
            Doctor doctor = doctorDAO.getDoctorInfoById(request.getDoctorId());
            if (!request.getDesignation().equals("N.A")) {
                doctor.setDesignation(request.getDesignation());
            }
            if (!request.getSpecialization().equals("N.A")) {
                doctor.setSpecialization(request.getSpecialization());
            }
            if (!request.getSurgeon().equals("N.A")) {
                doctor.setSurgeon(request.getSurgeon());
            }
            Boolean value = doctorDAO.updateDoctorInfo(doctor);
        }
    }
    public static void getAllRequest(String doctorId){
        Department department = departmentDAO.getDepartmentInfoByHod(doctorId);
        ArrayList<UpdateDoctorRequest> request = hodDAO.getDoctorRequestByDepartment(department.getId());
        for(UpdateDoctorRequest d: request){
            System.out.println(d.getId());
        }
    }

    public static void main(String args[])throws IOException{
        //HodService.getAllRequest("ALV123");
        HodService.updateDoctorRequest("12");
    }
}
