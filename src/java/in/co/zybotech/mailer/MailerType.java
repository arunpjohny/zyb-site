package in.co.zybotech.mailer;

import in.co.zybotech.mailer.impl.MailerImpl;
import in.co.zybotech.mailer.impl.SimpleMailerImpl;

public enum MailerType {
	SIMPLE(SimpleMailerImpl.class), INDIVIDUAL(MailerImpl.class);

	private Class<? extends BulkMailer> clazz;

	private MailerType(Class<? extends BulkMailer> clazz) {
		this.clazz = clazz;
	}

	public Class<? extends BulkMailer> getClazz() {
		return clazz;
	}
}
