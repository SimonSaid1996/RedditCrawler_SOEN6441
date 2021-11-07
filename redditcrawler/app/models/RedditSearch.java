package models;

public class RedditSearch {
	
	private String author;
	private String subreddit;
	private String title;
	
	public RedditSearch() {
		
	}
	
	public RedditSearch(String author, String subreddit, String title) {
		this.author=author;
		this.subreddit=subreddit;
		this.title=title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubreddit() {
		return subreddit;
	}
	public void setSubreddit(String subreddit) {
		this.subreddit = subreddit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
