package controllers;
import java.util.List;

import models.*;
import play.data.*;
import play.mvc.*;


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
	public Result search(String args){
		
		String[] parts = args.split("--guid");
		String searchKey = parts[0];
		String userId = parts[1];
		
		User user = Users.getUser(userId);
		
        RedditExtractor extractorthread = new RedditExtractor(user);
        extractorthread.getLatestSubmissions(searchKey);
		
		return ok(views.html.searchResultPage.render(user.getCache()));
        //return redirect(controllers.routes.HomeController.homeScreen());
		
    }
	


}
