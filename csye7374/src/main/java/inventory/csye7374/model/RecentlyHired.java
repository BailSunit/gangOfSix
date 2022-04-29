package inventory.csye7374.model;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import inventory.csye7374.mail.Mail;
import inventory.csye7374.mail.ReviewPendingEmail;

public class RecentlyHired implements ReviewState {

	private Employee employee;
	private Mail mail;

	public RecentlyHired(Employee employee) {
		this.employee = employee;
		mail = new ReviewPendingEmail();
	}

	@Override
	public void recentlyHired() {
		System.out.println("Can't go from Recently Hired to Recently Hired");

	}

	@Override
	public void reviewPending() {
		employee.setCurrentState(employee.getReviewPending());
		mail.setRecipient(employee.getEmail());
		try {
			mail.sendMail(employee.getName());
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void reviewComplete() {
		System.out.println("Can't go from Recently Hired to Review Complete");
	}

	@Override
	public String toString() {
		return "RecentlyHired";
	}

}
