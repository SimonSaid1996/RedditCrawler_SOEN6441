package actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import models.Profile;

/**
 * This is actor for fetching data fro profile page
 * @author Pouya zargaran
 * @version 2.0
 */
public class ProfileActor extends AbstractActor {


    public static Props props() {
        return Props.create(ProfileActor.class);
    }

    /**
     * This is the message class for getting data for certain profilename
     * @author Pouya zargaran
     * @version 2.0
     *
     */
    public static class ProfileQuery{
        public final String profilename;
        public ProfileQuery(String p) {
            this.profilename = p;
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ProfileQuery.class, profileQuery->{
                    sender().tell(new Profile(profileQuery.profilename).getData().join(), self());
                }).build();
    }



}