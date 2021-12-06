package models;

import InjectingWrapper.RedditExtractorWrapper;
import Interface.ProfileInter;
import Interface.RedditExtraInter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import Interface.DistWordDescInter;

import java.util.ArrayList;
import java.util.List;
/**
 * q class to get an list of distinctword descending and their corresponding number count
 * @author Ziran Cao
 * @version v1
 */
public class DistWordDescTest {

    private Injector injector;
    //can't use injector because of the versionning problem
    /**
     * set up the using environment for all methods
     * @author Ziran Cao
     * @version v2
     */
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
     * use a wrapper class to call and mock the api
     * @author Ziran Cao
     * @version v2
     */
    @Test
    void desDistWdCount() {
        RedditExtractorWrapper editor = injector.getInstance(RedditExtractorWrapper.class);  //new RedditExtractorMock();//
        List<List<String>>result = editor.mockGetAPI();
        assertEquals("trump",result.get(2).get(0));
    }

}