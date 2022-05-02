package inventory.csye7374.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MessagingDetails {
	protected Session newSession;
	protected String from;
	protected String password;
	protected String emailHost;
	protected String recipient;
	protected MimeMessage mimeMessage;
	protected String header;
	protected String body;

	MessagingDetails() {
		from = "no.reply.csye7374@gmail.com";
		password = "csye@7374";
		emailHost = "smtp.gmail.com";
		newSession = null;
		mimeMessage = null;
	}

	public void setRecipient(String email) {
		recipient = email;
	}

	public void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", emailHost);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.user", from);
		newSession = Session.getDefaultInstance(properties);
	}

	public void sendMail(String name) throws AddressException, MessagingException {
		setupServerProperties();
		mimeMessage = new MimeMessage(newSession);
		mimeMessage.setFrom(new InternetAddress(from));
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		mimeMessage.setSubject(header);

		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent("Dear " + name + body, "text/plain");
		MimeMultipart multiPart = new MimeMultipart();
		multiPart.addBodyPart(bodyPart);
		mimeMessage.setContent(multiPart);

		Transport transport = newSession.getTransport("smtp");
		transport.connect(from, password);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		System.out.println("Email successfully sent!!!");
	}
}
