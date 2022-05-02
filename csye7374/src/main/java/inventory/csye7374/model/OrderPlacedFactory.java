package inventory.csye7374.model;

public class OrderPlacedFactory {
	public static State getInstance(Order o) {
		return new OrderPlaced(o);
	}
}
