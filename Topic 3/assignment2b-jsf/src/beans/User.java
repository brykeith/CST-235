package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.*;


@ManagedBean
@ViewScoped
public class User {
	
	@NotEmpty(message="must enter a value")
	@NotNull(message="must enter a value") 
	@Size(min=5, max=15, message="must be between 5 and 15 characters") 
	private String firstname;
	
	@NotNull() 
	@Size(min=5, max=15) 
	private String lastname;
	
	public User() {
		firstname = "";
		lastname = "";
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
