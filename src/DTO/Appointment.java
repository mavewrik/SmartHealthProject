package DTO;

public class Appointment {
    private String id;
    private String patientId;
    private String doctorId;
    private String date;
    private String status;
    private String slot;
    private String rating;

    public Appointment(){
        this.id = " ";
        this.patientId = " ";
        this.doctorId = " ";
        this.date = " ";
        this.status = " ";
        this.slot = " ";
        this.rating = " ";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Appointment(String id, String patientId, String doctorId, String date, String status, String slot, String rating){
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.status = status;
        this.slot = slot;
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
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
