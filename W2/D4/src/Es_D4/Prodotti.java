package Es_D4;

public class Prodotti {

	static Long id = 0L;
	public String name;
	public Categories category;
	double price;

	public Prodotti(String _name, Categories _category, double _price) {
		name = _name;
		category = _category;
		price = _price;
		id = id++;
	}

	public Categories getCategory() {
		return category;
	}

	private double setDiscount(double _price) {
		if (category == Categories.BOYS) {
			price = _price * (10 / 100);
		}
		return price;
	}

	@Override
	public String toString() {

		return name + ", " + category + ", " + price;

	}

}
