package Interface;

import models.SingleSubmission;

import java.util.List;

public interface RedditSearInter {
    String getSearchKey();
    List<SingleSubmission> getResults();
    void setSearchKey(String searchKey);
    void setResults(List<SingleSubmission> results);
}
