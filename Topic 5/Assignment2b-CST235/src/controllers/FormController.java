
package controllers;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import beans.User;
import business.OrdersBusinessInterface;
import business.*;

import java.sql.*;

import javax.ejb.EJB;


import javax.inject.Inject;

@ManagedBean(name="formController")
@ViewScoped

public class FormController {
	
	@Inject private OrdersBusinessInterface service;
//	@EJB MyTimerService timer;
	
	public String onSubmit(User user) throws SQLException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getRequestMap().put("User", user);
		service.test();
//		timer.setTimer(99999999);
		getAllOrders();
		insertOrder();
		getAllOrders();
		return "TestResponse.xhtml";
	}
	
	public String onFlash(User user) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().put("User", user);
		return "TestResponse2.xhtml?faces-redirect=true";
	}
	
	public OrdersBusinessInterface getService(){
		return service;
	}
	
	public void getAllOrders() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3307/ical7";
		String user = "root";
		String password = "root";
		
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;	
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
//			System.out.println("Connection is successful! " + dbURL + " user = " + user + " pw = " + password);
			
			//	create a SQL statement
			stmt = c.createStatement();
			
			//	execute the statement
			rs = stmt.executeQuery("SELECT * FROM products");
			
			//	process the rows in the result set
			while(rs.next()) {
				System.out.println("id = " + rs.getInt("ID") + " name = " + rs.getString("PROD_NAME") + " desc = " + rs.getString("PROD_DESC") + " value = "  + rs.getFloat("PROD_PRICE"));
			}
			
		} catch (SQLException e) {
			
			System.out.println("Error communicating with the database");
			e.printStackTrace();
			
		} finally {
			//	close the connection
			rs.close();
			stmt.close();
			c.close();
		}
	
	}
	
	
	public void insertOrder() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3307/ical7";
		String user = "root";
		String password = "root";
		
		Connection c = null;
		Statement stmt = null;
//		ResultSet rs = null;	
		
		
		try {
//			System.out.println("1");
			c = DriverManager.getConnection(dbURL, user, password);
//			System.out.println("2");
			System.out.println("Connection is successful! " + dbURL + " user = " + user + " pw = " + password);
//			System.out.println("3");
			//	create a SQL statement
			stmt = c.createStatement();
//			System.out.println("4");
			
			//	execute the statement
			
			stmt.executeUpdate("INSERT INTO products(PROD_NAME, PROD_DESC, PROD_PRICE) VALUES ('something cool','cool description',100.99)");
//			System.out.println("5");
			System.out.println("Item Successfully added!");
//			System.out.println("6");
			
		} catch (SQLException e) {
//			System.out.println("7");
			System.out.println("Error communicating with the database");
			e.printStackTrace();
			
		} finally {
			//	close the connection
//			rs.close();
			stmt.close();
			c.close();
		}
	
	}
	
	/*
	 * Queries all orders from the orders table
	 */
//	private void getAllOrders() {
//		Connection conn = null;
//		String query = "select * from testapp.orders";
//		try {
//			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
//			Statement statement = conn.createStatement();
//			ResultSet resultSet = statement.executeQuery(query);
//			System.out.println("ID\tProduct_Name\t\tPrice");
//			while(resultSet.next()) {
//				System.out.printf("%d\t%s\t$%.2f\n", resultSet.getInt("id"), resultSet.getString("product_name"), resultSet.getFloat("price"));
//			}
//			resultSet.close();
//			System.out.println("Success!!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Failure!!");
//		}finally {
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	/*
	 * Inserts an product into the orders database.
	 */
//	private void insertOrder() {
//		Connection conn = null;
//		String insertQuery = "insert into testapp.orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('001122334455', 'This was inserted new', 25.00, 100)";
//		try {
//			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
//			Statement statement = conn.createStatement();
//			statement.executeUpdate(insertQuery);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(conn != null) {
//				try{
//					conn.close();
//				} catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
}
