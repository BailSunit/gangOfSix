package inventory.csye7374.model;

public class OrderPlaced implements State {
	
	public Order order;
	
	public OrderPlaced(Order order) {
		this.order = order;
	}

	@Override
	public void orderPlaced() {
		System.out.println("Can't go from Order Placed to Order Placed");
	}

	@Override
	public void orderInProgress() {
		//orderInProgress Start point
		//write to orderList and say order in progress
		order.setCurrentState(order.getOrderInProgress());
	}

	@Override
	public void orderComplete() {
		System.out.println("Can't go from Order Placed to Order Complete");
	}
	
	@Override
	public String toString() {
		return "OrderPlaced";
	}

}
