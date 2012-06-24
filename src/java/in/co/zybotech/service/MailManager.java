package in.co.zybotech.service;

import in.co.zybotech.core.service.Manager;

public interface MailManager extends Manager {

	void sendMail(String from, String to, String subject, String body);

}
