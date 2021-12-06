package actor;
import akka.actor.AbstractActor;
import akka.actor.Props;
import models.DistWordDesc;

public class DistWActor extends AbstractActor{
    public static Props props() {
        return Props.create(DistWActor.class);
    }

    /**
     * this is the class to store search key for distword actor
     * @author Ziran Cao
     * @version 2.0
     * */

    public static class SearchWordKey{
        public final String key;
        public SearchWordKey(String k){
           this.key = k;
        }
    }
    @Override
    public Receive createReceive() {

        return receiveBuilder()
                .match(DistWActor.SearchWordKey.class,searchWordKey ->{    //.join(), might need to join at below
                   sender().tell(new DistWordDesc().desDistWdCount(searchWordKey.key,250),self());
                }).build();
    }
}
