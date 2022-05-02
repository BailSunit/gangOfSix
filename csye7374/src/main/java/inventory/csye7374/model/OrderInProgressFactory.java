package inventory.csye7374.model;

public class OrderInProgressFactory {
	public static State getInstance(Order o) {
		return new OrderInProgress(o);
	}
}
