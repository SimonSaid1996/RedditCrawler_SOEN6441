package controllers;

import models.RedditExtractor;
import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the all functions in the HomeController
 * @author Ziran Cao
 * @version v1
 */
class HomeControllerTest {
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
        Result r = new HomeController().homeScreen();
        assertTrue(r.toString().length()>0);
    }
    /**
     * testing searching with a keyword
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void search() {        //maybe need to test with get? ask for details
        //need to set some data first, then use the homecontroller
        CompletionStage<Result> result = new HomeController().search("trump--guid250100646453736950463869537365");
        Result r = result.toCompletableFuture().join();
        assertTrue(r.toString().length()>0);
    }

    /**
     * testing the wrapper function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void renderHelper() {   //just for testing
        User X = new User();
        Result r = new HomeController().renderHelper(X);
        assertTrue(r.toString().length()>0);
    }

    /**
     * testing the searching function with some key words
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void distWord() {
        CompletionStage<Result> result = new HomeController().DistWord("trump--guid250100646453736950463869537365");
        Result r = result.toCompletableFuture().join();
        assertTrue(r.toString().length()>0);
    }

    @Test
    void partA() {
    }

    @Test
    void partC_subredditSearch() {
    }

    @Test
    void testHomeScreen() {//??? do we really have this part?
    }
}