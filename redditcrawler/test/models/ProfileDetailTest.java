package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * test the profiledetail class
 * @author Ziran Cao
 * @version v1
 */
class ProfileDetailTest {
    /**
     * test the getname method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getName() {
        ProfileDetail pf = new ProfileDetail( "name", true, 2, 2, 2, 2, 2,  "id",  "description");
        assertNotNull(pf.getName());
    }
    /**
     * test the setname method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setName() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        pf.setName("pooya");
        assertEquals(pf.getName(),"pooya");
    }
    /**
     * test the getid method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getId() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        assertTrue(pf.getId().equals("id"));
    }
    /**
     * test the setid method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setId() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        pf.setId("pooya");
        assertTrue(pf.getId().equals("pooya"));
    }
    /**
     * test the getverified method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getVerified() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        assertTrue(pf.getVerified()==true);
    }
    /**
     * test the setverified method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setVerified() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        pf.setVerified(false);
        assertTrue(pf.getVerified()==false);
    }
    /**
     * test the gettotalkarma method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getTotal_karma() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        assertTrue(pf.getTotal_karma()==2);
    }
    /**
     * test the settotalkarma method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setTotal_karma() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        pf.setTotal_karma(3);
        assertTrue(pf.getTotal_karma()==3);
    }

    /**
     * test the isverified method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void isVerified() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        assertTrue(pf.isVerified()==true);
    }
    /**
     * test the getcommentkarma method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getComment_karma() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        assertTrue(pf.getComment_karma()==2);
    }
    /**
     * test the setcommentkarma method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setComment_karma() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        pf.setComment_karma(3);
        assertTrue(pf.getComment_karma()==3);
    }
    /**
     * test the getpostkarma method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getPost_karma() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        assertTrue(pf.getPost_karma()==2);
    }
    /**
     * test the setpostkarma method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setPost_karma() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        pf.setPost_karma(3);
        assertTrue(pf.getPost_karma()==3);
    }
    /**
     * test the getawarderkarma method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getAwarder_karma() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        assertTrue(pf.getAwarder_karma()==2);
    }
    /**
     * test the setawarderkarma method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setAwarder_karma() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        pf.setAwarder_karma(3);
        assertTrue(pf.getAwarder_karma()==3);
    }
    /**
     * test the getawardedee method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getAwardedee_karma() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        assertTrue(pf.getAwardedee_karma()==2);
    }
    /**
     * test the setawardedee method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setAwardedee_karma() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        pf.setAwardedee_karma(3);
        assertTrue(pf.getAwardedee_karma()==3);
    }
    /**
     * test the getdescription method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getDescription() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        assertNotNull(pf.getDescription());
    }
    /**
     * test the setdescription method
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void setDescription() {
        ProfileDetail pf = new ProfileDetail( "test", true, 2, 2, 2, 2, 2,  "id",  "description");
        pf.setDescription("test");
        assertEquals(pf.getDescription(),"test");
    }

}