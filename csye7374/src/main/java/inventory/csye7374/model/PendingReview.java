package inventory.csye7374.model;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import inventory.csye7374.mail.Mail;
import inventory.csye7374.mail.ReviewCompleteEmail;

public class PendingReview implements ReviewState {

	private Employee employee;
	private Mail mail;

	public PendingReview(Employee employee) {
		this.employee = employee;
		mail = new ReviewCompleteEmail();
	}

	@Override
	public void recentlyHired() {
		System.out.println("Can't go from Review Pending to Recently Hired");

	}

	@Override
	public void reviewPending() {
		System.out.println("Can't go from Review Pending to Review Pending");
	}

	@Override
	public void reviewComplete() {
		employee.setCurrentState(employee.getReviewComplete());
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
	public String toString() {
		return "PendingReview";
	}
}
