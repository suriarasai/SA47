package simple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="ID")
    private int id;
    @Column(name="NAME")
    private String name;
    @Column(name="SALARY")
    private long salary;
    @Column(name="PSPACE_ID")
    private int pspaceid;
    @Column(name="DEPARTMENT_ID")
    private int did;
    
    public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getNumber() {
		return pspaceid;
	}
	public void setNumber(int number) {
		this.pspaceid = number;
	}
	public Employee() {}
    public Employee(int id) {
        this.id = id;
    }

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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", number=" + pspaceid + "]";
	}
 
}
