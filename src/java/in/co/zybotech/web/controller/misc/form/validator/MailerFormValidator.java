package in.co.zybotech.web.controller.misc.form.validator;

import in.co.zybotech.core.spring.bind.validation.Validator;
import in.co.zybotech.mailer.MailerType;
import in.co.zybotech.web.controller.misc.form.MailerForm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component()
public class MailerFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MailerForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MailerForm form = (MailerForm) target;

		if (StringUtils.isBlank(form.getPlain())
				&& StringUtils.isBlank(form.getHtml())) {
			errors.reject("mailer.body.empty",
					"Both html and plain contents cannot be empty.");
		}

		if (form.getSource() == null || form.getSource().isEmpty()) {
			errors.rejectValue("source", "field.empty",
					"Source cannot be blank.");
		}

		if (MailerType.INDIVIDUAL.equals(form.getType())
				&& StringUtils.isBlank(form.getFields())) {
			errors.rejectValue("fields", "field.empty",
					"Fields cannot be blank.");
		}
	}

}