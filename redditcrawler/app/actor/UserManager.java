package actor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import scala.concurrent.duration.Duration;
import models.RedditSearchResult;
import akka.japi.pf.DeciderBuilder;
import static akka.actor.SupervisorStrategy.*;

import javax.inject.Singleton;


import java.util.Hashtable;
import java.util.List;

public class UserManager extends AbstractActor {

    public Hashtable<String, ActorRef> allUsers = new Hashtable<>();
    public Hashtable<String, ActorRef> allworkers = new Hashtable<>();

    public static Props props() {
        System.out.println("Created the Supervisor");
        System.out.println("ssssssssssssssssssssssssssssssssssssssssssssss");
        return Props.create(UserManager.class);
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(WorkerActor.NewWebSocket.class,wa->{
                    System.out.println("NewWebSocket from worker");
                    onWorkerRequest(wa,sender());
                })
                .build();
    }

    private void onWorkerRequest(WorkerActor.NewWebSocket newSocket,ActorRef workerRef) {
        System.out.println("got the new web socket in super");
        if(!allUsers.containsKey(newSocket.userId)){
            //System.out.println("found out that is new websocket");
            ActorRef ref = getContext().actorOf(Props.create(UserActor.class,self()), "UserActor"+newSocket.userId);
            //System.out.println("created new user actor:"+ ref);
            allUsers.put(newSocket.userId, ref);
            allworkers.put(newSocket.userId, workerRef);
        }
        else if( allworkers.get(newSocket.userId) != workerRef ){
            allworkers.put(newSocket.userId, workerRef);
        }

        ActorRef userRef = allUsers.get(newSocket.userId);
        userRef.tell(new UserActor.WorkerActorRef(workerRef),self());
        workerRef.tell(new WorkerActor.UserActorRef(userRef),self());
    }

    public static final OneForOneStrategy STRATEGY = new OneForOneStrategy(
            10,
            Duration.create("1 seconds"),
            DeciderBuilder
                    .match(UserActor.RedditProblem.class, ex ->{
                        System.out.println("++++++++++++++++++++++++++++++++++++");
                        System.out.println("Reddit Api is not Working Problem");
                        System.out.println("++++++++++++++++++++++++++++++++++++");
                        return(Directive) resume();
                    } )
                    .build()
    );

    //keep this one here for now
    @Override
    public SupervisorStrategy supervisorStrategy() {
        return STRATEGY;
    }


}

