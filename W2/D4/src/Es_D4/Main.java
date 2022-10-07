package Es_D4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		List<Prodotti> productList = new ArrayList<>();

		List<Customer> c1 = new ArrayList<>();

		List<Order> o1 = new ArrayList<>();

		Customer customer1 = new Customer("giorgio", 2);

		c1.add(new Customer("pippo", 2));
		c1.add(new Customer("strong", 2));
		c1.add(new Customer("popi", 2));
		c1.add(new Customer("pipo", 2));
		c1.add(new Customer("clown", 2));
		c1.add(new Customer("circo", 2));
		c1.add(new Customer("tendone", 2));

		for (int i = 0; i < 20; i++) {

			productList.add(new Prodotti("prod" + i, Categories.BOOKS, Math.floor(Math.random() * 100 + 100)));
			productList.add(new Prodotti("prod" + i + "B", Categories.BABY, Math.floor(Math.random() * 20 + 1)));
			productList.add(new Prodotti("prod" + i + "C", Categories.BOYS, Math.floor(Math.random() * 20 + 1)));

		}

		Stream<Prodotti> pList = productList.stream();

		// pList.forEach((p) -> System.out.println(p));

		Stream<Prodotti> pippoStrong = pList.filter((p) -> ((Prodotti) p).getCategory() == Categories.BOOKS);

		pippoStrong.forEach((p) -> System.out.println(p));

		// ESERCIZIO NUMERO 2 CHE FA SCHIFO AL CASCO
		for (int i = 0; i < 10; i++) {
			o1.add(new Order(productList, customer1));
		}

		Stream<Order> oList = o1.stream();

		// oList.forEach((o) -> System.out.println(((Order) o).getDate()));

		Stream<Order> orderStrong = oList.filter(o -> o.products.stream()
				.anyMatch((c) -> c.equals("Books")));

		System.out.println(orderStrong.toString());
		//orderStrong.forEach((o) -> System.out.println(o));

		// FINE ESERCIZIO 2 SCHIFOSO CHE NON HO MAI COMPLETATO

		// INIZIO ESERCIZIO 3 CHE FA PIU' SCHIFO DEGLI ALTRI 2

		Stream<Prodotti> boyzList = productList.stream();

		Stream<Prodotti> boyzStrong = boyzList.filter((p) -> ((Prodotti) p).getCategory() == Categories.BOYS);

		boyzStrong.forEach((p) -> System.out.println(p));

		// FINE ESERCIZIO 3

	}

	public void filterPerProduct(List<Prodotti> productList) {
		List<Prodotti> prodFiltered = productList.stream().filter(o -> o.category == Categories.BABY)
				.collect(Collectors.toList());

	}

}
