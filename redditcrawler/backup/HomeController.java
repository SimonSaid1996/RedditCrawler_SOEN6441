package controllers;
import java.util.concurrent.CompletionStage;
import play.mvc.*;
import javax.inject.Inject;

public class HomeController extends Controller {

	@Inject
	FormFactory formFactory;

   /**
     * Home page for waiting the user input.
     */
    public Result homeScreen() {
        return ok(views.html.homePage.render());
    }
	
	
	 /**
     * Searching method for asynchronously get latest ...
     */
	public Result search(){
		Form<RedditSearch> searchForm = formFactory.form(RedditSearch.class)

        return ok(views.html.homePage.render(searchForm));
		
    }
	


}
