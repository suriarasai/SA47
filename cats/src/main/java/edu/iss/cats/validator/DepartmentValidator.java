package edu.iss.cats.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.cats.model.Department;
@Component
public class DepartmentValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Department.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Department d = (Department) target;
		ValidationUtils.rejectIfEmpty(errors, "departmentId", "error.department.departmentId.empty");
		ValidationUtils.rejectIfEmpty(errors, "managerInCharge", "error.department.managerInCharge.empty");
	    System.out.println(d.toString());
	}
}
