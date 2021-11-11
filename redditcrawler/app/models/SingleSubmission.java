package models;

public class SingleSubmission {
	
	private String author;
	private String subreddit;
	private String title;
	
	private String authorLink;
	private String subredditLink;
	private String titleLink;
	
	public SingleSubmission() {
		
	}
	
	public SingleSubmission(String author, String subreddit, String title) {
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
