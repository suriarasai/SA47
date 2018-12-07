package sg.iss.demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LecturerValidator implements Validator {

	public LecturerValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

}
