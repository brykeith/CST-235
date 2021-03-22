package business;

import java.util.List;
import model.MyOrder;

public interface DataAccessInterface {
	
	public List<MyOrder> findAll();
}
