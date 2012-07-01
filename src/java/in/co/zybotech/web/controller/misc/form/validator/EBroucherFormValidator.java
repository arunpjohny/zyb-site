package in.co.zybotech.web.controller.misc.form.validator;

import in.co.zybotech.core.spring.bind.validation.Validator;
import in.co.zybotech.web.controller.misc.form.EBroucherForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("eBroucherFormValidator")
public class EBroucherFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EBroucherForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EBroucherForm form = (EBroucherForm) target;

		if (form.getId() == 0
				&& (form.getFile() == null || form.getFile().isEmpty())) {
			errors.rejectValue("image", "student.image.empty",
					"Broucher cannot be empty");
		}
	}

}
