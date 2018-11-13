package DTO;

public class Schedule {

    private String doctorId;
    private String dayOfAvailability;
    private String inTime;
    private String outTime;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDayOfAvailability() {
        return dayOfAvailability;
    }

    public void setDayOfAvailability(String dayOfAvailability) {
        this.dayOfAvailability = dayOfAvailability;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Schedule(){
        this.doctorId = " ";
        this.dayOfAvailability = " ";
        this.inTime = " ";
        this.outTime = " ";
    }
    public Schedule(String doctorId,String dayOfAvailability,String inTime,String outTime){
        this.doctorId = doctorId;
        this.dayOfAvailability = dayOfAvailability;
        this.inTime = inTime;
        this.outTime = outTime;
    }



}
