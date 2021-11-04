package controllers;
import model.Reddit;
import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    public Result doSearch(String key) {   //assuming key to be science for testing
        //combine the weblink here for testing
        String original = "https://api.pushshift.io/reddit/search/comment/?q=";
        String combined = original+key;
        Reddit rd = null;
        System.out.println("i am testing here");

        //this method isn't connected to the html page, need to figure it out, then run this part

        //can use json object to parse object, it is in the play library
        //com.fasterxml.jackson.databind.node.arraynode and then use the json node somehow
        /*ObjectMapper map = new ObjectMapper();
        try{
            rd = map.readValue(new URL(combined),Reddit.class);
            System.out.println(rd.toString());
        }catch(IOException e){
            System.out.println("io exceptions");
        }*/
        //ok(rd.toString());//
        return ok(views.html.index.render());   //ok(views.html.index.render(rd.toString()))
    }
}
