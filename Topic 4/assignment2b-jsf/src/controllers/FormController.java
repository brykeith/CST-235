//  Author: Brydon Johnson
//  Date: 2/21/21
//  Class: CST-235
//  Statement: This work is my own.


package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.AnotherOrdersBusinessService;
import business.MyTimerService;
import business.OrdersBusinessInterface;
import business.OrdersBusinessService;

@ManagedBean
@ViewScoped
public class FormController {
	
//	@Inject
//	OrdersBusinessInterface services;

//	@Inject
	OrdersBusinessInterface service = new AnotherOrdersBusinessService();
	
	@EJB MyTimerService timer;
	
	public String onSubmit() {
		
		// going into the application context in order to get the user data which was entered via the login-form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// testing our captured data by printing to the console
		//more work to do here
		
		// TESTING
		// Orders orders = new Orders();
		// FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("orders", orders);
		
//		testing out OrdersBusinessInterface
//		should print a message to the console to tell which business service is currently being used.
		service.test();
		
//		start a timer when the login is clicked
		timer.setTimer(2000);
		
		
		// put the user object back into the request in order to pass along to the TestResponse page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		// show the next page
		return "TestResponse.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		return service;
	}
	
	
	
	
	public String onFlash(User user) {


		// put the user object back into the request in order to pass along to the TestResponse page
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().put("User", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
}
