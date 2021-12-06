package actor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import models.Profile;
import models.SingleSubmission;
import org.junit.jupiter.api.Test;

import java.util.List;
class ProfileActorTest {

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
        ProfileActor.ProfileQuery p = new ProfileActor.ProfileQuery("p");
        String pro = "p";
        assertEquals(pro,p.profilename);
    }

    /**
     * test if all the methods in the class works
     * @version2
     * @author Ziran Cao
     */
    @Test
    void testResult() {   //sending messages to the actors and check the answers
        TestKit probe = new TestKit(actorSystem);
        ActorRef myActor = actorSystem.actorOf(ProfileActor.props());
        myActor.tell(new ProfileActor.ProfileQuery("test"), probe.getRef());
        Profile myp = probe.expectMsgClass(Profile.class);
        // check String name in profile detail, check all three vairables in profile

        assertEquals("test",myp.getAuthorInfoList().getName());
        assertEquals(SingleSubmission.class,myp.getLastTenResult().getResults().get(0).getClass());
    }
}