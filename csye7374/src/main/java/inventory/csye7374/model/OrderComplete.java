package inventory.csye7374.model;

public class OrderComplete implements State {

	public Order order;

	public OrderComplete(Order order) {
		this.order = order;
	}

	@Override
	public void orderPlaced() {
		System.out.println("Can't go from Order In Progress to Order Placed");
	}

	@Override
	public void orderInProgress() {
		System.out.println("Can't go from Order Placed to Order Complete");
	}

	@Override
	public void orderComplete() {
		System.out.println("Can't go from Order Complete to Order Complete");
	}

	@Override
	public String toString() {
		return "OrderComplete";
	}

}
