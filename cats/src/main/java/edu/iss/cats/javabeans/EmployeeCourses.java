package edu.iss.cats.javabeans;


import java.util.ArrayList;

import edu.iss.cats.model.Course;
import edu.iss.cats.model.Employee;

public class EmployeeCourses  {

    private Employee employee = null;
    private ArrayList<Course> courses = null;

    public EmployeeCourses() {
    }

    public void setEmployee (Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee () {
        return employee;
    }

    public void setCourses (ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses (){
        return courses;
    }

}