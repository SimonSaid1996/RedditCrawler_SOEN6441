package models;

import java.util.Hashtable;
import java.util.List;

public class User {

	private String UserId;
	private Hashtable<String,List<RedditSearch>> cache;
	
	public User() {
		this.cache = new Hashtable<>();
	}
	
	public User(String UserId) {
		this.UserId=UserId;
	}

	public Hashtable<String, List<RedditSearch>> getCache() {
		return cache;
	}

	public void setCache(Hashtable<String, List<RedditSearch>> cache) {
		this.cache = cache;
	}
	
}
