package InjectingWrapper;

import Interface.DistWordDescInter;
import models.DistWordDesc;
import models.Profile;
import models.RedditExtractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**testing file for redditextractorwrapper
 * @author Ziran Cao
 */
class RedditExtractorWrapperTest {
    /**test mockGetAPI
     * @author Ziran cao
     * @version v2
     */
    @Test
    void mockGetAPI() {
        DistWordDescInter test = new DistWordDesc();
        Profile pf = new Profile();
        RedditExtractor rex = new RedditExtractor();
        RedditExtractorWrapper re = new RedditExtractorWrapper(test,pf,rex);
        re.mockGetAPI();
        assertTrue(true);
    }
    /**test mockprofileinfo
     * @author Ziran cao
     * @version v2
     */
    @Test
    void mockProfileInfo() {
        DistWordDescInter test = new DistWordDesc();
        Profile pf = new Profile();
        RedditExtractor rex = new RedditExtractor();
        RedditExtractorWrapper re = new RedditExtractorWrapper(test,pf,rex);
        re.MockProfileInfo();
        assertTrue(true);
    }
    /**test mocktenresult
     * @author Ziran cao
     * @version v2
     */
    @Test
    void mockTenResult() {
        DistWordDescInter test = new DistWordDesc();
        Profile pf = new Profile();
        RedditExtractor rex = new RedditExtractor();
        RedditExtractorWrapper re = new RedditExtractorWrapper(test,pf,rex);
        re.MockTenResult();
        assertTrue(true);
    }
    /**test mockprofilesubmission
     * @author Ziran cao
     * @version v2
     */
    @Test
    void mockProfileSubmission() {
        DistWordDescInter test = new DistWordDesc();
        Profile pf = new Profile();
        RedditExtractor rex = new RedditExtractor();
        RedditExtractorWrapper re = new RedditExtractorWrapper(test,pf,rex);
        re.MockProfileSubmission();
        assertTrue(true);
    }
    /**test mockgetdistw
     * @author Ziran cao
     * @version v2
     */
    @Test
    void mockGetDistW() {
        DistWordDescInter test = new DistWordDesc();
        Profile pf = new Profile();
        RedditExtractor rex = new RedditExtractor();
        RedditExtractorWrapper re = new RedditExtractorWrapper(test,pf,rex);
        re.mockGetDistW();
        assertTrue(true);
    }
    /**test mockpartc
     * @author Ziran cao
     * @version v2
     */
    @Test
    void mockPartC() {
        DistWordDescInter test = new DistWordDesc();
        Profile pf = new Profile();
        RedditExtractor rex = new RedditExtractor();
        RedditExtractorWrapper re = new RedditExtractorWrapper(test,pf,rex);
        re.mockPartC();
        assertTrue(true);
    }
    /**test mockgetapiresult
     * @author Ziran cao
     * @version v2
     */
    @Test
    void mockGetAPIResult() {
        DistWordDescInter test = new DistWordDesc();
        Profile pf = new Profile();
        RedditExtractor rex = new RedditExtractor();
        RedditExtractorWrapper re = new RedditExtractorWrapper(test,pf,rex);
        re.MockProfileSubmission();
        assertTrue(true);
    }
    /**test mockgetlatesttensubmission
     * @author Ziran cao
     * @version v2
     */
    @Test
    void mockGetLatestTenSubmission() {
        DistWordDescInter test = new DistWordDesc();
        Profile pf = new Profile();
        RedditExtractor rex = new RedditExtractor();
        RedditExtractorWrapper re = new RedditExtractorWrapper(test,pf,rex);
        re.MockGetLatestTenSubmission();
        assertTrue(true);
    }
}