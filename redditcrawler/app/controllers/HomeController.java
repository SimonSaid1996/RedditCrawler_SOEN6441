package controllers;
import java.util.concurrent.CompletionStage;
import play.mvc.*;
import models.RedditSearch;

public class HomeController extends Controller {

   /**
     * Home page for waiting the user input.
     */
    public Result homeScreen() {
        return ok(views.html.homePage.render());
    }
	
	
	 /**
     * Searching method for asynchronously get latest ...
     */
	public Result search(String searchKey){
        System.out.println(searchKey);
		RedditSearch.getlatestsubmissions(searchKey);
        return ok(views.html.homePage.render());
		
    }
	


}
