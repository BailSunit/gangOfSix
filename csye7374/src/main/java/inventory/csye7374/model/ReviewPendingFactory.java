package inventory.csye7374.model;

public class ReviewPendingFactory {
	public static ReviewState getInstance(Employee e) {
		return new PendingReview(e);
	}
}
