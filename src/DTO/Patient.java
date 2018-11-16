package DTO;

public class Patient {
	
	private String name;
	private String Id;
	private String Gender;
	private String PhoneNumber;
	private String Address;
	private int age;
	private String password;
	private String ailment;
	private String email;
	private String healthStatus;
	private String status;
	
	public Patient() {
		this.name = " ";
		this.Id = " ";
		this.Gender = " ";
		this.PhoneNumber = " ";
		this.Address = " ";
		this.age = 0;
		this.password = " ";
		this.email = " ";
		this.ailment = " ";
		this.healthStatus = " ";
		this.status = " ";
	}

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Patient(String name, String id, String gender, String phoneNumber, String address, int age, String ailment, String email, String password, String healthStatus, String status) {
		
		this.name = name;
		this.Id = id;
		this.Gender = gender;
		this.PhoneNumber = phoneNumber;
		this.Address = address;
		this.age = age;
		this.ailment = ailment;
		this.email = email;
		this.password = password;
		this.healthStatus = healthStatus;
		this.status = status;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return Id;
	}
	public String getAilment() {
		return ailment;
	}

	public void setAilment(String ailment) {
		this.ailment = ailment;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String id) {
		Id = id;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
