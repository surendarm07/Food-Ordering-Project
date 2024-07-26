package FoodOrder;

import java.util.*;

public class FoodOrderingSystem {
	private static Database db = new Database();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. Customer");
			System.out.println("2. Admin");
			System.out.println("3. Exit");
			System.out.print("Choose your role: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
			case 1:
				customerMenu(scanner);
				break;
			case 2:
				adminMenu(scanner);
				break;
			case 3:
				System.out.println("Exiting...");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void customerMenu(Scanner scanner) {
		System.out.println("Menu:");
		for (MenuItem item : db.getMenu()) {
			System.out.println(item);
		}

		System.out.print("Enter your name: ");
		String customerName = scanner.nextLine();
		System.out.print("Enter the name of the food item you want to order: ");
		String foodName = scanner.nextLine();
		System.out.print("Enter the quantity: ");
		int quantity = scanner.nextInt();
		scanner.nextLine(); // consume newline

		MenuItem item = null;
		for (MenuItem menuItem : db.getMenu()) {
			if (menuItem.getName().equalsIgnoreCase(foodName)) {
				item = menuItem;
				break;
			}
		}

		if (item != null) {
			Order order = new Order(customerName, item, quantity);
			db.addOrder(order);
			System.out.println("Order placed successfully!");
		} else {
			System.out.println("Food item not found.");
		}
	}

	private static void adminMenu(Scanner scanner) {
		System.out.println("Orders:");
		for (Order order : db.getOrders()) {
			System.out.println(order);
		}

		System.out.print("Enter the order ID to update the status: ");
		int orderId = scanner.nextInt();
		scanner.nextLine(); // consume newline
		Order order = db.getOrderById(orderId);

		if (order != null) {
			System.out.print("Enter new status: ");
			String status = scanner.nextLine();
			order.setStatus(status);
			System.out.println("Order status updated successfully!");
		} else {
			System.out.println("Order not found.");
		}
	}
}
