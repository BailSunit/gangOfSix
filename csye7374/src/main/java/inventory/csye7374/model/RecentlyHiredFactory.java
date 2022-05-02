package inventory.csye7374.model;

public class RecentlyHiredFactory {
	public static ReviewState getInstance(Employee e) {
		return new RecentlyHired(e);
	}
}
