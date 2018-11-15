package DTO;

public class Reassignment {

    private String id;
    private String patientId;
    private String referringDoctorId;
    private String referredDoctorId;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getReferringDoctorId() {
        return referringDoctorId;
    }

    public void setReferringDoctorId(String referringDoctorId) {
        this.referringDoctorId = referringDoctorId;
    }

    public String getReferredDoctorId() {
        return referredDoctorId;
    }

    public void setReferredDoctorId(String referredDoctorId) {
        this.referredDoctorId = referredDoctorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reassignment(){
        this.id = " ";
        this.patientId = "";
        this.referredDoctorId = " ";
        this.referringDoctorId = " ";
        this.status = " ";
    }

    public Reassignment(String id,String patientId, String referringDoctorId, String referredDoctorId, String status){
        this.id = id;
        this.patientId = patientId;
        this.referringDoctorId = referringDoctorId;
        this.referredDoctorId = referredDoctorId;
        this.status = status;
    }

}
