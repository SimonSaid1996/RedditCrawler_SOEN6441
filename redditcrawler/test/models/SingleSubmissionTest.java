package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  testing the simglesubmission class
 * @author Ziran Cao
 * @version v1
 */
class SingleSubmissionTest {
    /**
     * test to getauther function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getAuthor() {
        SingleSubmission s = new SingleSubmission("a","b","c");
        assertEquals(s.getAuthor(),"a");
    }
    /**
     * test to setauthor function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setAuthor() {
        SingleSubmission s = new SingleSubmission("a","b","c");
        s.setAuthor("b");
        assertEquals(s.getAuthor(),"b");

    }
    /**
     * test getsubreddit function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getSubreddit() {
        SingleSubmission s = new SingleSubmission("a","bb","c");
        assertEquals(s.getSubreddit(),"bb");
    }
    /**
     * test setsubreddit function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setSubreddit() {
        SingleSubmission s = new SingleSubmission();
        s.setSubreddit("b");
        assertTrue(s.getSubreddit().length()>0);
    }
    /**
     * test gettitle function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getTitle() {
        SingleSubmission s = new SingleSubmission();
        s.setTitle("b");
        assertTrue(s.getTitle().length()>0);

    }
    /**
     * test settitle function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setTitle() {
        SingleSubmission s = new SingleSubmission();
        s.setTitle("b");
        assertTrue(s.getTitle().length()>0);
    }
}