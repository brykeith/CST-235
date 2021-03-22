
package beans;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="User")
@ViewScoped
public class User{

	@NotNull
	@Size(min=5, max=15)
	protected String firstName;
	protected String lastName;
	
	@NotNull
	@Size(min=5, max=15)
	public User() {
		firstName = "Brydon";
		lastName = "Johnson";
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() { 
		return this.lastName;
	}
	
	public void setFirstName(String firstname) {
		firstName = firstname;
	}
	
	public void setLastName(String lastname) {
		lastName = lastname;
	}
}
