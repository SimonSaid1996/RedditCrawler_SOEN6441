package actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import models.RedditExtractor;

/**
 * Actor for Subreddit submissions
 * @author Yugansh Goyal
 */
public class SubredditActor extends AbstractActor {

    public static Props props() {
        return Props.create(SubredditActor.class);
    }

    /**
     * Message for getting submissions for Subreddit
     * @author Yugansh Goyal
     */
    public static class SubredditSubmissionsQuery{
        public final String subreddit;
        
        public SubredditSubmissionsQuery(String p) {
            this.subreddit = p;
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(SubredditSubmissionsQuery.class, request->{
                    sender().tell(new RedditExtractor().PartC_getSubredditSubmissions(
                    		request.subreddit).join(), self());
                }).build();
    }



}