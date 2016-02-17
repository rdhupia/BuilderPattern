import java.util.ArrayList;

public class Registration {

	public static void main(String[] args) {
		
		ArrayList<User> users = new ArrayList<User>();
		
		// Preferred way to use builder pattern
		User jack = new User.UserBuilder()
				.email("jack.sparrow@pirates.com")
				.firstName("Jack")
				.lastName("Sparrow")
				.phoneNumber("9993334444")
				.build();
		
		users.add(jack);
		
		//OR
		// Populate the builder and pass that to the class
		User.UserBuilder builder = new User.UserBuilder()
				.email("johnyboy@yahoooo.com")
				.firstName("John")
				.phoneNumber("6662224444")
				.lastName("Boy")
				.city("Toronto");
		// Constructor with builder arg should be the only way to create instances
		// User john = new User( builder );
		User john = builder.build();
		
		users.add(john);
		
		// Display Users
		for(User user : users)
		{
			System.out.println( "Email: " + user.getEmail() );
			System.out.println( "FName: " + user.getFirstName() );
			System.out.println( "LName: " + user.getLastName() );
			if( user.getCity() !=  null )
				System.out.println( "City: " + user.getCity() );
			if( user.getPhoneNumber() != null )
				System.out.println( "Phone: " + user.getPhoneNumber() );
			System.out.println();
		}
	}

}
