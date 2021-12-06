package controllers;

import actor.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import com.google.inject.Inject;
import models.*;
import play.libs.streams.ActorFlow;
import play.mvc.*;
import scala.compat.java8.FutureConverters;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static akka.pattern.Patterns.ask;

public class HomeController extends Controller {

	/**
	 * ActorSystem Object
	 */
	@com.google.inject.Inject private ActorSystem actorSystem;
	/**
	 *Materializer Object
	 */
	@com.google.inject.Inject private Materializer materializer;


	public static ActorRef s;
	private final ActorRef profileActor;
	private final ActorRef disWActor;
	@Inject
	public HomeController(ActorSystem system) {
		s = system.actorOf(UserManager.props(),"Supervisor");
		profileActor=system.actorOf(ProfileActor.props());
		disWActor = system.actorOf(DistWActor.props());
	}

	public static ActorRef getS() {
		return s;
	}

	/**
	* Home page for waiting the user input.
	* @author All
	*/
    public Result homeScreen() { return ok(views.html.homePage.render()); }

//	public Result homeScreenWithSearch(String search) {
//		System.out.println(search+"-------------");
//    	return ok(views.html.homePag.render(search));
//	}


    /**
     * use a key word to retrieve 250 newest results and count the unique words in descending order
     * @author Ziran Cao
     * @param searchKey - a variable from url which contains both userId and the searchKey
     * @return a list of list<string> wrapped within the completionstage to finish processing
     */
    public CompletionStage<Result> DistWord( String searchKey ){

		return FutureConverters.toJava(ask(disWActor,new DistWActor.SearchWordKey(searchKey),10000))
				.thenApply(r->ok(views.html.searchResultDistWord.render( (List<List<String>>) r)));

	}

	/**
	 * First the function would an object of the Profile and fetch datas needed and send the datas to view
	 * @author Pouya Zargaran
	 * @param profileName The String containing author's name that been sent from view when user clicked on the authors name
	 * @return object of profile contain info about author and its last 10 submission to be shown on view
	 */
	public CompletionStage<Result> PartA(String profileName){

//        return new Profile(profileName).getData().thenApplyAsync(r->ok(views.html.searchResultProfile.render(r)));
		return FutureConverters.toJava(ask(profileActor,new ProfileActor.ProfileQuery(profileName),10000))
				.thenApply(r->ok(views.html.searchResultProfile.render((Profile) r)));

    }


	
	/**
	 * Controller method to display the 10 latest submissions of a particular subreddit
	 * @author Yugansh Goyal
	 * @param Subreddit - A string containing the subreddit name
	 * @return 10 latest reddit submissions having author, title of the particular subreddit
	 */
	public CompletableFuture<Result> PartC_subredditSearch(String Subreddit){
		/**
		* Not taking in userid or searchkey
		*user - it does not make sense to store it in cache (we would have to update if user clicks on the subreddit again), so no userid
		*searchkey - as per requirements
		*/

        RedditExtractor extractorthread = new RedditExtractor();

        return extractorthread.PartC_getSubredditSubmissions(Subreddit).thenApplyAsync(results->ok(views.html.searchResultSubreddit.render(results)));
    }


//    ------------------------------------------------WEB SOCKET---------------------------------------------------------------------

	public WebSocket socket (){

//		return WebSocket.Text.accept(request -> ActorFlow.actorRef(Supervisor::props, actorSystem, materializer));
//		return WebSocket.Text.accept(request -> s.tell(request,ActorRef.noSender()));
		System.out.println("in the controller");
		System.out.println("ccccccccccccccccccccccccccccccccccccccccccccccc");
		return WebSocket.Text.accept(request -> ActorFlow.actorRef(WorkerActor::props, actorSystem, materializer));

	}

}

