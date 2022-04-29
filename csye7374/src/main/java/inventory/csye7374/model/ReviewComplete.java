package inventory.csye7374.model;

public class ReviewComplete implements ReviewState {

	public Employee employee;

	public ReviewComplete(Employee employee) {
		this.employee = employee;
	}

	@Override
	public void recentlyHired() {
		System.out.println("Can't go from Review Complete to Recently Hired");

	}

	@Override
	public void reviewPending() {
		System.out.println("Can't go from Review Complete to Review Pending");
	}

	@Override
	public void reviewComplete() {
		employee.setCurrentState(employee.getReviewComplete());
	}
	
	@Override
	public String toString() {
		return "ReviewComplete";
	}
}
