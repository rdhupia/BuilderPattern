// Core User class
public class User {
	
	private String email;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String province;
	private String phoneNumber;
	
	// Single constructor for our User object
	/* Make Constructor privale, new instances can only be made from the builder */
	private User( UserBuilder builder ) {      
		email = builder.email;
		firstName = builder.firstName;
		lastName = builder.lastName;
		street = builder.street;
		city = builder.city;
		province = builder.province;
		phoneNumber = builder.phoneNumber;
	}
	
	// Getters and Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/* Anyone using this class should use the builder. To completely prevent instance creation
	 * without using the builder, we make the builder part of the User class. 
	 * The builder would be a static class inside our class. 
	 * We would make the constructor private. 
	 * This way we can only create new instances from the builder & constructor is not exposed. */
	static final class UserBuilder {
		
		private String email;
		private String firstName;
		private String lastName;
		private String street;
		private String city;
		private String province;
		private String phoneNumber;
		

		// We have setters for each of these values
		/* Builder uses fluent interface idiom - no 'set' */                                           // makes code more readable                            
		/* Setter returns a builder object holding the value, and any other previously set values */   // Helps chain our calls together
		
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		public UserBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public UserBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public UserBuilder street(String street) {
			this.street = street;
			return this;
		}
		public UserBuilder city(String city) {
			this.city = city;
			return this;
		}
		public UserBuilder province(String province) {
			this.province = province;
			return this;
		}
		public UserBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		// Build method checks if we have necessary info to build the instance, else throws IllegalStateException
		public User build() {
			if( email == null ) {
				throw new IllegalStateException("Missing email");
			}
			if( firstName == null ) {
				throw new IllegalStateException("Missing first name");
			}
			if( lastName == null ) {
				throw new IllegalStateException("Missing last name");
			}
			return new User(this);
		}
		
	}
	
}
