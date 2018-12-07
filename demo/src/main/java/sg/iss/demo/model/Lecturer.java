package sg.iss.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lecturer")
public class Lecturer {
	@Id
	private String nric;
	private String name;
	@Column(name="nick_name")
	private String nickName;
	@Column(name="phone_number")
	private int phoneNumber;
	private String email;
	private String address;
	@Column(name="user_name")
	private String userName;
	private String password;
	@OneToMany(mappedBy="lecturer",cascade=CascadeType.ALL)
	private Set<Course> courses = new HashSet<Course>();
	//Constructor
	public Lecturer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lecturer(String nric, String name, String nickName, int phoneNumber, String email, String address,
			String userName, String password, Set<Course> courses) {
		super();
		this.nric = nric;
		this.name = name;
		this.nickName = nickName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.courses = courses;
	}
	public Lecturer(String nric, String name, String nickName, int phoneNumber, String email, String address,
			String userName, String password) {
		super();
		this.nric = nric;
		this.name = name;
		this.nickName = nickName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.userName = userName;
		this.password = password;
	}
	// Getters and Setters
	public String getNric() {
		return nric;
	}
	public void setNric(String nric) {
		this.nric = nric;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	// Object Basics
	@Override
	public String toString() {
		return "Lecturer [nric=" + nric + ", name=" + name + ", nickName=" + nickName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", address=" + address + ", userName=" + userName + ", password=" + password
				+ ", courses=" + courses + "]";
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
		Lecturer other = (Lecturer) obj;
		if (nric == null) {
			if (other.nric != null)
				return false;
		} else if (!nric.equals(other.nric))
			return false;
		return true;
	}

}
