package DTO;

public class Doctor {

	private String name;
	private String id;
	private String department;
	private boolean hod;
	private String specialization;
	private String gender;
	private int age;
	private String address;
	private String phoneNumber;
	private String password;
	//private Designation position;
	//private Surgeon surgeon;
	//private Schedule Schedule;
	
	public Doctor() {
		this.name = " ";
		this.id = " ";
		this.department = " ";
		this.hod = false;
		this.specialization = " ";
		this.age =0;
		this.phoneNumber = " ";
		this.gender = " ";
		this.password = " ";
	}
	public Doctor(String name,String id,String department,boolean hod,String specialization, int age,String address, String phoneNumber,String gender,String password) {
				this.name = name;
				this.id = id;
				this.department = department;
				this.hod = hod;
				this.specialization = specialization;
				this.age = age;
				this.address = address;
				this.phoneNumber = phoneNumber;
				this.gender = gender;
				this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public boolean isHod() {
		return hod;
	}
	public void setHod(boolean hod) {
		this.hod = hod;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
