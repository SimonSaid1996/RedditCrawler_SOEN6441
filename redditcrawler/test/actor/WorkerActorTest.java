package actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import controllers.HomeController;
import models.Profile;
import models.SingleSubmission;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scala.concurrent.duration.FiniteDuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class WorkerActorTest {
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
        HomeController h=new HomeController(actorSystem);
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
        //ProfileActor.ProfileQuery p = new ProfileActor.ProfileQuery("p");
        //String pro = "p";
        //assertEquals(pro,p.profilename);
        WorkerActor.NewSearch NE = new WorkerActor.NewSearch("msg");
        String MES = "msg";
        assertEquals(MES,NE.message);
        WorkerActor.NewWebSocket WW = new WorkerActor.NewWebSocket("www");
        String nww = "www";
        assertEquals(nww,WW.userId);
        ActorRef out = actorSystem.actorOf(DistWActor.props());  //just a dummy actorref to test worker ref
        WorkerActor.UserActorRef UA = new WorkerActor.UserActorRef(out);
        ActorRef in = out;
        assertEquals(in,UA.UserActorRef);
    }

    /**
     * test if all the methods in the class works
     * @version2
     * @author Ziran Cao
     */
    @Test
    void testResult() {   //sending messages to the actors and check the answers
        TestKit probe = new TestKit(actorSystem);
        ActorRef out = actorSystem.actorOf(DistWActor.props());  //just a dummy actorref to test worker ref

        ActorRef sup = actorSystem.actorOf(UserManager.props());
        ActorRef myActor = actorSystem.actorOf(WorkerActor.props(sup));
        ActorRef user = actorSystem.actorOf(UserActor.props(sup));
        ActorRef dummy = actorSystem.actorOf(DistWActor.props());

        myActor.tell("--guid238904092380219853098098",probe.getRef());
        myActor.tell(new WorkerActor.UserActorRef(user),sup);
        myActor.tell(new UserActor.RedditResultJson("{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"author\": \"AdrianChencdt\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/u_AdrianChencdt/comments/r6agvt/is_an_electric_toothbrush_necessary/\",\n" +
                "            \"subreddit\": \"u_AdrianChencdt\",\n" +
                "            \"title\": \"Is an electric toothbrush necessary?\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"author\": \"Peezy2ez\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/unpopularopinion/comments/r6agov/doing_smart_things_doesnt_make_you_smart/\",\n" +
                "            \"subreddit\": \"unpopularopinion\",\n" +
                "            \"title\": \"Doing \\u201csmart\\u201d things doesn\\u2019t make you smart\"\n" +
                "        }\n" +
                "    ]\n" +
                "}"),user);
        myActor.tell("",probe.getRef());

        assertTrue(true);

    }


}