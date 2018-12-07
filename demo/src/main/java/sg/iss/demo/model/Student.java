package sg.iss.demo.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "student")
public class Student {
	@Id
	private String nric;
	@Column(name = "nick_name")
	private String nickName;
	private int mark;
	private String name;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	@Column(name = "phone_number")
	private int phoneNumber;
	private String email;
	private String address;
	@Column(name = "user_name")
	private String userName;
	private String password;
	//Constructors
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String nric, String nickName, int mark, String name, Date dob, int phoneNumber, String email,
			String address, String userName, String password) {
		super();
		this.nric = nric;
		this.nickName = nickName;
		this.mark = mark;
		this.name = name;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.userName = userName;
		this.password = password;
	}
	//Getters & Setters
	public String getNric() {
		return nric;
	}
	public void setNric(String nric) {
		this.nric = nric;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// Object Basics
	@Override
	public String toString() {
		return "Student [nric=" + nric + ", nickName=" + nickName + ", mark=" + mark + ", name=" + name + ", dob=" + dob
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", userName="
				+ userName + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nric == null) ? 0 : nric.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (nric == null) {
			if (other.nric != null)
				return false;
		} else if (!nric.equals(other.nric))
			return false;
		return true;
	}
	
	

}