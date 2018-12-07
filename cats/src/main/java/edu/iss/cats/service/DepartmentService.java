package edu.iss.cats.service;

import java.util.ArrayList;

import edu.iss.cats.model.Department;

public interface DepartmentService {

	ArrayList<Department> findAllDepartments();

	Department findDepartment(String did);

	Department createDepartment(Department dep);

	Department changeDepartment(Department dep);

	void removeDepartment(Department dep);

}