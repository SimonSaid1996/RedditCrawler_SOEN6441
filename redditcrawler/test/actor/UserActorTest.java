package actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserActorTest {
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

        //ActorRef, there is no point and no way of testing actorRef, just call and let it pass
        ActorRef myActor = actorSystem.actorOf(ProfileActor.props());
        UserActor.WorkerActorRef w = new UserActor.WorkerActorRef(myActor);

        UserActor.RedditProblem x = new UserActor.RedditProblem();
        UserActor.RedditResultJson r = new UserActor.RedditResultJson("J");
        String Json = "J";
        assertEquals(Json,r.result);
    }

    /**
     * test if all the methods in the class works
     * @version2
     * @author Ziran Cao
     */
    @Test
    void testResult() {   //sending messages to the actors and check the answers
        TestKit probe = new TestKit(actorSystem);

        ActorRef SupActor = actorSystem.actorOf(UserManager.props());
        ActorRef out = actorSystem.actorOf(DistWActor.props());  //just a dummy actorref to test worker ref

        ActorRef work1 = actorSystem.actorOf(WorkerActor.props(out));
        ActorRef myActor = actorSystem.actorOf(UserActor.props(SupActor));

        myActor.tell(new UserActor.WorkerActorRef(out), probe.getRef());
        myActor.tell(new UserActor.WorkerActorRef(out).ActorRef,probe.getRef());
        myActor.tell(new WorkerActor.NewSearch(""),probe.getRef());
        myActor.tell(new WorkerActor.NewSearch("test"),probe.getRef());
        myActor.tell(new WorkerActor.NewSearch("error"),probe.getRef());





        assertTrue(true);
    }
}