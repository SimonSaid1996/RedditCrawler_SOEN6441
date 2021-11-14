package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the all functions in the User class
 * @author Ziran Cao
 * @version v1
 */
class UserTest {
    /**
     * Tests get Cache function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getCache() {
        RedditSearchResult curRed = new RedditSearchResult();
        //might need to set the user and some dummy singlesubmissions
        SingleSubmission s = new SingleSubmission();
        s.setAuthor("test");
        s.setSubreddit("test1");
        s.setTitle("test2");

        SingleSubmission s1 = new SingleSubmission();
        s1.setAuthor("test11");
        s1.setSubreddit("test12");
        s1.setTitle("test13");
        List<SingleSubmission> st = new ArrayList<>();
        st.add(s);
        st.add(s1);
        curRed.setResults(st);

        User us = new User("test");
        us.appendCache(curRed);
        List<RedditSearchResult> tst = us.getCache();
        assertTrue(tst.size()>0);

    }
    /**
     * Tests set Cache function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setCache() {
        User us = new User();
        RedditSearchResult curRed = new RedditSearchResult();
        //might need to set the user and some dummy singlesubmissions
        SingleSubmission s = new SingleSubmission();
        s.setAuthor("test");
        s.setSubreddit("test1");
        s.setTitle("test2");

        SingleSubmission s1 = new SingleSubmission();
        s1.setAuthor("test11");
        s1.setSubreddit("test12");
        s1.setTitle("test13");
        List<SingleSubmission> st = new ArrayList<>();
        List<RedditSearchResult> st1 = new ArrayList<>();
        st.add(s);
        st.add(s1);
        curRed.setResults(st);
        st1.add(curRed);
        us.setCache(st1);
        assertTrue(us.getCache().size()>0);

    }
    /**
     * Tests isThereaSameKey function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void isThereaSameKey() {
    }

    /**
     * Tests remove function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void remove() {
    }

    /*@Test
    void appendCache() {
    }*/

    /**
     * Tests keepLatestTenResults function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void keepLatestTenResults() {
    }
}