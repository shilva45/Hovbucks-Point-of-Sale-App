import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public Scanner sc = new Scanner(System.in);
	public Random rand = new Random();
	public ArrayList<Food> foods = new ArrayList<Food>();
	
	public ArrayList<Order> orders = new ArrayList<Order>();
	
	private int orderCounter = 1;
	private String inputName;
	private String inputID = "";
	private int foodChoice = 0;
	private int addOnChoice = 0;
	private int continueChoice;
	
	public void menu() {
		System.out.println("Welcome to Hovbucks");
		System.out.println("===================================");
		System.out.println("1) Input Order");
		System.out.println("2) View Order");
		System.out.println("3) Check Out Order");
		System.out.println("4) Exit");
		System.out.print(">> ");
	}
	
	public void orderList() {
		System.out.println("Choose your order");
		System.out.println("1) Breakfast Roll       (   25000)");
		System.out.println("2) Ham and Cheese       (   35000)");
		System.out.println("3) Tuna Panini          (   30000)");
		System.out.println("4) Aglio Olio           (   45000)");
		System.out.println("5) Bolognese            (   40000)");
		System.out.println("6) Alfredo              (   45000)");
		System.out.println("7) Carbonara            (   45000)");
		System.out.print(">> ");
	}
	
	public void addOnList() {
		System.out.println("Choose add on(s) [0 to finish]");
		System.out.println("1) Parmesan Cheese      (   12000)");
		System.out.println("2) Tuna Mayo            (   17500)");
		System.out.println("3) Mozzarella Cheese    (   12000)");
		System.out.println("4) Beef Bacon           (   25000)");
		System.out.println("5) Thousand Island      (    3000)");
		System.out.println("6) Honey Mustard        (   10000)");
		System.out.println("7) Mayonnaise           (    4500)");
		System.out.print(">> ");
	}
	
	public void create() {
		System.out.print("Input customer name: ");
		inputName = sc.nextLine();
		inputID += orderCounter / 100;
		inputID += (orderCounter / 10) % 10;
		inputID += orderCounter % 10;
		inputID += (char)(rand.nextInt(26) + 65);
		inputID += (char)(rand.nextInt(26) + 65);
		inputID += (char)(rand.nextInt(26) + 65);
		
		System.out.println(inputID + " - " + inputName);
		System.out.println("===================================");
		ArrayList<Food> currFoodOrders = new ArrayList<Food>();
		
		do {
			orderList();
			foodChoice = sc.nextInt();
			sc.nextLine();
			Food currFood = foods.get(foodChoice-1);
			ArrayList<AddOn> currAddOn = new ArrayList<AddOn>();
			
			int addOnChoice = 0;
			do {
				addOnList();
				addOnChoice = sc.nextInt();
				sc.nextLine();
				
				switch (addOnChoice) {
				case 1:
					currAddOn.add(new AddOn(1, "Parmesan Cheese", 12000));
					break;
				case 2:
					currAddOn.add(new AddOn(2, "Tuna Mayo", 17500));				
					break;
				case 3:
					currAddOn.add(new AddOn(3, "Mozzarella Cheese", 12000));
					break;
				case 4:
					currAddOn.add(new AddOn(4, "Beef Bacon", 25000));
					break;
				case 5:
					currAddOn.add(new AddOn(5, "Thousand Island", 3000));
					break;
				case 6:
					currAddOn.add(new AddOn(6, "Honey Mustard", 10000));
					break;
				case 7:
					currAddOn.add(new AddOn(7, "Mayonnaise", 4500));
					break;
				default:
					break;
				}
				
			} while(addOnChoice != 0);
			
			currFood.setAddOns(currAddOn);
			currFoodOrders.add(currFood);
			
			System.out.println("Would you like to continue? [1 = yes / 2 = no]");
			System.out.print(">> ");
			continueChoice = sc.nextInt();
			sc.nextLine();
			System.out.println("");
			
		} while (continueChoice == 1);
		
		orders.add(new Order(inputID, inputName, currFoodOrders));
		
		orderCounter++;
		inputID = "";
	}
	
	public void view() {
		if(orders.isEmpty()) {
			System.out.println("No active orders!");
			return;
		}
		
		for (Order order : orders) {
			System.out.println("Order ID  : " + order.getOrderID());
			System.out.println("Customer  : " + order.getCustName());
			System.out.println("");
			
			for (Food food : order.getFoods()) {
				System.out.println("Product Name  : " + food.getName());
				System.out.println("Base Price    : " + food.getPrice());
				System.out.print("Add on: ");
				if(food.getAddOns().isEmpty()) {
					System.out.println("-");
				} else {
					System.out.println("");
					for (AddOn addon : food.getAddOns()) {
						System.out.println(" + " + addon.getPrice() + " (" + addon.getName() + ")");
					}
				}
				
				System.out.println("Product price : " + food.calcPrice());
				System.out.println("");
			}
			
			System.out.println("Total order: " + order.getTotalOrder());
			System.out.println("===================================");	
		}
	}
	
	public void checkout() {
		if(orders.isEmpty()) {
			System.out.println("No active orders!");
			return;
		}
		
		Order order = orders.get(0);
		System.out.println("Order ID  : " + order.getOrderID());
		System.out.println("Customer  : " + order.getCustName());
		System.out.println("");
		
		for (Food food : order.getFoods()) {
			System.out.println("Product Name  : " + food.getName());
			System.out.println("Base Price    : " + food.getPrice());
			System.out.print("Add on: ");
			if(food.getAddOns().isEmpty()) {
				System.out.println("-");
			} else {
				System.out.println("");
				for (AddOn addon : food.getAddOns()) {
					System.out.println(" + " + addon.getPrice() + " (" + addon.getName() + ")");
				}
			}
			
			System.out.println("Product price : " + food.calcPrice());
			System.out.println("");
		}
		
		System.out.println("Total order: " + order.getTotalOrder());
		
		orders.remove(0);
		
		System.out.println("Successfully checked out.");
	}
	
	public Main() {
		foods.add(new Food(1, "Breakfast Roll", 25000, null));
		foods.add(new Food(2, "Ham and Cheese", 35000, null));
		foods.add(new Food(3, "Tuna Panini", 30000, null));
		foods.add(new Food(4, "Aglio Olio", 45000, null));
		foods.add(new Food(5, "Bolognese", 40000, null));
		foods.add(new Food(6, "Alfredo", 45000, null));
		foods.add(new Food(7, "Carbonara", 45000, null));
		
		int menuChoice = 0;
		
		while(menuChoice != 4) {
			menu();
			menuChoice = sc.nextInt();
			sc.nextLine();
			
			switch (menuChoice) {
			case 1:
				create();
				break;
			case 2:
				view();
				break;
			case 3:
				checkout();
				break;
			case 4:
				
				break;

			default:
				break;
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("");
		
		
		new Main();
	}

}
