package FoodOrder;

public class Order {
	    private static int idCounter = 0;
	    private int id;
	    private String customerName;
	    private MenuItem item;
	    private int quantity;
	    private String status;

	    public Order(String customerName, MenuItem item, int quantity) {
	        this.id = ++idCounter;
	        this.customerName = customerName;
	        this.item = item;
	        this.quantity = quantity;
	        this.status = "Pending";
	    }

	    public int getId() {
	        return id;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public MenuItem getItem() {
	        return item;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    @Override
	    public String toString() {
	        return "Order ID: " + id + ", Customer: " + customerName + ", Item: " + item.getName() + ", Quantity: " + quantity + ", Status: " + status;
	    }
	}


