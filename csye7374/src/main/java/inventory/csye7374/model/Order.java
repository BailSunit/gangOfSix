package inventory.csye7374.model;

public class Order implements State {

	private String customerName;
	private Item item;
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

	public Order() {
		this.currentState = new OrderPlaced(this);
		orderPlaced = new OrderPlaced(this);
		orderInProgress = new OrderInProgress(this);
		orderComplete = new OrderComplete(this);
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

}
