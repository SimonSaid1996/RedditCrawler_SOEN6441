package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;

/**
 * Model class for storing all the user sessions which contains the cache for the user, stored in a hashtable with the userId
 * @author Yugansh Goyal
 */
public class Users {

	public static Hashtable<String, User> allUsers = new Hashtable<>();
	
	/**
	 * Getter method for the User
	 * @author Yugansh Goyal
	 * @param userId - a string representing the UserId for the user of the session
	 */
	public static User getUser(String userId){
		
		if (!allUsers.containsKey(userId)){
			allUsers.put(userId, new User(userId));
		} 
		
		User user = allUsers.get(userId);
		
		return user;
	}
}
