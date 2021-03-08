package business;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.Order;


@Stateless
@Local
public class OrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders = new ArrayList<Order>();
	
	public OrdersBusinessService() {
		orders.add(new Order("000", "Rubber Ducky", 100.99F, 123));
		orders.add(new Order("001", "Mini Sail Boat", 123.99F, 135));
		orders.add(new Order("002", "HotWheel G-Wagon", 38.95F, 3567));
		orders.add(new Order("003", "LightSaber", 234.66F, 876));
		orders.add(new Order("004", "Slime", 123.99F, 84));
		orders.add(new Order("005", "Lego Chubacca", 24.24F, 654));
		orders.add(new Order("006", "DrumSet", 41.74F, 765));
		orders.add(new Order("007", "Whiskey Stones", 48.85F, 312));
		orders.add(new Order("008", "Lulu Joggers", 253.37F, 6798));
		orders.add(new Order("009", "Spy Novels", 657.65F, 5643));
	}
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("1++++++ HELLO THIS IS OrdersBusinessService.Test() ++++++");
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		this.orders = orders;
		
	}

}
