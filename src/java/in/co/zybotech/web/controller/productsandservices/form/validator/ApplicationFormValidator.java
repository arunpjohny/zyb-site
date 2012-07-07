package in.co.zybotech.web.controller.productsandservices.form.validator;

import in.co.zybotech.core.spring.bind.validation.Validator;
import in.co.zybotech.web.controller.productsandservices.form.ApplicationForm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component("applicationFormValidator")
public class ApplicationFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ApplicationForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ApplicationForm form = (ApplicationForm) target;

		if (form.getId() == 0
				&& (form.getApplication() == null || form.getApplication()
						.isEmpty())) {
			errors.rejectValue("application",
					"productsandservices.gallery.application.empty",
					"Application cannot be empty");
		}

		if (form.getId() == 0
				&& (form.getImage() == null || form.getImage().isEmpty())) {
			errors.rejectValue("image",
					"productsandservices.gallery.image.empty",
					"Image cannot be empty");
		}

		if (form.getImage() != null
				&& !form.getImage().isEmpty()
				&& !StringUtils.endsWithAny(StringUtils.lowerCase(form
						.getImage().getOriginalFilename()), "jpeg", "jpg",
						"png", "gif")) {
			errors.rejectValue("image", "student.image.filetype.invalid",
					"Allowed image types are jpeg, jpg, png and gif");
		}
	}

}
