package actor;

import akka.actor.SupervisorStrategy;
import models.User;
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

class UserManagerTest {
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
     * test if all the methods in the class works
     * @version2
     * @author Ziran Cao
     */
    @Test
    void testResult() {   //sending messages to the actors and check the answers
        TestKit probe = new TestKit(actorSystem);
        ActorRef myActor = actorSystem.actorOf(UserManager.props());
        ActorRef dummy = actorSystem.actorOf(ProfileActor.props());
        ActorRef dummer = actorSystem.actorOf(ProfileActor.props());
        ActorRef worker = actorSystem.actorOf(WorkerActor.props(dummy));
        ActorRef user=actorSystem.actorOf(UserActor.props(myActor));

        //might be able to test on the userref and workerref calls, but need to work on it
        myActor.tell(new WorkerActor.NewWebSocket("test"), probe.getRef());

        worker.tell(new WorkerActor.NewWebSocket("0"),myActor);
        ActorRef user1 = probe.expectMsgClass(WorkerActor.UserActorRef.class).UserActorRef;
        worker.tell(new WorkerActor.NewSearch("error"),user1);
        ActorRef worker1 = actorSystem.actorOf(WorkerActor.props(dummer));
        worker1.tell(new WorkerActor.NewWebSocket("0"),myActor);
        worker1.tell(new WorkerActor.NewWebSocket("1"),myActor);


        assertTrue(true);
        //Profile myp = probe.expectMsgClass(Profile.class);
    }

}