package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;
import model.MyOrder;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {

	@EJB OrdersDataService service;
    /**
     * Default constructor. 
     */
    public OrderMessageService() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	if(message instanceof TextMessage) {
        	try {
        		TextMessage textMessage = (TextMessage)message;
        		System.out.println("Message received: " + textMessage.getText());
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        } else if(message instanceof ObjectMessage) {
        	try {
        		ObjectMessage objMessage = (ObjectMessage)message;
        		MyOrder order = (MyOrder)objMessage.getObject();
        		service.createOrder(order);
        		System.out.println("Order has been submitted.");
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }
    }
    
    public void sendOrder(Order order) {
    	
    }

}
