package controllers;
import java.util.List;

import models.*;
import play.data.*;
import play.mvc.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;



public class HomeController extends Controller {
    //testing case needs alt+space, then create the test cases, below web will explain     
	//https://www.jetbrains.com/help/idea/create-tests.html
	

    /**
     * Home page for waiting the user input.
     */
    public Result homeScreen() {
        return ok(views.html.homePage.render());
    }
	
	/**
     * Searching method for asynchronously get latest ...
     */
	//public Result search(String args){ 
	public CompletionStage<Result> search(String args){
		
		String[] parts = args.split("--guid");
		String searchKey = parts[0];
		String userId = parts[1];
		
		User user = Users.getUser(userId);
		
        RedditExtractor extractorthread = new RedditExtractor(user);
        //extractorthread.getLatestSubmissions(searchKey);
		
		return extractorthread.getLatestSubmissions(searchKey).thenApplyAsync( dummyV->renderHelper(user) );
		//return ok(views.html.searchResultPage.render(user.getCache()));
        //return redirect(controllers.routes.HomeController.homeScreen());
		
    }

	
	public Result renderHelper(User user){
		// a wrapper function to help rerender because required for lambda function to be used in thenapplysymc
		return ok(views.html.searchResultPage.render(user.getCache()));
	}


    //create a href link and link it to the routes, make my own part of function
    //public Result DistWord(){   //original
    public CompletionStage<Result> DistWord( String userId ){
        String searchKey = "trump";
        //assuming "weather", "trump" results in the cache, find the trump results first in the cache and return lists

        //use isthereakey in the user function to get all caches, then write a function to return all those reddits
        //and put all those reddit list into the function to
        //if searchkey the same, store that reditsearch
		User user = Users.getUser(userId);
        RedditSearchResult curRed = user.findKWordRed(searchKey);
        //System.out.println(curRed);

        //return ok("dist");  //original
        return  RedditExtractor.getDistW(curRed).thenApplyAsync(reds ->ok(reds));

    }
	
	public Result PartA(String profileName){

        //each search is gonna create a diff user here, think abt how to move the user to the session

        //if user is null, then do so
        RedditExtractor extractorthread = new RedditExtractor();

        return ok(views.html.searchResultProfile.render(extractorthread.PartA_getProfileInfo(profileName)));

    }

}

