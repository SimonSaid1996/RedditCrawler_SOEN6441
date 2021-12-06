package controllers;

import akka.actor.ActorSystem;
import models.RedditExtractor;
import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import play.mvc.Result;
import play.mvc.WebSocket;

import java.util.concurrent.CompletionStage;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the all functions in the HomeController
 * @author Ziran Cao
 * @version v1
 */
class HomeControllerTest {
    @com.google.inject.Inject private ActorSystem actorSystem;

    /**
     * make initialization before creating the class
     * @author Ziran Cao
     * @version v1
     */
    @BeforeEach
    void setUp() {
        RedditExtractor.isTesting = true;
    }
    /**
     * shut down the system after testing
     * @author Ziran Cao
     * @version v1
     */
    @AfterEach
    void tearDown() {
        RedditExtractor.isTesting = false;
    }

    /**
     * testing creating the homepage buttom
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void homeScreen() {
        actorSystem = ActorSystem.create();
        Result r = new HomeController(actorSystem).homeScreen();
        assertTrue(r.toString().length()>0);
    }

    /**
     * testing the searching function with some key words
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void distWord() {
        actorSystem = ActorSystem.create();
        CompletionStage<Result> result = new HomeController(actorSystem).DistWord("trump");
        Result r = result.toCompletableFuture().join();
        assertTrue(r.toString().length()>0);
    }
    /**
     * testing the partA function with some key words
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void partA() {
        actorSystem = ActorSystem.create();
        CompletionStage<Result> result = new HomeController(actorSystem).PartA("TweetArchiveBot");
        Result r = result.toCompletableFuture().join();
        assertTrue(r.toString().length()>0);
    }
    /**
     * testing the partc function with some key words
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void partC_subredditSearch() {   //for testing
        actorSystem = ActorSystem.create();
        CompletionStage<Result> result = new HomeController(actorSystem).PartC_subredditSearch("rosin");
        Result r = result.toCompletableFuture().join();
        assertTrue(r.toString().length()>0);
    }

    @Test
    void websocket (){
        actorSystem = ActorSystem.create();
        new HomeController(actorSystem).socket();
        assertTrue(true);
    }
}