package in.co.zybotech.web.controller.student;

import in.co.zybotech.core.spring.bind.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("studentFormValidator")
public class StudentFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return StudentForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		StudentForm form = (StudentForm) target;
		if (!StringUtils.endsWithAny(
				StringUtils.lowerCase(form.getImage().getOriginalFilename()),
				"jpeg", "jpg", "png", "gif")) {
			errors.rejectValue("image", "student.image.filetype.invalid",
					"Allowed image types are jpeg, jpg, png and gif");
		}
	}

}
