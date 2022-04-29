package inventory.csye7374.mail;

public class ReviewPendingEmail extends MessagingDetails implements Mail {

	public ReviewPendingEmail() {
		header = "You have a pending review";
		body = "\n\n\nOur records show that you are due for a review with your manager. Kindly reach out to them for further instructions."
				+ "\n\n\nRegards,\nTeam at GangOfSix";
	}
}
