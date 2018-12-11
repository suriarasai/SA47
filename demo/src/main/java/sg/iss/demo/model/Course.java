package sg.iss.demo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int cid;
	@Column(name = "course_code")
	private String courseCode;
	@Column(name = "course_name")
	private String courseName;
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;
	private int credit;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "lnric")
	private Lecturer lecturer;
	/*
	This mapping is simple so i have changed the join table to enrolment class 
    @ManyToMany(targetEntity = Student.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "enrolment", joinColumns = {
			@JoinColumn(name = "scid", referencedColumnName = "cid") }, inverseJoinColumns = {
					@JoinColumn(name = "snric", referencedColumnName = "nric") }

	)
	private Set<Student> students = new HashSet<Student>();*/

	// Constructor
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseCode, String courseName, Date startDate, Date endDate, int credit,
			Lecturer lecturer, HashSet<Student> students) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.credit = credit;
		this.lecturer = lecturer;
		//this.students = students;
	}
	
	public Course(String courseCode, String courseName, Date startDate, Date endDate, int credit,
			Lecturer lecturer) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.credit = credit;
		this.lecturer = lecturer;
	}
	

	public Course(String courseCode, String courseName, Date startDate, Date endDate, int credit) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.credit = credit;
	}

	// Getters & Setters
	public int getCid() {
		return cid;
	}


	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

/*	public HashSet<Student> getStudents() {
		return (HashSet<Student>) students;
	}

	public void setStudents(HashSet<Student> students) {
		this.students = students;
	}*/

	// Object Basics
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", courseCode=" + courseCode + ", courseName=" + courseName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", credit=" + credit + ", lecturer=" + lecturer.getName() + ", students="
				+  "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
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
		Course other = (Course) obj;
		if (cid != other.cid)
			return false;
		return true;
	}

}
