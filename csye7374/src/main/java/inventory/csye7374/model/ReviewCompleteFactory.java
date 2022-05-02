package inventory.csye7374.model;

public class ReviewCompleteFactory {
	public static ReviewState getInstance(Employee e) {
		return new ReviewComplete(e);
	}
}
