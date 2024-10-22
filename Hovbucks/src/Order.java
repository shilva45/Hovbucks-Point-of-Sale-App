import java.util.ArrayList;

public class Order {
	protected String orderID;
	protected String custName;
	protected ArrayList<Food> foods;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(String orderID, String custName, ArrayList<Food> foods) {
		this.orderID = orderID;
		this.custName = custName;
		this.foods = foods;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public ArrayList<Food> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}
	
	public int getTotalOrder() {
		int total = 0;
		
		for (Food food : foods) {
			int subtotal = 0;
			subtotal += food.getPrice();
			for (AddOn addon : food.getAddOns()) {
				subtotal += addon.getPrice();
			}
			
			total += subtotal;
		}
		
		return total;
	}

}
