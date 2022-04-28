package inventory.csye7374.model;

public class Item {
	private String slNo;
	private String itemName;
	private Double itemCost;
	private int available;

	public String getSlNo() {
		return slNo;
	}

	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemCost() {
		return itemCost;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return slNo + "," + itemName + "," + itemCost + "," + available;
	}

}
