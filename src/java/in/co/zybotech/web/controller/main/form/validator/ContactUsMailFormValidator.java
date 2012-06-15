package in.co.zybotech.web.controller.main.form.validator;

import static org.springframework.validation.ValidationUtils.rejectIfEmpty;
import in.co.zybotech.core.spring.bind.validation.Validator;
import in.co.zybotech.web.controller.main.form.ContactUsMailForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("contactUsMailFormValidator")
public class ContactUsMailFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ContactUsMailForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ContactUsMailForm form = (ContactUsMailForm) target;

		rejectIfEmpty(errors, "from", "error.v2.field.current.empty",
				"Password cannot be blank");
	}

}
