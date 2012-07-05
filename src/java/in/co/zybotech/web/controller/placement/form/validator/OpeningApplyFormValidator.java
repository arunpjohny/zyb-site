package in.co.zybotech.web.controller.placement.form.validator;

import in.co.zybotech.core.spring.bind.validation.Validator;
import in.co.zybotech.web.controller.placement.form.OpeningApplyForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("placementOpeningApplyFormValidator")
public class OpeningApplyFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OpeningApplyForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	}

}