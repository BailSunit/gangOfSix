package inventory.csye7374.model;

public class Order implements State {

	private String customer;
	private String itemId;
	private int quantity;
	private State currentState;
	private State orderPlaced;
	private State orderInProgress;
	private State orderComplete;

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

	public Order(State currentState) {
		this.currentState = currentState;
		orderPlaced = new OrderPlaced(this);
		orderInProgress = new OrderInProgress(this);
		orderComplete = new OrderComplete(this);
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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

}
