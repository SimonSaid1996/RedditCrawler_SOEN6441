package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    //user session, each person calling the browser, two browsers will have diff id, and cache
	//also the place to store the prev searches
	private String UserId;
	private List<Reditsearch> cache;

	public User() {
		this.cache = new ArrayList<>();
	}

	public User(String UserId) {
		this.UserId=UserId;
		this.cache = new ArrayList<>();
	}

	public List<Reditsearch> getCache() {
		return cache;
	}

	//not sure why need this method
	public void setCache(List<Reditsearch> cache) {
		this.cache = cache;
	}


	public boolean isThereaSameKey(String key){
		for(int i=0; i<this.cache.size();i++){
			System.out.println(key+"-");
			System.out.println(cache.get(i).getSearchKey()+"-");
			if (cache.get(i).getSearchKey().equals(key)){
				return true;
			}
		}
		return false;
	}
	public void remove(String key){
		for(int i=0; i<this.cache.size();i++){
			System.out.println(key+"-");
			System.out.println(cache.get(i).getSearchKey()+"-");
			if (cache.get(i).getSearchKey().equals(key)){
				cache.remove(i);
				return ;
			}
		}
	}

	//method to append new list to the hashtable
	public void appendCache(Reditsearch w ){cache.add(w);}
}
