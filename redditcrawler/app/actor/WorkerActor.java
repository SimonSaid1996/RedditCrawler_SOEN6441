package actor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import controllers.HomeController;

/**
 * This is actor for fetching data fro profile page
 * @author Pouya zargaran
 * @version 2.0
 */
public class WorkerActor extends AbstractActor {


    private final ActorRef websocket;
    private final ActorRef SupervisorActor;
    private ActorRef userActor;
    private  String userid;
    private boolean first=true;

    public static Props props(ActorRef out) {
        System.out.println("Created the worker");
        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        return Props.create(WorkerActor.class,out);
    }

    public WorkerActor(ActorRef websocket){
        this.websocket = websocket;
        SupervisorActor=HomeController.getS();
        userActor=ActorRef.noSender();
    }
    /**
     * This is the message class for getting data for certain profilename
     * @author Pouya zargaran
     * @version 2.0
     *
     */
    public static class NewWebSocket{
        public final String userId;
        public NewWebSocket(String userId) {
            this.userId = userId;
        }
    }

    public static class UserActorRef{
        public final ActorRef UserActorRef;
        public UserActorRef(ActorRef user) {
            this.UserActorRef = user;
        }
    }

    public static class NewSearch{
        public final String message;
        public NewSearch(String m) {
            this.message = m;
        }
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(UserActorRef.class,u->{
                    System.out.println("worker got msg from supervisor: the userref ="+u.UserActorRef);
                    userActor=u.UserActorRef;
                })
                .match(String.class, message -> {
                    if (first){
                        System.out.println("its my first time in worker");
                        String[] split = message.split("--guid");
                        this.userid =split[1];
                        System.out.println("from user: <"+ this.userid +">");
                        SupervisorActor.tell(new NewWebSocket(this.userid),self());
                        System.out.println("told supervisor to creat new user ac");
                        first=false;
                    }else{
                        System.out.println("sent searching mg to useractor: "+userActor);
                        this.userActor.tell(new NewSearch(message),self());

                    }})
                .match(UserActor.RedditResultJson.class,redditResultJson ->{
                    System.out.println("worker got msg from userActor");
                    this.websocket.tell(redditResultJson.result,self());
                } )
                .build();


    }



}