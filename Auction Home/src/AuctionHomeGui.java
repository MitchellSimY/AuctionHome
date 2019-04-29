
 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
//import LoginSystem.LoginSystem;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JPanel;
 
 
 
public class AuctionHomeGui {
	
	
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
	
	public static void bid(String itemName) {
		Scanner cin = new Scanner(System.in);

		// For loop finding the itemName.
		// If the itemName is equivalent to what the
		// user is wanting to bid on, change the 
		// double amount to the new bidAmount
		// temporary variable that sets up itemList.get(i)
		
		for (Item item : itemList) {
			if (itemName.equals(item.getItemName())) {
			
				System.out.println("How much would you like to bid on it?");
				double bidAmount = cin.nextDouble();
			
				if (item.isAvilable() == true && bidAmount > item.getAmount()) {
					item.setAmount(bidAmount);
					item.isFalse();
					System.out.println("Successful Bid!");
					menuOption();
					break;
				}else if (bidAmount < item.getAmount() && itemName.equals(item.getItemName())) {
					System.out.println("Bid amount was not enough");
					menuOption();	
				}
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
			biddingOnItem();
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
	
	
	
	private static void biddingOnItem() {
		Scanner cin = new Scanner(System.in);

		System.out.println("What item would you like to bid on?");
		String userItemInput = cin.nextLine();
		
		System.out.println("How much would you like to bid on it?");
		double userItemAmountInput = cin.nextDouble();
		
		bid(userItemInput);
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
		
		
		System.out.println("\nYour item has been added!");
		
		menuOption();
		
	}
	
	
 
    private JFrame AuctionHome;
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AuctionHomeGui window = new AuctionHomeGui();
                    window.AuctionHome.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    
		addItem("iPhone", 50, "New iphone 2019");
		addItem("Bike", 15, "Used bike Model X");
		
		System.out.println("==============================================");
		System.out.println("         Welcome to the Auction House!");
		System.out.println("==============================================");
		
		menuOption();
    
    }
 
    /**
     * Create the application.
     */
    public AuctionHomeGui() {
        initialize();
    }
 
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        //Creates new frame
        AuctionHome = new JFrame();
        AuctionHome.setBounds(100, 100, 1009, 701);
        AuctionHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AuctionHome.getContentPane().setLayout(null);
       
        //Auction Home Text
        JLabel lblAuctionHome = new JLabel("Auction Home");
        lblAuctionHome.setBounds(259, 0, 437, 98);
        lblAuctionHome.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 60));
        AuctionHome.getContentPane().add(lblAuctionHome);
       
       
//        //Displays what user you are logged in as
//        JLabel lblLoggedInAs = new JLabel("Hello, " + LoginSystem.username);
//        lblLoggedInAs.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 20));
//        lblLoggedInAs.setBounds(12, 11, 386, 87);
//        AuctionHome.getContentPane().add(lblLoggedInAs);
       
        //Logout button
        JButton btnLogout = new JButton("LOGOUT");
        btnLogout.setBounds(750, 40, 198, 36);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0)
            {
 
               
                //Closes AuctionHome and opens loginSystem
                AuctionHome.dispose();
//                LoginSystem.main(null);
               
               
 
            }
        });
        AuctionHome.getContentPane().add(btnLogout);
       
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 100, 991, 2);
        AuctionHome.getContentPane().add(separator);
        
        
        
        Item item = itemList.get(0);
        JLabel itemName = new JLabel(item.getItemName());
        itemName.setBounds(249, 154, 71, 29);
        AuctionHome.getContentPane().add(itemName);
        
        JLabel itemDescription = new JLabel(item.getItemDescription());
        itemDescription.setFont(new Font("Tahoma", Font.ITALIC, 11));
        itemDescription.setBounds(388, 134, 210, 68);
        AuctionHome.getContentPane().add(itemDescription);
        
        JLabel itemPrice = new JLabel(Double.toString(item.getAmount()));
        itemPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
        itemPrice.setBounds(630, 161, 46, 14);
        AuctionHome.getContentPane().add(itemPrice);
        
        
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblName.setBounds(249, 109, 101, 36);
        AuctionHome.getContentPane().add(lblName);
        
        JLabel lblDescription = new JLabel("Description");
        lblDescription.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblDescription.setBounds(388, 109, 121, 36);
        AuctionHome.getContentPane().add(lblDescription);
        
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPrice.setBounds(620, 109, 121, 36);
        AuctionHome.getContentPane().add(lblPrice);
        
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(974, 100, 17, 551);
        AuctionHome.getContentPane().add(scrollBar);
        
        JLabel timeLeft = new JLabel("Time Left");
        timeLeft.setFont(new Font("Tahoma", Font.BOLD, 20));
        timeLeft.setBounds(784, 109, 121, 36);
        AuctionHome.getContentPane().add(timeLeft);
        
        JLabel pictureLabel = new JLabel("Photo");
        pictureLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        pictureLabel.setBounds(67, 109, 101, 36);
        AuctionHome.getContentPane().add(pictureLabel);
        

        
        
        
        
        
    }
}