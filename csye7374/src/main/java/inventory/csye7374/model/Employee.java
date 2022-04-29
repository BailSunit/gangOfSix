package inventory.csye7374.model;

public class Employee {
	private String eid;
	private String name;
	private String position;
	private String email;
	private String phone;
	private ReviewState currentState;
	private ReviewState recentlyHired;
	private ReviewState reviewPending;
	private ReviewState reviewComplete;

	public Employee() {
		recentlyHired = new RecentlyHired(this);
		reviewPending = new PendingReview(this);
		reviewComplete = new ReviewComplete(this);
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ReviewState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(ReviewState currentState) {
		this.currentState = currentState;
	}

	public ReviewState getRecentlyHired() {
		return recentlyHired;
	}

	public void setRecentlyHired(ReviewState recentlyHired) {
		this.recentlyHired = recentlyHired;
	}

	public ReviewState getReviewPending() {
		return reviewPending;
	}

	public void setReviewPending(ReviewState reviewPending) {
		this.reviewPending = reviewPending;
	}

	public ReviewState getReviewComplete() {
		return reviewComplete;
	}

	public void setReviewComplete(ReviewState reviewComplete) {
		this.reviewComplete = reviewComplete;
	}

	@Override
	public String toString() {
		return eid + "," + name + "," + email + "," + phone + "," + position + "," + currentState;
	}
}
