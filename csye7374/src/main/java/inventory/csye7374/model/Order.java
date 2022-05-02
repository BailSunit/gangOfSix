package inventory.csye7374.model;

import java.util.UUID;

public class Order implements State {

	private UUID orderId;
	private String customerName;
	private Item item;
	private int quantity;
	private State currentState;
	private State orderPlaced;
	private State orderInProgress;
	private State orderComplete;

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

	public State getOrderPlaced() {
		return orderPlaced;
	}

	public void setOrderPlaced(State orderPlaced) {
		this.orderPlaced = orderPlaced;
	}

	public State getOrderInProgress() {
		return orderInProgress;
	}

	public void setOrderInProgress(State orderInProgress) {
		this.orderInProgress = orderInProgress;
	}

	public State getOrderComplete() {
		return orderComplete;
	}

	public void setOrderComplete(State orderComplete) {
		this.orderComplete = orderComplete;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public Order() {
		this.currentState = OrderPlacedFactory.getInstance(this);
		orderPlaced = OrderPlacedFactory.getInstance(this);
		orderInProgress = OrderInProgressFactory.getInstance(this);
		orderComplete = OrderCompleteFactory.getInstance(this);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customer) {
		this.customerName = customer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public void orderPlaced() {
		this.currentState.orderPlaced();
	}

	@Override
	public void orderInProgress() {
		this.currentState.orderInProgress();
	}

	@Override
	public void orderComplete() {
		this.currentState.orderComplete();
	}

	public String getCurrentStateName() {
		if (currentState instanceof OrderPlaced) {
			return "OrderPlaced";
		} else if (currentState instanceof OrderInProgress) {
			return "OrderInProgress";
		} else {
			return "OrderComplete";
		}
	}

	public State getCurrentStateFromName(String stateName) {
		if (stateName.equals("OrderPlaced")) {
			return new OrderPlaced(this);
		} else if (stateName.equals("OrderInProgress")) {
			return new OrderInProgress(this);
		} else {
			return new OrderComplete(this);
		}
	}

	@Override
	public String toString() {
		return orderId + "," + customerName + "," + item.getSlNo() + "," + item.getItemName() + "," + item.getItemCost()
				+ "," + quantity + "," + currentState;
	}
}
