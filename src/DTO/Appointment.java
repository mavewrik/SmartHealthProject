package DTO;

public class Appointment {
    private String patientId;
    private String doctorId;
    private String date;

    public Appointment(){
        this.patientId = " ";
        this.doctorId = " ";
        this.date = " ";
    }

    public Appointment(String patientId,String doctorId,String date){
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
