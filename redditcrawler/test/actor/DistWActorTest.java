package actor;

import models.Profile;
import models.SingleSubmission;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;

import java.util.List;

class DistWActorTest {
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
    @org.junit.jupiter.api.Test
    void testSearchK() {
        DistWActor.SearchWordKey k = new DistWActor.SearchWordKey("k");
        String theKey = k.key;
        assertEquals(theKey,"k");
    }

    /**
     * test if all the methods in the class works
     * @version2
     * @author Ziran Cao
     */
    @org.junit.jupiter.api.Test
    void testResult() {   //sending messages to the actors and check the answers
        TestKit probe = new TestKit(actorSystem);
        ActorRef myActor = actorSystem.actorOf(DistWActor.props());
        myActor.tell(new DistWActor.SearchWordKey("test"), probe.getRef());
        List<List<String>> hi = probe.expectMsgClass(List.class);
        assertEquals(2,hi.get(0).size());
    }
}