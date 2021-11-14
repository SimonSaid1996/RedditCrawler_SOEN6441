package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * test the profile class
 * @author Ziran Cao
 * @version v1
 */
class ProfileTest {            //ask pooya to write better tests if he can
    /**
     * test getData function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getData() {
        Profile p = new Profile("test");
        //ProfileDetail pf = new ProfileDetail( "name", true, 2, 2, 2, 2, 2,  "id",  "description");
        //RedditSearchResult red = new RedditSearchResult();
        assertNotNull(p.getData());
        }
    /**
     * test getAuthorinfolist function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getAuthorInfoList() {
        Profile p = new Profile("test");
        assertNull(p.getAuthorInfoList());

    }
    /**
     * test getlastTenresult function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getLastTenResult() {
        Profile p = new Profile("test");
        assertNull(p.getLastTenResult());
    }
}