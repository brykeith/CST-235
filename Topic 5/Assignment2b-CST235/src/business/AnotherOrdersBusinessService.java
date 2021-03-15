

package business;

import java.util.List;
import java.util.ArrayList;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;
import beans.Orders;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	private List<Order> orders;
	
    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
    	/*
    	 * Create ArrayList and populate it with dummy data
    	 */
    	orders = new ArrayList<Order>();
		orders.add(new Order("prod 1", "desc 1", 43.99F, 2));
		orders.add(new Order("prod 2", "desc 2", 457.99F, 1));
		orders.add(new Order("prod 3", "desc 3", 6781.99F, 1));
		orders.add(new Order("prod 4", "desc 4", 68.99F, 1));
		orders.add(new Order("prod 5", "desc 5", 768.99F, 1));
		orders.add(new Order("prod 6", "desc 6", 678.99F, 2));
		orders.add(new Order("prod 7", "desc 7", 678.99F, 2));
		orders.add(new Order("prod 8", "desc 8", 89.99F, 1));
		orders.add(new Order("prod 9", "desc 9", 89.99F, 3));
		orders.add(new Order("prod 10", "desc 10", 89.99F, 2));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
    	System.out.println("Hello AnotherOrdersBusinessService.");
    }


	@Override
	public List<Order> getOrders() {
		return this.orders;
	}


	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
