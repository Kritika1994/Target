
public class Item {
	String name;
	float price;
	boolean scan;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean scanItem() {
		//scan can be either success or failure.
		return false;
	}
}
