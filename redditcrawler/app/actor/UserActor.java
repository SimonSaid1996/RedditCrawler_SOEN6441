package actor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.RedditExtractor;
import models.RedditSearchResult;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class UserActor extends AbstractActor {

    public static Props props(ActorRef supervisor) {
        return Props.create(UserActor.class, supervisor);
    }

    private static int acno = 0;
    private ActorRef workerRef;
    private final ActorRef supervisorRef;
    private List<RedditSearchResult> cache;
    private List<String> searchKeys;


    public UserActor(ActorRef supervisor) {
        System.out.println("Created the UserActor" + acno++);
        System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        this.cache = new ArrayList<>();
        this.searchKeys = new ArrayList<>();
        this.supervisorRef = supervisor;
//        syncronizer();
    }

    public static class RedditProblem extends RuntimeException {

        public RedditProblem() {
            super("Reddit request timed out");
        }
    }

    public static class WorkerActorRef {

        public final ActorRef ActorRef;

        public WorkerActorRef(ActorRef user) {
            this.ActorRef = user;
        }
    }


    public static class RedditResultJson {
        public final String result;

        public RedditResultJson(String result) {
            this.result = result;
        }
    }


    @Override
    public Receive createReceive() {

        return receiveBuilder()
                .match(WorkerActorRef.class, workerActorRef -> {
                    workerRef = workerActorRef.ActorRef;
                    updateData(); })
                .match(WorkerActor.NewSearch.class, newSearch -> {
                    System.out.println("in useractor");
                    String message = newSearch.message;
                    System.out.println("Useractor received message: <" + message + ">");

                    try {
                        if (message.equals("")) {
                            System.out.println("tamam");
                            updateData();
                        }else if(message.equals("error")){
                            System.out.println("its error");
                            throw new RedditProblem();
                        }else {
                            removeOlderResult(message);
                            keepLatestTenResults();
                            append(message);

                            RedditExtractor redditExtractor = new RedditExtractor();
                            redditExtractor.setSearchKey(message);
                            System.out.println("$$$$$$$$$$trump\n message is "+message);
                            RedditSearchResult r = redditExtractor.getApiResults("https://api.pushshift.io/reddit/search/submission/?q=" + message + "&size=10");

                            cache.add(0, r);

                            ObjectMapper mapper = new ObjectMapper();
                            String json = mapper.writeValueAsString(cache);
                            workerRef.tell(new RedditResultJson(json), self());
                        }

                    }
                    catch (Exception e) {
                        throw new RedditProblem();
                    }
    })
                .build();
    }
    // might be used later, comment out
    /*public void syncronizer() {
        Runnable searchOperation = new Runnable() {

            @Override
            public void run() {
                updateData();
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(searchOperation, 0, 30, TimeUnit.SECONDS);
    }*/

    public void updateData() {
        try {
            if (!searchKeys.isEmpty()) {
                List<RedditSearchResult> cache = new ArrayList<>();
                for (int i = 0; i < searchKeys.size(); i++) {
                    RedditExtractor redditExtractor = new RedditExtractor();
                    redditExtractor.setSearchKey(searchKeys.get(i));
                    RedditSearchResult r = redditExtractor.getApiResults("https://api.pushshift.io/reddit/search/submission/?q=" + searchKeys.get(i) + "&size=10");
                    cache.add(r);
                }
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(cache);
                System.out.println("Update is coming");
                workerRef.tell(new RedditResultJson(json), self());
            }
        } catch (Exception e) {
            System.out.println("e");
        }
    }

    public void removeOlderResult(String key) {
        for (int i = 0; i < this.searchKeys.size(); i++) {
            if (searchKeys.get(i).equals(key)) {
                searchKeys.remove(i);
                cache.remove(i);
                return;
            }
        }
    }


    public void append(String w) {
        System.out.println("Added " + w + "to the searchKeys");
        searchKeys.add(0, w);
        System.out.println("searchKeys " + searchKeys);
    }

    public void keepLatestTenResults() {
        System.out.println(this.searchKeys.size());
        if (this.searchKeys.size() == 10) {
            this.searchKeys.remove(9);
            cache.remove(9);
        }
    }
}
