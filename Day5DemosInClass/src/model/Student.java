package model;

public class Student implements Comparable<Student> {
	
	private int id;
	private String name;
	private String nick;
	//Constructors
	public Student(int id, String name, String nick) {
		super();
		this.id = id;
		this.name = name;
		this.nick = nick;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	//Print
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", nick=" + nick + "]";
	}
	
	// equals 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}
	
	// Colelection are sorted based on ID
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if (this.id < o.getId()) return -1;
		else if (this.id == o.getId()) return 0;
		else return 1;
	
	}
	

}
