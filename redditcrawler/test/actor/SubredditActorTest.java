package actor;
import models.RedditSearchResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import models.SingleSubmission;
import org.junit.jupiter.api.Test;

class SubredditActorTest {
    public static ActorSystem actorSystem;
    public static ActorRef profileAct;
    /**
     * set up the running environment for testing all functions inside the class
     * @version2
     * @author Ziran Cao
     */
    @BeforeEach
    void setUp() {
        actorSystem = ActorSystem.create();
        profileAct = actorSystem.actorOf(ProfileActor.props());
    }
    /**
     * clean up the running environment aftor testing
     * @version2
     * @author Ziran Cao
     */
    @AfterEach
    void tearDown() {
        actorSystem = null;
        profileAct = null;
    }

    /**
     * test if the search key is the same
     * @version2
     * @author Ziran Cao
     */
    @Test
    void testSearchK() {
        SubredditActor.SubredditSubmissionsQuery p = new SubredditActor.SubredditSubmissionsQuery("p");
        String pro = "p";
        assertEquals(pro,p.subreddit);
    }

    /**
     * test if all the methods in the class works
     * @version2
     * @author Ziran Cao
     */
    @Test
    void testResult() {   //sending messages to the actors and check the answers
        TestKit probe = new TestKit(actorSystem);
        ActorRef myActor = actorSystem.actorOf(SubredditActor.props());

        myActor.tell(new SubredditActor.SubredditSubmissionsQuery("test"), probe.getRef());

        RedditSearchResult myS = probe.expectMsgClass(RedditSearchResult.class);

        assertEquals(SingleSubmission.class,myS.getResults().get(0).getClass());

    }

}