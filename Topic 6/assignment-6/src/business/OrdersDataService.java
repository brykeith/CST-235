package business;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import model.MyOrder;

/**
 * Session Bean implementation class OrdersDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class OrdersDataService implements DataAccessInterface {
	
	@PersistenceContext(unitName="assignment-6") protected EntityManager em;
	@Resource UserTransaction tran;
    /**
     * Default constructor. 
     */
    public OrdersDataService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see DataAccessInterface#findAll()
     */
    public List<MyOrder> findAll() {
        // TODO Auto-generated method stub
			return em.createNamedQuery("MyOrder.findAll", MyOrder.class).getResultList();
    }
    
    public void createOrder(MyOrder order) {
    	try {
    		tran.begin();
    		em.persist(order);
    		tran.commit();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void rollbackTran() {
    	try {
    		tran.rollback();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
