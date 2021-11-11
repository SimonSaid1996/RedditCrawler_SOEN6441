package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;

public class Users {

	public static Hashtable<String, User> allUsers = new Hashtable<>();
	
	
	public static User getUser(String userId){
		
		//System.out.println(userId);
		if (!allUsers.containsKey(userId)){
			allUsers.put(userId, new User(userId));
		} 
		
		User user = allUsers.get(userId);
		
		return user;
	}
}
