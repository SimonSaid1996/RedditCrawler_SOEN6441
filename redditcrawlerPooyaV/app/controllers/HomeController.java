package controllers;
import java.util.List;


import models.*;
import play.data.*;
import play.mvc.*;

import javax.inject.Inject;


public class HomeController extends Controller {
    public User user = new User("userid");  //initialize the user for each session
//    private FormFactory formFactory;
//    @Inject
//    public HomeController(FormFactory f) {
//        this.formFactory = f;
//    }
   /**
     * Home page for waiting the user input.
     */
    public Result homeScreen() {
//        Form<User> addStrForm = formFactory.form(User.class);
        return ok(views.html.homePage.render(user.getCache()));
    }
	
	
	 /**
     * Searching method for asynchronously get latest ...
     */
	public Result search(String searchKey){

        //each search is gonna create a diff user here, think abt how to move the user to the session

        //if user is null, then do so
        RedditExtractor extractorthread = new RedditExtractor(searchKey);
        extractorthread.getlatestsubmissions(user);
//        List<Reditsearch> currentResults=user.getCache();
        //get submissions from the cache first and then set the new results
        return redirect(controllers.routes.HomeController.homeScreen());
		
    }
	


}
