package in.co.zybotech.service;

import in.co.zybotech.core.service.Manager;

import java.util.Map;

public interface MailManager extends Manager {

	void sendMail(String from, String to, String subject, String body);

	public abstract void sendMail(final String from, final String to,
			final String subject, final String message,
			final Map<String, byte[]> attachments);

}
