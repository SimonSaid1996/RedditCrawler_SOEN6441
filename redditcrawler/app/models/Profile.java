package models;

import org.json.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Profile {

    private ProfileDetail authorInfoList;
    private RedditSearchResult lastTenResult;
    private String profileName;

    public Profile(String profileName){
        this.profileName=profileName;

    }

    public CompletableFuture<Profile> getData(){
        CompletableFuture<Void> getinginfo=CompletableFuture.runAsync(()->this.getProfileInfo());
        CompletableFuture<Void> getingsub=CompletableFuture.runAsync(()->this.PartA_getProfileSumbissions());

        return CompletableFuture.allOf(getinginfo,getingsub).thenApply(r->this);
    }

    public ProfileDetail getAuthorInfoList() {
        return authorInfoList;
    }

    public RedditSearchResult getLastTenResult() {
        return lastTenResult;
    }


    /**
     *
     * @author
     */
    private void PartA_getProfileSumbissions (){
        try{
            profileName = URLEncoder.encode(profileName,"UTF-8");
        } catch(Exception e){
            System.out.println(e);
        }
        String api = "https://api.pushshift.io/reddit/search/submission/?author="+profileName+"&fields=title,subreddit,author,full_link&size=10";

        RedditExtractor lastTenResultExtractor=new RedditExtractor();
        lastTenResult = lastTenResultExtractor.getApiResults(api);

    }

    private void getProfileInfo(){
        try{
            profileName = URLEncoder.encode(profileName,"UTF-8");
        } catch(Exception e){
            System.out.println(e);
        }
        String sampleurl = "https://www.reddit.com/user/"+profileName+"/about.json";

        //adding new results, added wrong way
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(sampleurl)).build();
        String responseBody = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)    //trying to add user to the parse
                .join();

        System.out.println("***************************");
        System.out.println(responseBody);
        System.out.println("***************************");

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

//        return authorInfoList;

    }

}
