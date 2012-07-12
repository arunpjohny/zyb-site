package in.co.zybotech.web.controller.misc.form;

import javax.validation.constraints.NotNull;

import in.co.zybotech.mailer.MailerType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class MailerForm {

	@NotNull
	private MailerType type;

	@NotBlank
	private String subject;

	private String html;

	private String plain;

	private MultipartFile[] attachments;

	private String fields;

	@NotNull
	private MultipartFile source;

	public MailerType getType() {
		return type;
	}

	public void setType(MailerType type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getPlain() {
		return plain;
	}

	public void setPlain(String plain) {
		this.plain = plain;
	}

	public MultipartFile[] getAttachments() {
		return attachments;
	}

	public void setAttachments(MultipartFile[] attachment) {
		this.attachments = attachment;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public MultipartFile getSource() {
		return source;
	}

	public void setSource(MultipartFile source) {
		this.source = source;
	}

}
