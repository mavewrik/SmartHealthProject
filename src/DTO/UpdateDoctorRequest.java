package DTO;

public class UpdateDoctorRequest {
    String id;
    String departmentId;
    String doctorId;
    String designation;
    String specialization;
    String surgeon;
    String status;

    public UpdateDoctorRequest(){
        this.id = " ";
        this.departmentId = " ";
        this.doctorId = " ";
        this.designation = " ";
        this.specialization = " ";
        this.surgeon = " ";
        this.status = " ";
    }

    public UpdateDoctorRequest(String id,String departmentId, String doctorId, String designation, String specialization, String surgeon, String status){
        this.id = id;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.designation = designation;
        this.specialization = specialization;
        this.surgeon = surgeon;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(String surgeon) {
        this.surgeon = surgeon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
