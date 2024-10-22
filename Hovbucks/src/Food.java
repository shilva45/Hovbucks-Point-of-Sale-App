import java.util.ArrayList;

public class Food {
	protected int id;
	protected String name;
	protected int price;
	protected ArrayList<AddOn> addOns;
	
	public Food() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ArrayList<AddOn> getAddOns() {
		return addOns;
	}

	public void setAddOns(ArrayList<AddOn> addOns) {
		this.addOns = addOns;
	}

	public Food(int id, String name, int price, ArrayList<AddOn> addOns) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.addOns = addOns;
	}
	
	public int calcPrice() {
		int total = price;
		for (AddOn addOn : addOns) {
			total += addOn.getPrice();
		}
		
		return total;
	}
}
