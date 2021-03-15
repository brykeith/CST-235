
package beans;
import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class Orders {
	protected List<Order> orders = new ArrayList<Order>();
	
	public Orders() {
		/*
		 * Test data for orders response page
		 */
		orders.add(new Order("7692363895", "Samsung 1TB SSD", 199.99F, 2));
		orders.add(new Order("6298638572", "Raspberry Pi 4", 49.99F, 1));
		orders.add(new Order("6298638572", "Raspberry Pi 4 Case", 15.00F, 1));
		orders.add(new Order("6298638572", "Raspberry Pi 4 Screen", 34.99F, 1));
		orders.add(new Order("4507693749", "Nitendo Switch 32 GB Console", 441.00F, 1));
		orders.add(new Order("4507693749", "Nitendo Joy-Con", 69.00F, 2));
		orders.add(new Order("4507693749", "Mario Kart 8 Deluxe", 44.99F, 1));
		orders.add(new Order("4507693749", "Mario + Rabbids Kingdom Battle", 26.99F, 1));
		orders.add(new Order("3720365683", "SanDisk Cruzer 32GB Flash Drive", 19.99F, 5));
		orders.add(new Order("7692363895", "Security Testing With Raspberry Pi", 22.00F, 1));
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
