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
	}
	
	public Patient(String name, String id, String gender, String phoneNumber, String address,int age,String ailment,String email,String password) {
		
		this.name = name;
		this.Id = id;
		this.Gender = gender;
		this.PhoneNumber = phoneNumber;
		this.Address = address;
		this.age = age;
		this.ailment = ailment;
		this.email = email;
		this.password = password;
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
