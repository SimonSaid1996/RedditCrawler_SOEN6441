package models;

import Interface.ProfileInter;
import org.json.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;


/**
 * The class representing an Author and would handel the fetching datas about it and storing them
 * @author Pouya Zargaran
 */
public class Profile implements ProfileInter {
    public String responseBodyHardCoded;
    public RedditSearchResult buildInLastTenResult;
    private ProfileDetail authorInfoList;
    public RedditSearchResult lastTenResult;
    private String profileName;

    /**
     * Constructor
     * @author Pouya Zargaran
     * @param profileName Author's name*/

    public Profile(String profileName){
        this.profileName=profileName;
    }

    /**
     * dummy Constructor
     * @author Ziran Cao
     */
    public Profile(){

    }


    /**
     * It would get the Information and Last ten submition related to Author Asynchronously
     * and pass the this object containing the datas
     * @return CompletableFuture<Profile> that contains all the datas needed about an author
     * @author Pouya Zargaran
     */
    public CompletableFuture<Profile> getData(){
            CompletableFuture<Void> getinginfo=CompletableFuture.runAsync(()->this.getProfileInfo());
            CompletableFuture<Void> getingsub=CompletableFuture.runAsync(()->this.PartA_getProfileSumbissions());
            return CompletableFuture.allOf(getinginfo,getingsub).thenApply(r->this);
    }

    /**
     * It would get the Information and Last ten submition related to Author Asynchronously
     * and pass the this object containing the datas
     * @return informatin of the
     * @author Pouya Zargaran
     */
    public ProfileDetail getAuthorInfoList() {
        return authorInfoList;
    }

    /**method to help set authorinfolist, for testing purpose
     * @author ziran cao
     * @param ali
     * @version v2
     */
    public void setAuthorInfoList(ProfileDetail ali){
        authorInfoList =  ali;
    }
    /**
     * getter method for the attribute LastTenresult
     * @author Pouya Zargaran
     * @return @class{RedditSearchResult}
     */
    public RedditSearchResult getLastTenResult() {
        if(buildInLastTenResult != null){return buildInLastTenResult;} else{return lastTenResult;}
    }

    /**
     * It would get the Last 10 submissions from Author Using @class RedditExtractor 's getApiResults using "Pushshift" Api,
     * and save it in lastTenResult in the format of @class RedditSearchResult
     * @author Pouya Zargaran
     */
    public RedditSearchResult PartA_getProfileSumbissions (){
        try{
            profileName = URLEncoder.encode(profileName,"UTF-8");} catch(Exception e){System.out.println(e);}
        String api = "https://api.pushshift.io/reddit/search/submission/?author="+profileName+"&fields=title,subreddit,author,full_link&size=10";

        //check the last ten result here, if not null, switch to testing mode
        RedditExtractor lastTenResultExtractor=new RedditExtractor();
        if(buildInLastTenResult ==null){
            lastTenResult = lastTenResultExtractor.getApiResults(api);}
        else{
            lastTenResult = buildInLastTenResult;

        }
        return lastTenResult;

    }
    /**
     * It would get the Information about the Author Using Seperate Api "official RedditApi",
     * pars the data get the param that we need
     * and save it in authorInfoList in the format of @class ProfileDetail
     * @author Pouya Zargaran
     */
    public String getProfileInfo(){
        try{
            profileName = URLEncoder.encode(profileName,"UTF-8");} catch(Exception e){System.out.println(e);}
        System.out.println("here is the profilename "+profileName);
        String sampleurl = "https://www.reddit.com/user/"+profileName+"/about.json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(sampleurl)).build();
        String responseBody;
        if(responseBodyHardCoded ==null){
            responseBody = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).join();
        }
        else{
            responseBody = responseBodyHardCoded;
            System.out.println("hard coded, yah");
        }
        System.out.println("responseBody is "+responseBody);
        JSONObject submission = new JSONObject(responseBody).getJSONObject("data");
        String name = submission.getString("name");
        boolean verified = submission.getBoolean("verified");
        int total_karma = submission.getInt("total_karma");
        int awarder_karma = submission.getInt("awarder_karma");
        int awardee_karma = submission.getInt("awardee_karma");
        int post_karma = submission.getInt("link_karma");
        String desctiption = submission.getJSONObject("subreddit").getString("public_description");
        int comment_karma = submission.getInt("comment_karma");
        String id = submission.getString("id");
        System.out.println(name+","+verified+","+total_karma+","+id);
        authorInfoList= new ProfileDetail(name,verified,total_karma,comment_karma,post_karma,awarder_karma,awardee_karma,id,desctiption);
        return name;
    }
    /**getter for the profilename
     * @author Ziran cao
     * @return profilename
     * @Verion v2
     */
    @Override
    public String getProfileName() {
        return profileName;
    }
    /**setter for the profilename
     * @author Ziran cao
     * @Verion v2
     */
    @Override
    public void SetProfileName(String pn) {
        profileName = pn;
    }
    /**setter for the hardcoded response body
     * @author Zirancao
     * @Verion v2
     */
    @Override
    public void setRespHardCode(String RHC) {

        responseBodyHardCoded = RHC;
    }

    /**setter for the hardcoded lastTenResult
     * @author Zirancao
     * @Verion v2
     */
    @Override
    public void setBuildInLastTenResult(RedditSearchResult rs){
        buildInLastTenResult = rs;
        System.out.println("setting buildin result");
    }
}
