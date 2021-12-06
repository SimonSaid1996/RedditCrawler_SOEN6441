package models;

import Interface.UserInter;

import java.util.ArrayList;
import java.util.List;

/**
 * A model class representing the a single user session
 * @author Yugansh Goyal and Pooya Zaragaran
 */
public class User implements UserInter {
	
	private String UserId;
	private List<RedditSearchResult> cache;

	/**
	 * Default Contructor, instantiates the cache
	 * @author Yugansh Goyal
	 */
	public User() {
		this.cache = new ArrayList<>();
	}

	/**
	 * Copy Constructor
	 * @author Yugansh Goyal
	 * @param UserId - a string representing the UserId for the user of the session
	 */
	public User(String UserId) {
		this.UserId=UserId;
		this.cache = new ArrayList<>();
	}

	/**
	 * getter method for cache
	 * @author All
	 * @return cache - a List<RedditSearchResult> representing the cache
	 */
	public List<RedditSearchResult> getCache() {
		return cache;
	}

	/**
	 * setter method for cache
	 * @author All
	 * @param cache - a List<RedditSearchResult> representing the cache
	 */
	public void setCache(List<RedditSearchResult> cache) {
		this.cache = cache;
	}

	/**
	 * to find if the cache already has results for the searchkey and remove it
	 * @author Pooya Zaragaran
	 * @param key - A string containing the searchkey
	 */
	public void removeOlderResult(String key){
		for(int i=0; i<this.cache.size();i++){
			if (cache.get(i).getSearchKey().equals(key)){
				cache.remove(i);
				return ;
			}
		}
	}
	
	/**
	 * to append newly fetched result at the begining of the cache to maintain the order
	 * @author Pooya Zaragaran and Yugansh Goyal
	 * @param w - having the new result
	 */
	public void appendCache(RedditSearchResult w ){
		cache.add(0, w);
	}
	
	/**
	 * method to only keep the latest 10 results if the cache overflows
	 * @author Yugansh Goyal
	 */
	public void keepLatestTenResults(){
		System.out.println(this.cache.size());
		if(this.cache.size() == 10 ){
			this.cache.remove(9);
		}
	}
	
	
}
