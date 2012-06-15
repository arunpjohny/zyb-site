package in.co.zybotech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.zybotech.core.service.impl.BaseManager;
import in.co.zybotech.service.MailManager;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class MailManagerImpl extends BaseManager implements MailManager {

	@Autowired
	private MailSender mailSender;

	@Override
	public void sendMail(String from, String subject, String body) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setFrom(from);
		simpleMessage.setSubject(subject);
		simpleMessage.setText(body);
		simpleMessage.setTo("arun.official.mail@gmail.com");
		mailSender.send(simpleMessage);
	}

}
