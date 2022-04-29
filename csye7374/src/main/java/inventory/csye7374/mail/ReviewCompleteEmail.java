package inventory.csye7374.mail;

public class ReviewCompleteEmail extends MessagingDetails implements Mail {

	public ReviewCompleteEmail() {
		header = "Congrats on completing your review";
		body = "\n\n\nWe are glad you got a chance to speak with your supervisor on where you stand this quarter. All the best for the future and let's keep breakfasts going as well as we can."
				+ "\n\n\nRegards,\nTeam at GangOfSix";
	}
}
