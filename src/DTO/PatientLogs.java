package DTO;

public class PatientLogs {

    private String id;
    private String patientId;
    private String inDate;
    private String inTime;
    private String outDate;
    private String outTime;
    private String appointmentId;


    public PatientLogs(){
        this.id = " ";
        this.patientId = "";
        this.inDate = "";
        this.inTime ="";
        this.outDate =" ";
        this.outTime =" ";
        this.appointmentId = " ";

    }

    public PatientLogs(String id, String patientId, String inDate, String inTime, String outDate, String outTime, String appointmentId){
        this.id = id;
        this.patientId = patientId;
        this.inDate = inDate;
        this.inTime = inTime;
        this.outDate = outDate;
        this.outTime = outTime;
        this.appointmentId = appointmentId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

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

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }
}
