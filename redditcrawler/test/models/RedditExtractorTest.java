package models;

import com.google.inject.Injector;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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
import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the all functions in the RedditExtractor
 * @author Ziran Cao
 * @version v1
 */
class RedditExtractorTest {
    private Injector injector;
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
     * test how to get latest 10 reddit search results asynchronously
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getLatestSubmissions() {
        User us = new User();
        RedditExtractor re = new RedditExtractor(us);

        RedditExtractorWrapper editor = injector.getInstance(RedditExtractorWrapper.class);  //new RedditExtractorMock();//
        String res = editor.MockGetLatestTenSubmission();
        assertEquals("<a href='/profile/Tron_1981'>Tron_1981</a>",res);
    }
    /**
     * test how to get api results
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getApiResults() {
        User us = new User();
        RedditExtractor re = new RedditExtractor(us);

        RedditExtractorWrapper editor = injector.getInstance(RedditExtractorWrapper.class);  //new RedditExtractorMock();//
        String res = editor.MockGetAPIResult();
        assertEquals(res,"<a href='/profile/Tron_1981'>Tron_1981</a>");
    }
    /**
     * test how to parse
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void parse() {
        RedditExtractor re = new RedditExtractor();
        String test = "{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"author\": \"AdrianChencdt\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/u_AdrianChencdt/comments/r6agvt/is_an_electric_toothbrush_necessary/\",\n" +
                "            \"subreddit\": \"u_AdrianChencdt\",\n" +
                "            \"title\": \"Is an electric toothbrush necessary?\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"author\": \"Peezy2ez\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/unpopularopinion/comments/r6agov/doing_smart_things_doesnt_make_you_smart/\",\n" +
                "            \"subreddit\": \"unpopularopinion\",\n" +
                "            \"title\": \"Doing \\u201csmart\\u201d things doesn\\u2019t make you smart\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        assertNotNull(re.parse(test));
    }
    /**
     * test to getDistW function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getDistW() {

        User us = new User();
        RedditExtractor re = new RedditExtractor(us);
        RedditExtractorWrapper editor = injector.getInstance(RedditExtractorWrapper.class);  //new RedditExtractorMock();//
        String res = editor.mockGetDistW();
        assertEquals("trump",res);
    }
    /**
     * test getsubredditsubmission function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void partC_getSubredditSubmissions() {
        User us = new User();
        RedditExtractor re = new RedditExtractor(us);
        RedditExtractorWrapper editor = injector.getInstance(RedditExtractorWrapper.class);  //new RedditExtractorMock();//
        String res = editor.mockPartC();
        assertEquals("<a href='/profile/Tron_1981'>Tron_1981</a>",res);
    }

    /**
     * test how to get empty results asynchronously, should returnning something that is not null, by default
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getEmptyResults() {
        RedditExtractor ex = new RedditExtractor();
        assertNotNull(ex.getEmptyResults());
    }
}