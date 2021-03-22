package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

@RequestScoped
@Path("/orders")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class ordersRestService {
	
	@Inject
	OrdersBusinessInterface bs;
	
//	get all records and show json
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getAllThingsAsJson() {
		return bs.getOrders();
	}
	
//	get all records and show xml
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getAllThingsAsXml() {
		List<Order> orders = bs.getOrders();
		return orders.toArray(new Order[orders.size()]);
	}


}
