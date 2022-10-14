package Es_D4;

public class Customer {
	
	static Long id = 0L;
	String name;
	Integer tier;
	
	public Customer(String _name, Integer _tier) {
		id = id++;
		name = _name;
		tier = _tier;
	}

}
