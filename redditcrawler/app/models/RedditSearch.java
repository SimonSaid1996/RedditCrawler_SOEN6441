package models;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.json.*;

public class RedditSearch {
	
	public String searchKey;
	
	public RedditSearch() {
		
	}
	
	public RedditSearch(String searchKey) {
		this.searchKey = searchKey;
	}
	
	
	public static void getlatestsubmissions(String searchKey){

		String sampleurl = "https://api.pushshift.io/reddit/search/submission/?q="+searchKey+"&size=1";
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(sampleurl)).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
						.thenApply(HttpResponse::body)
						.thenApply(RedditSearch::parse)
						.join();
		
	}
	
	public static String parse(String responseBody){
	
		JSONObject submissionObject = new JSONObject(responseBody);
        JSONArray submissions = submissionObject.getJSONArray("data");

		for(int i =0; i < submissions.length(); i++){
			JSONObject submission = submissions.getJSONObject(i);
			String author = submission.getString("author");
			String subreddit = submission.getString("subreddit");
			String title = submission.getString("title");
			System.out.println(author+" "+subreddit+" "+title);
		}
		
		return null;
		
	}
	
	
}
