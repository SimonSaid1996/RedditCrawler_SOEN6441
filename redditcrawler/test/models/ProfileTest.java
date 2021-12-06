package models;

import Interface.ProfileInter;
import Interface.RedditExtraInter;
import org.junit.jupiter.api.Test;
import InjectingWrapper.RedditExtractorWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import Interface.DistWordDescInter;

import static org.junit.jupiter.api.Assertions.*;
/**
 * test the profile class
 * @author Ziran Cao
 * @version v1
 */
class ProfileTest {            //need at least two version of hardcoded data
    private Injector injector;
    @BeforeEach
    public void setUp() throws Exception{  //Guice.createInjector(new TextEditorModule());
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(DistWordDescInter.class).to(DistWordDesc.class);
                bind(ProfileInter.class).to(Profile.class);
                bind(RedditExtraInter.class).to(RedditExtractor.class);
            }
        });
    }

    /**
     * clear up the using environment for all methods
     * @author Ziran Cao
     * @version v2
     */
    @AfterEach
    public void tearDown() throws Exception {
        injector = null;
    }

    /**
     * test getData function
     * @author Ziran Cao
     * @version v2
     */
    @Test
    void getData() {   //the only sneaky part
        Profile p = new Profile("test");
        ProfileDetail pf = new ProfileDetail( "name", true, 2, 2, 2, 2, 2,  "id",  "description");
        p.setAuthorInfoList(pf);
        assertNotNull(p.getData());
    }
    /**
     * test getAuthorinfolist function
     * @author Ziran Cao
     * @version v2
     */
    @Test
    void getAuthorInfoList() {
        Profile p = new Profile("test");
        ProfileDetail pf = new ProfileDetail( "name", true, 2, 2, 2, 2, 2,  "id",  "description");
        p.setAuthorInfoList(pf);
        ProfileDetail result = p.getAuthorInfoList();
        assertEquals(result.name,pf.name);
    }
    /**
     * test getlastTenresult function
     * @author Ziran Cao
     * @version v2
     */
    @Test
    void getLastTenResult() {
        RedditExtractorWrapper editor = injector.getInstance(RedditExtractorWrapper.class);
        String name  = editor.MockTenResult();
        assertEquals("<a href='/profile/Tron_1981'>Tron_1981</a>",name);
    }


    /**
     * test getlastTenresult function
     * @author Ziran Cao and Pooya Zargaran
     * @version v2
     */
    @Test
    void partA_getProfileSumbissions() {
        RedditExtractorWrapper editor = injector.getInstance(RedditExtractorWrapper.class);
        String name  = editor.MockProfileSubmission();
        assertEquals("<a href='/profile/Tron_1981'>Tron_1981</a>",name);
    }
    /**
     * test getlastTenresult function
     * @author Ziran Cao and Pooya Zargaran
     * @version v2
     */
    @Test
    void getProfileInfo() {           //need DI
        RedditExtractorWrapper editor = injector.getInstance(RedditExtractorWrapper.class);
        String name  = editor.MockProfileInfo();
        assertEquals("ThanksAlbertHoffman",name);

    }

    /**to test get profileName and setRespHardCode functions
     * @author Ziran Cao
     * @version v2
     */
    @Test
    void getProfileName() {
        Profile pr = new Profile();
        pr.setRespHardCode("trump");
        pr.SetProfileName("trump");
        assertEquals(pr.getProfileName(),"trump");
    }

}