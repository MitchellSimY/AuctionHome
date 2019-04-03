import java.util.ArrayList;
import java.util.Scanner;

public class AuctionHome {
	
	//Creating the ArrayList object.
	static ArrayList<Item> itemList = new ArrayList<Item>();
	
	// Add item method.
	public static void addItem(String itemName, double amount, 
			String itemDescription) {
		
		// Creating the new item object.
		// This creates a new item with the 
		// appropriate parameters
		Item newItem = new Item(itemName, amount, itemDescription);
		
		itemList.add(newItem);
	}
	
	// Bid on the item method
	public static void bid(String itemName, double bidAmount) {
		// For loop finding the itemName.
		// If the itemName is equivalent to what the
		// user is wanting to bid on, change the 
		// double amount to the new bidAmount
		for (int i = 0; i < itemList.size(); i++) {
			
			// temporary variable that sets up itemList.get(i)
			Item item = itemList.get(i);
			
			// This line is an if loop searching the ItemList array, to find the ItemName the user
			// wants to bid on. If the item isAvialable, then the item amount is changed to bidAmount
			if (itemName == item.getItemName() && item.isAvilable() == true) {
				
				if(bidAmount > item.getAmount()){
					item.setAmount(bidAmount);
					item.isFalse();
					System.out.println("Successful Bid!");
					menuOption();
				
				} else {
					System.out.println("Bid amount was not enough");
				}	
			}else {
				System.out.println("Item is not found");
			}
		}	
	}
	
	
	
	//========================================================================================
	//=========================OPTIONS OPTIONS OPTIONS OPTIONS================================
	
	//Displaying menu options
	public static void menuOption() {
		Scanner cin = new Scanner(System.in);
		
		
		System.out.println("\n            Please enter an option  ");
		System.out.println("\n1) View Items Available.");
		System.out.println("2) Start a Bid on an Item.");
		System.out.println("3) Add an item for sale.");
		int option = cin.nextInt();
		cin.nextLine();
		
		// looking into menu options
		if(option == 1) {
			items();
			menuOption();
		} else if (option == 2) {
			//biddingOnItem();
		} else if (option == 3) {
			addingItemInfo();
		}
	}
	
	
	//Viewing items.
	public static void items() {
		System.out.println("-----Here's a listing of items!-----");
		System.out.println(">--------------------------------------------");
		System.out.format("%-10s %-7s %-30s", "|Item Name", "|Price", "|Description              |");
		
		for (int i = 0; i < itemList.size(); i++) {
			Item tempItem = itemList.get(i);
			
				if (tempItem.isAvilable() == true) {
			
					System.out.println();
			
			
					String x = tempItem.getItemName();
					double y = tempItem.getAmount();
					String z = tempItem.getItemDescription();
			
					System.out.println("-----------------------------------------------");
					System.out.format("%-10s %-7s %-30s", "|" + x,"|" + y , "|"+ z);
			}
		}
		System.out.println("\n>--------------------------------------------");

	}
	
	public static void addingItemInfo() {
		Scanner cin = new Scanner(System.in);
		System.out.println("\n\nWhat is the item name?");
		String userItemName = cin.nextLine();
		
		System.out.println("How much do you want to start the bid?");
		double userItemPrice = cin.nextDouble();
		cin.nextLine();
		
		System.out.println("Please enter an item description");
		String userItemDesc = cin.nextLine();
		
		addItem(userItemName, userItemPrice, userItemDesc);
		
		System.out.println("\nYour item has been added!");
		
		menuOption();
		
	}
	//========================================================================================
	//========================================================================================
	
	// Test main
	public static void main(String[] args) {
		addItem("iPhone", 50, "New iphone 2019");
		addItem("Bike", 15, "Used bike Model X");
		
		System.out.println("==============================================");
		System.out.println("         Welcome to the Auction House!");
		System.out.println("==============================================");
		
		menuOption();
	}	
}