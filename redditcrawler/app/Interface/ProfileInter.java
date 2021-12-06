package Interface;

import models.Profile;
import models.ProfileDetail;
import models.RedditSearchResult;

import java.util.concurrent.CompletableFuture;

public interface ProfileInter {
    CompletableFuture<Profile> getData();

    ProfileDetail getAuthorInfoList();
    RedditSearchResult getLastTenResult();
    String getProfileInfo();
    public String getProfileName();
    void setRespHardCode(String RHC);
    void SetProfileName(String pn);
    RedditSearchResult PartA_getProfileSumbissions ();
    void setBuildInLastTenResult(RedditSearchResult rs);
    void setAuthorInfoList(ProfileDetail ali);
}
