package business;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.Order;


@Stateless
@Local
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders = new ArrayList<Order>();
	
	public AnotherOrdersBusinessService() {
		orders.add(new Order("00a", "Mini Sail Boat", 123.99F, 135));
		orders.add(new Order("00b", "HotWheel G-Wagon", 38.95F, 3567));
		orders.add(new Order("00c", "Lego Chubacca", 24.24F, 654));
		orders.add(new Order("00d", "Rubber Ducky", 100.99F, 123));
		orders.add(new Order("00e", "LightSaber", 234.66F, 876));
		orders.add(new Order("00f", "DrumSet", 41.74F, 765));
		orders.add(new Order("00g", "Whiskey Stones", 48.85F, 312));
		orders.add(new Order("00h", "Slime", 123.99F, 84));
		orders.add(new Order("00i", "Spy Novels", 657.65F, 5643));
		orders.add(new Order("00j", "Lulu Joggers", 253.37F, 6798));
	}
	
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("2++++++ HELLO THIS IS ANOTHEROrdersBusinessService.Test() ++++++");
	}

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}

