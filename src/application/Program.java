package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.order.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliene data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		sc.nextLine();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String Status = sc.nextLine();
		System.out.print("How many items to this order? ");
		Integer numberItems = sc.nextInt();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(Status), new Client(name, email, birthDate));
		
		for (int i = 1; i <= numberItems; i++) {
			sc.nextLine();
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			
			OrderItem item = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			order.addItem(item);
		}
		
		sc.close();
		
		System.out.println();
		System.out.println(order);
		
	}

}
