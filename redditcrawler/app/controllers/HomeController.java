package controllers;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CompletionStage;
import play.mvc.*;
import models.RedditSearch;
import models.User;
import models.RedditExtractor;

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
        
        User user = new User("userid");
        RedditExtractor extractorthread = new RedditExtractor(searchKey);
        
        extractorthread.getlatestsubmissions(user);

        return ok(views.html.homePage.render());
		
    }
	


}
