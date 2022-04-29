package inventory.csye7374.model;

public class RecentlyHired implements ReviewState {

	public Employee employee;

	public RecentlyHired(Employee employee) {
		this.employee = employee;
	}

	@Override
	public void recentlyHired() {
		System.out.println("Can't go from Recently Hired to Recently Hired");

	}

	@Override
	public void reviewPending() {
		employee.setCurrentState(employee.getReviewPending());
	}

	@Override
	public void reviewComplete() {
		System.out.println("Can't go from Recently Hired to Review Complete");
	}

	@Override
	public String toString() {
		return "RecentlyHired";
	}

}
