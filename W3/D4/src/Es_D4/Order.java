package Es_D4;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Order {
	
	static Long id = 0L;
	Status status = Status.Pending;
	LocalDate orderDate;
	LocalDate deliveryDate;
	List<Prodotti> products;
	Customer customer;
	
	public Order(List<Prodotti> _products, Customer _customer) {
		id = id++;
		orderDate = LocalDate.now();
		products = _products;
		customer = _customer;
	}
	
	private void setStatus() {
		
		if(getStatus() == Status.Pending) {
			status = Status.Confirmed;
		}
		if(getStatus() == Status.Confirmed) {
			status = Status.Shipping;
		}
		
	}
	
	public Status getStatus() {
		return status;
	}
	
	public LocalDate getDate() {
		return orderDate;
	}
	@Override
	public String toString() {
		return "id: " + this.id + ", status: " + this.status + ", orderDate: " + this.orderDate + ", products: \n" + this.products + ", customer: " + this.customer + "\n";
	}

}
