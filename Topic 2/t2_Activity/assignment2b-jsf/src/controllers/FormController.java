//  Author: Brydon Johnson
//  Date: 2/21/21
//  Class: CST-235
//  Statement: This work is my own.


package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
@ViewScoped
public class FormController {
	public String onSubmit() {
		
		// going into the application context in order to get the user data which was entered via the login-form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// testing our captured data by printing to the console
		System.out.println("The first name is: " + user.getFirstname());
		System.out.println("The last name is: " + user.getLastname());
		//more work to do here
		
		// put the user object back into the request in order to pass along to the TestResponse page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		// show the next page
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) {


		// put the user object back into the request in order to pass along to the TestResponse page
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().put("User", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
}
