package Interface;

import models.RedditSearchResult;

import java.util.List;

public interface UserInter {
    List<RedditSearchResult> getCache();
    void setCache(List<RedditSearchResult> cache);
    void removeOlderResult(String key);
    void appendCache(RedditSearchResult w );
    void keepLatestTenResults();
}
