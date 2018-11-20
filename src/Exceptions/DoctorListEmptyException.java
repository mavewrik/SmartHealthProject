package Exceptions;

public class DoctorListEmptyException extends Exception {

    public DoctorListEmptyException(){
        super("Doctor List is empty");
    }
}
