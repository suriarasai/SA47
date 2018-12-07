package edu.iss.cats.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name="employee")
public class Employee  {
    @Id
    private String employeeId;
    private String name;
    private String managerId;

    public Employee() {
    }

    public Employee(String employeeId,String name, String managerId){
    
    this.employeeId = employeeId;
    this.name = name;
    this.managerId = managerId;
    
    }
    
    public Employee (String employeeId) {
        setEmployeeId(employeeId);
    }

    public void setEmployeeId (String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId () {
        return employeeId;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName (){
        return name;
    }

    public void setManagerId(String managerId){
        this.managerId = managerId;
    }

    public String getManagerId(){
        return managerId;
    }

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", managerId=" + managerId + "]";
	}
    
}