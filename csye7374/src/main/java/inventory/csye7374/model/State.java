package inventory.csye7374.model;

public interface State {
	void orderPlaced();
	void orderInProgress();
	void orderComplete();
}
