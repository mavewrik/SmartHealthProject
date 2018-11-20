package Service;

import Exceptions.DepartmentNotFoundException;
import Exceptions.InvalidLoginException;
import org.junit.Test;
import static org.junit.Assert.*;
import DAO.*;
import DTO.*;

/**
 *
 * @author Wrik
 */
public class AdminServiceTest {
    
//    public AdminServiceTest() {
//    }

    /**
     * Test of adminLogin method, of class AdminService.
     *
     */

    /**
     * Test of addTest method, of class AdminService.
     */
    @Test
    public void testAddTest() {

        // Positive test
        boolean expected = true;
        boolean actual = AdminService.addTest("PAT1001", "ECG", "1234");
        assertEquals(expected, actual);

//        // Negative test
//        boolean expected = true;
//        boolean actual = AdminService.addMedicine("P002", "ECG", "1234");
//        assertEquals(expected, actual);
    }


    @Test
    public void testAdminLogin() throws InvalidLoginException {
        
        // Positive test
        //Admin admin = new Admin("admin", "root", "root");
        int expected = 1;
        int actual = AdminService.adminLogin("root", "root");
        assertEquals(expected, actual);
        
//        // Negative test
//        //Admin admin = new Admin("admin", "root", "root");
//        int expected = 1;
//        int actual = AdminService.adminLogin("root", "hello");
//        assertEquals(expected, actual);
    }

    /**
     * Test of addDoctor method, of class AdminService.
     */
    @Test
    public void testAddDoctor() {
        
        // Positive test
        //Doctor doctor = new Doctor(name, id, department, hod, specialization, age, address, phoneNumber, gender, password,designation,surgeon,"0");
        int expected = 1;
        int actual = AdminService.addDoctor("Bera",  "Physiology", false, "Physio-pathology", 46, "Baguiati", "8776540000", "Male", "password", "Senior Specialist", "Yes");
        assertEquals(expected, actual);
        
//        // Negative test
//        //Doctor doctor = new Doctor(name, id, department, hod, specialization, age, address, phoneNumber, gender, password,designation,surgeon,"0");
//        boolean expected = true;
//        boolean actual = AdminService.addDoctor("Bera", 1002, "Physiology", false, "Physio-pathology", 46, "Baguiati", "8776540000", "Male", "password", "Senior Specialist", "Yes");
//        assertEquals(expected, actual);
    }

    /**
     * Test of showAllDoctor method, of class AdminService.
     */
    @Test
    public void testShowAllDoctor() {
    }

    /**
     * Test of showAllPatient method, of class AdminService.
     */
    @Test
    public void testShowAllPatient() {
    }

    /**
     * Test of addDepartment method, of class AdminService.
     */
    @Test
    public void testAddDepartment() {
        
        // Positive test
        boolean expected = true;
        boolean actual = AdminService.addDepartment( "Psychology", "Bera");
        assertEquals(expected, actual);
        
//        // Negative test
//        boolean expected = true;
//        boolean actual = AdminService.addDepartment(D001, "Psychology", "Bera");
//        assertEquals(expected, actual);
    }

    /**
     * Test of getDepartmentById method, of class AdminService.
     */
    @Test
    public void testGetDepartmentById() throws DepartmentNotFoundException {
        
        // Positive test
        Department expected = new Department("DPT1002", "Psychology", "Bera");
        Department actual = AdminService.getDepartmentById("DPT1002");
        assertEquals(expected.getId(), actual.getId());
        
//        // Negative test
//        Department expected = new Department("D001", "Psychology", "Bera");
//        Department actual = AdminService.getDepartmentById("D002");
//        assertEquals(expected.getId(), actual.getId());
    }

    /**
     * Test of getDepartmentByHod method, of class AdminService.
     */
    @Test
    public void testGetDepartmentByHod() throws DepartmentNotFoundException {
        
        // Positive test
        Department expected = new Department("DPT1002", "Psychology", "Bera");
        Department actual = AdminService.getDepartmentByHod("Bera");
        assertEquals(expected.getHod(), actual.getHod());
        
//        // Negative test
//        Department expected = new Department("D001", "Psychology", "Bera");
//        Department actual = AdminService.getDepartmentByHod("Das");
//        assertEquals(expected.getHod(), actual.getHod());
    }

    /**
     * Test of showAllReassignment method, of class AdminService.
     */
    @Test
    public void testShowAllReassignment() {
    }

    /**
     * Test of updateReassignmentStatus method, of class AdminService.
     */
    @Test
    public void testUpdateReassignmentStatus() {
        
        // Positive test
        boolean expected = true;
        boolean actual = AdminService.updateReassignmentStatus("1002");
        assertEquals(expected, actual);
        
//        // Negative test
//        boolean expected = true;
//        boolean actual = AdminService.updateReassignmentStatus("1004");
//        assertEquals(expected, actual);
    }
    
    /**
     * Test of addMedicine method, of class AdminService.
     */

    @Test
    public void testAddMedicine() {
        
        // Positive test
        boolean expected = true;
        boolean actual = AdminService.addMedicine("PAT1002", "Tylenol", "1234");
        assertEquals(expected, actual);
        
//        // Negative test
//        boolean expected = true;
//        boolean actual = AdminService.addMedicine(P002, "Tylenol", "1234");
//        assertEquals(expected, actual);
    }
    
    /**
     * Test of addPatientLogs method, of class AdminService.
     */
    @Test
    public void testAddPatientLogs() {
        
        // Positive test
        boolean expected = true;
        boolean actual = AdminService.addPatientLogs("PAT1002", "20/11/2018", "14:32", "25/11/2018", "17:36", "1234");
        assertEquals(expected, actual);
        
//        // Negative test
//        boolean expected = true;
//        boolean actual = AdminService.addPatientLogs("P001", "20-11-2018", 14:32, "25-11-2018", "17:36", "1234");
//        assertEquals(expected, actual);
    }

//    /**
//     * Test of main method, of class AdminService.
//     */
//    @Test
//    public void testMain() throws Exception {
//    }
    
}
