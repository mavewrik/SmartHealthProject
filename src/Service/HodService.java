package Service;

import DAO.departmentDAO;
import DAO.doctorDAO;
import DAO.hodDAO;
import DTO.Department;
import DTO.UpdateDoctorRequest;
import DTO.Doctor;
import java.io.IOException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import LoggerConfig.LoggerConfig;

public class HodService {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static Boolean updateDoctorRequestApproval(String id){
        Boolean val = hodDAO.updateDoctorRequest(id,"Apprved");
        Boolean value = false;
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
            LOGGER.setLevel(Level.INFO);
            LOGGER.info("HOD approves doctor request");
            value = doctorDAO.updateDoctorInfo(doctor);

        }
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("HOD rejects the doctor request");
        return value;
    }

    public static Boolean updateDoctorRequestDenial(String id){
        Boolean val = hodDAO.updateDoctorRequest(id, "Rejected");
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("HOD rejects the doctor request");
        return val;
    }
    public static ArrayList getAllRequest(String doctorId){
        Department department = departmentDAO.getDepartmentInfoByHod(doctorId);
        ArrayList<UpdateDoctorRequest> request = hodDAO.getDoctorRequestByDepartment(department.getId());
        /*for(UpdateDoctorRequest d: request){
            System.out.println(d.getId());
        }*/
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("HOD fetches all update request");
        return  request;
    }

    public static String getLastHodRequestId(){
        String id = hodDAO.getLastIdHodService();
        return id;
    }

    public static void main(String args[])throws IOException{
        //HodService.getAllRequest("ALV123");
        HodService.updateDoctorRequestApproval("12");
    }
}
