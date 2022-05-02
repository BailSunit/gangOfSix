package inventory.csye7374.model;

public class OrderInProgress implements State {
	
	public Order order;
	
	public OrderInProgress(Order order) {
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
		order.setCurrentState(order.getOrderComplete());
	}
	
	@Override
	public String toString() {
		return "OrderInProgress";
	}

}
