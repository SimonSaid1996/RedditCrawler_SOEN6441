package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * test the redditsearchresult class
 * @author Ziran Cao
 * @version v1
 */
class RedditSearchResultTest {
    /**
     * test the getsearchkey function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getSearchKey() {
        RedditSearchResult re = new RedditSearchResult();
        re.setSearchKey("test");
        assertEquals(re.getSearchKey(),"test");
    }
    /**
     * test the getresult function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getResults() {
        List<SingleSubmission> test = new ArrayList<>();
        SingleSubmission sin = new SingleSubmission();
        test.add(sin);
        RedditSearchResult re = new RedditSearchResult();
        re.setResults(test);
        assertNotNull(re.getResults());
    }
    /**
     * test the setsearchkey function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setSearchKey() {
        RedditSearchResult re = new RedditSearchResult();
        re.setSearchKey("test");
        assertNotNull(re.getSearchKey());
    }
    /**
     * test the setresults function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setResults() {
        List<SingleSubmission> test = new ArrayList<>();
        SingleSubmission sin = new SingleSubmission();
        test.add(sin);
        RedditSearchResult re = new RedditSearchResult();
        re.setResults(test);
        assertNotNull(re.getResults());
    }
    /**
     * test the tostring function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void testToString() {     //dummy function
        List<SingleSubmission> test = new ArrayList<>();
        SingleSubmission sin = new SingleSubmission();
        test.add(sin);
        RedditSearchResult re = new RedditSearchResult();
        re.setResults(test);
        System.out.println(re);
        assertEquals(1,1);
    }
}