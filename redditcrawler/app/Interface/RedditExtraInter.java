package Interface;

import models.RedditExtractor;
import models.RedditSearchResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.google.inject.ImplementedBy;


@ImplementedBy(RedditExtractor.class)
public interface RedditExtraInter {
    void setSearchKey(String searchKey);
    void setHardCodeSubm(RedditSearchResult hcs);
    CompletableFuture<RedditSearchResult> getLatestSubmissions(String searchKey);
    RedditSearchResult getApiResults(String api);
    RedditSearchResult getEmptyResults();
    RedditSearchResult parse(String responseBody);
    CompletableFuture<List<List<String>>> getDistW(String searchKey, int count);
    CompletableFuture<RedditSearchResult> PartC_getSubredditSubmissions(String Subreddit);
}
