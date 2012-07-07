package in.co.zybotech.web.controller.productsandservices.form.validator;

import in.co.zybotech.core.spring.bind.validation.Validator;
import in.co.zybotech.web.controller.productsandservices.form.TestimonialForm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class TestimonialFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TestimonialForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TestimonialForm form = (TestimonialForm) target;

		if (form.getId() == 0
				&& (form.getImage() == null || form.getImage().isEmpty())) {
			errors.rejectValue("image",
					"productsandservices.testimonial.image.empty",
					"Image cannot be empty");
		}

		if (form.getImage() != null
				&& !form.getImage().isEmpty()
				&& !StringUtils.endsWithAny(StringUtils.lowerCase(form
						.getImage().getOriginalFilename()), "jpeg", "jpg",
						"png", "gif")) {
			errors.rejectValue("image",
					"productsandservices.testimonial.image.filetype.invalid",
					"Allowed image types are jpeg, jpg, png and gif");
		}
	}

}
