package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class RedditExtractor {
	//executor for the api, will ge the search key and data for that search
	//try to use the user cache, not this one
	public String searchKey;//Useless
	public User curUser;


	public RedditExtractor() {

	}

	public RedditExtractor(String searchKey) {
		this.searchKey = searchKey;
	}
	
	
	public void getlatestsubmissions(User user){
		curUser = user;     //to store the user temperarily, for later adding data purpose

		try{
			searchKey = URLEncoder.encode(searchKey,"UTF-8");
		} catch(Exception e){
			System.out.println(e);
		}	
		

		//System.out.println(cache.toString());  ///the place to print the {}


	  //if have searchkey, then show the old results and append the new result
		String sampleurl = "https://api.pushshift.io/reddit/search/submission/?q="+searchKey+"&size=10";




			//adding new results, added wrong way
			storeNewReddit(sampleurl);



		
	}


	public void storeNewReddit (String sampleurl){
		//a function to append new results to the user cache
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(sampleurl)).build();
		Reditsearch reddits = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(this::parse)      //trying to add user to the parse
				.join();
		//to store the data on the cache with the user
		if (curUser.isThereaSameKey(searchKey)) {
			curUser.remove(searchKey);
		}
		curUser.appendCache(reddits);

	}


	public Reditsearch parse(String responseBody){
        //and return a list of redditsearches
		//adding new result to the user cache
		Reditsearch w= new Reditsearch();
		w.setSearchKey(this.searchKey);
		List<SingleReddit> searchResult = new ArrayList<>();  //adding to the new list
		JSONObject submissionObject = new JSONObject(responseBody);
        JSONArray submissions = submissionObject.getJSONArray("data");

		for(int i =0; i < submissions.length(); i++){
			JSONObject submission = submissions.getJSONObject(i);
			String author = submission.getString("author");
			String subreddit = submission.getString("subreddit");
			String title = submission.getString("title");
			
			SingleReddit search = new SingleReddit(author, subreddit, title);
			searchResult.add(search);
			w.setResults(searchResult);
			System.out.println(i+"!!!"+author+"***"+subreddit+" +++ "+title);  //max to 99 searches
		}
		
		return w;
	}
	
	
}
