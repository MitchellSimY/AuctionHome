
public class Item {
	
	private String itemName;
	private double amount;
	private String itemDescription;
	private boolean isAvailable = true;
	
	
	// Item constructor, creating objects.
	public Item(String itemName, double amount, String itemDescription) {
		this.itemName = itemName;
		this.amount = amount;
		this.itemDescription = itemDescription;
		
	}

	
	// Getters and setters for all 
	// instance variables for item
	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getItemDescription() {
		return itemDescription;
	}


	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	public boolean isAvilable() {
		return isAvailable;
	}
	
	//====================================
	
	// Turning isAvailable false if item is unavailable
	public void isFalse() {
		isAvailable = false;
	}
	
	//
	
}
