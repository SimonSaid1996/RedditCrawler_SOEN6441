package models;

public class SingleSubmission {
	
	private String author;
	private String subreddit;
	private String title;
	
	private String submissionLink;
	
	public SingleSubmission() {
		
	}
	
	public SingleSubmission(String author, String subreddit, String title, String submissionLink) {
		this.author=author;
		this.subreddit=subreddit;
		this.title=title;
		this.submissionLink=submissionLink;
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
	public String getSubmissionLink() {
		return submissionLink;
	}
	public void setSubmissionLink(String submissionLink) {
		this.submissionLink = submissionLink;
	}	
	

}
