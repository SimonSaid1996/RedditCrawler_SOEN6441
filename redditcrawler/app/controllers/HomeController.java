package controllers;
import java.util.List;

import models.*;
import play.data.*;
import play.mvc.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


//coverage 代码实在不红的话就写一行，改成绿的就行
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
     * Print out target user latest 10 tweets asynchronously with their name, picture and location.
     * @author Ziran Cao and Yugansh Goyal
     * @param args - A string containing the searchkey and the userId passed from main.js
     * @return 10 newst reddit results, name, picture image, location
     * @version v1
     */
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

	    /**
     * a wrapper method to help rerendering the search method,no data changing here
     * @author Ziran Cao
     * @return rerendered version of the searched result page
     */
	public Result renderHelper(User user){
		// a wrapper function to help rerender because required for lambda function to be used in thenapplysymc
		return ok(views.html.searchResultPage.render(user.getCache()));
	}


//////////////////////start, modified the function and added comments, might need to modify the comments later after getting the searchkey by Yugansh
    /**
     * use a key word to retrieve 250 newest results and count the unique words in descending order
     * @author Ziran Cao
     * @param args - a variable from url which contains both userId and the searchKey
     * @return a list of list<string> wrapped within the completionstage to finish processing
     * @version v1
     */

    //create a href link and link it to the routes, make my own part of function
    //public Result DistWord(){   //original
    public CompletionStage<Result> DistWord( String searchKey ){
        //String searchKey = "trump";

        //RedditSearchResult curRed = user.findKWordRed(searchKey);

        //System.out.println(curRed);
		RedditExtractor extractorthread = new RedditExtractor();
		
        return  extractorthread.getDistW(searchKey,250).thenApplyAsync(reds ->ok(views.html.searchResultDistWord.render(reds)));
    }
	
	public CompletableFuture<Result> PartA(String profileName){

        //each search is gonna create a diff user here, think abt how to move the user to the session

        //if user is null, then do so
		//        RedditExtractor extractorthread = new RedditExtractor();
		//        Profile profile = new Profile(profileName);


        return new Profile(profileName).getData().thenApplyAsync(r->ok(views.html.searchResultProfile.render(r)));

    }
	
	public Result PartC_subredditSearch(String Subreddit){
	
		/**
		* Not taking in userid or searchkey
		*user - it does not make sense to store it in cache (we would have to update if user clicks on the subreddit again), so no userid
		*searchkey - as per requirements
		*/

        RedditExtractor extractorthread = new RedditExtractor();

        return ok(views.html.searchResultSubreddit.render(extractorthread.PartC_getSubredditSubmissions(Subreddit)));

    }

}

