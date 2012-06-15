package in.co.zybotech.web.controller.main.form;

import org.hibernate.validator.constraints.NotBlank;

public class ContactUsMailForm {

	@NotBlank
	private String from;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String body;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
