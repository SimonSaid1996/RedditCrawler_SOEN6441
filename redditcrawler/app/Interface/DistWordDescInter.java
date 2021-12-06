package Interface;

import models.*;

import java.util.List;
import models.RedditSearchResult;
public interface DistWordDescInter {
    List<List<String>> desDistWdCount(String searchKey,int count);
    void setHardCodedResult(RedditSearchResult re);
}
