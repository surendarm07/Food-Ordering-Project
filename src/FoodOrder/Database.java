package FoodOrder;
import java.util.ArrayList;
import java.util.List;

public class Database {
	

	    private List<MenuItem> menu;
	    private List<Order> orders;

	    public Database() {
	        menu = new ArrayList<>();
	        orders = new ArrayList<>();
	        // Adding some menu items
	        menu.add(new MenuItem("Chicken Biriyani", 120.00));
	        menu.add(new MenuItem("Mutton Biriyani", 250.00));
	        menu.add(new MenuItem("Chicken Rice", 100.00));
	    }

	    public List<MenuItem> getMenu() {
	        return menu;
	    }

	    public void addOrder(Order order) {
	        orders.add(order);
	    }

	    public List<Order> getOrders() {
	        return orders;
	    }

	    public Order getOrderById(int id) {
	        for (Order order : orders) {
	            if (order.getId() == id) {
	                return order;
	            }
	        }
	        return null;
	    }
	}



