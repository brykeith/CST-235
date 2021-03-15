
package business;

import java.util.List;
import java.util.ArrayList;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;
import beans.Orders;


@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {

	private List<Order> orders;
  
    public OrdersBusinessService() {
    	
    	orders = new ArrayList<Order>();
		orders.add(new Order("prod 11", "desc 21", 43.99F, 2));
		orders.add(new Order("prod 22", "desc 22", 457.99F, 1));
		orders.add(new Order("prod 23", "desc 23", 6781.99F, 1));
		orders.add(new Order("prod 24", "desc 24", 68.99F, 1));
		orders.add(new Order("prod 25", "desc 25", 768.99F, 1));
		orders.add(new Order("prod 26", "desc 26", 678.99F, 2));
		orders.add(new Order("prod 27", "desc 27", 678.99F, 2));
		orders.add(new Order("prod 28", "desc 28", 89.99F, 1));
		orders.add(new Order("prod 29", "desc 29", 89.99F, 3));
		orders.add(new Order("prod 30", "desc 30", 89.99F, 2));
    }


    public void test() {
        System.out.println("Hello OrdersBusinessService.");
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
