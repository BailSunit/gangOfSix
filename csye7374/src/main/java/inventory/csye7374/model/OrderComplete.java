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
		//Order COmplete Start point
		//write to orderList and say order complete

	}
	
	@Override
	public String toString() {
		return "OrderComplete";
	}

}
