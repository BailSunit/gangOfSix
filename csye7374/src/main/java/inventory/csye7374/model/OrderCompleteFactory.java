package inventory.csye7374.model;

public class OrderCompleteFactory {
	public static State getInstance(Order o) {
		return new OrderComplete(o);
	}
}
