package inventory.csye7374.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface Mail {
	void setRecipient(String email);
	public void sendMail(String name) throws AddressException, MessagingException;
}
