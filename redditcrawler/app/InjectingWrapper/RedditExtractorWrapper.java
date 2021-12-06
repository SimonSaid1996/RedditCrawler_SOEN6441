package InjectingWrapper;

import Interface.DistWordDescInter;
import models.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class RedditExtractorWrapper {
    private DistWordDescInter test;
    public RedditSearchResult re;
    private Profile pf;
    private RedditExtractor rex;

    @Inject
    public RedditExtractorWrapper(DistWordDescInter test,Profile pf,RedditExtractor rex)
    {    //inject and initialize
        this.test = test;
        this.pf = pf;
        this.rex = rex;
    }

    public List<List<String>> mockGetAPI(){
        //String st = "https://api.pushshift.io/reddit/search/submission/?q=trump&size=2";
        //System.out.println("test is "+test);
        re = new RedditSearchResult();
        SingleSubmission ss = new SingleSubmission();
        ss.setSubreddit("<a href='/subreddit/GundamBattle'>GundamBattle</a>");
        ss.setAuthor("<a href='/profile/Tron_1981'>Tron_1981</a>");
        ss.setTitle("A Psycho Frame? That's one hell of a trump card Ryusei added to his build");
        ss.setSubmissionLink("https://www.reddit.com/r/GundamBattle/comments/r6ah5k/a_psycho_frame_thats_one_hell_of_a_trump_card/");
        List<SingleSubmission> ssL = new ArrayList<>();
        ssL.add(ss);
        re.setResults(ssL);
        test.setHardCodedResult(re);
        List<List<String>> result = test.desDistWdCount("trump",1);  //doesn't actually go into api
        return result;
    }

    public String MockProfileInfo(){
        String respB = "{\"kind\": \"t2\", \"data\": {\"is_employee\": false, \"is_friend\": false, \"subreddit\": {\"default_set\": true, \"user_is_contributor\": null, \"banner_img\": \"\", \"restrict_posting\": true, \"user_is_banned\": null, \"free_form_reports\": true, \"community_icon\": null, \"show_media\": true, \"icon_color\": \"#FF99AA\", \"user_is_muted\": null, \"display_name\": \"u_ThanksAlbertHoffman\", \"header_img\": null, \"title\": \"\", \"previous_names\": [], \"over_18\": false, \"icon_size\": [256, 256], \"primary_color\": \"\", \"icon_img\": \"https://www.redditstatic.com/avatars/defaults/v2/avatar_default_0.png\", \"description\": \"\", \"submit_link_label\": \"\", \"header_size\": null, \"restrict_commenting\": false, \"subscribers\": 0, \"submit_text_label\": \"\", \"is_default_icon\": true, \"link_flair_position\": \"\", \"display_name_prefixed\": \"u/ThanksAlbertHoffman\", \"key_color\": \"\", \"name\": \"t5_26ox1j\", \"is_default_banner\": true, \"url\": \"/user/ThanksAlbertHoffman/\", \"quarantine\": false, \"banner_size\": null, \"user_is_moderator\": null, \"accept_followers\": true, \"public_description\": \"\", \"link_flair_enabled\": false, \"disable_contributor_requests\": false, \"subreddit_type\": \"user\", \"user_is_subscriber\": null}, \"snoovatar_size\": null, \"awardee_karma\": 0, \"id\": \"4t5u3c1c\", \"verified\": true, \"is_gold\": false, \"is_mod\": false, \"awarder_karma\": 0, \"has_verified_email\": true, \"icon_img\": \"https://www.redditstatic.com/avatars/defaults/v2/avatar_default_0.png\", \"hide_from_robots\": false, \"link_karma\": 24, \"is_blocked\": false, \"total_karma\": 43, \"pref_show_snoovatar\": false, \"name\": \"ThanksAlbertHoffman\", \"created\": 1571230646.0, \"created_utc\": 1571230646.0, \"snoovatar_img\": \"\", \"comment_karma\": 19, \"accept_followers\": true, \"has_subscribed\": true}}";
        pf.setRespHardCode(respB);
        pf.SetProfileName("trump");
        String name  = pf.getProfileInfo();
        System.out.println("name is "+name);  //name is ThanksAlbertHoffman
        return name;
    }

    public String MockTenResult(){
        pf.SetProfileName("trump");
        re = new RedditSearchResult();
        SingleSubmission ss = new SingleSubmission();
        ss.setSubreddit("<a href='/subreddit/GundamBattle'>GundamBattle</a>");
        ss.setAuthor("<a href='/profile/Tron_1981'>Tron_1981</a>");
        ss.setTitle("A Psycho Frame? That's one hell of a trump card Ryusei added to his build");
        ss.setSubmissionLink("https://www.reddit.com/r/GundamBattle/comments/r6ah5k/a_psycho_frame_thats_one_hell_of_a_trump_card/");
        List<SingleSubmission> ssL = new ArrayList<>();
        ssL.add(ss);
        re.setResults(ssL);
        pf.setBuildInLastTenResult(re);
        return pf.getLastTenResult().getResults().get(0).getAuthor();
    }

    public String MockProfileSubmission(){
        pf.SetProfileName("trump");
        re = new RedditSearchResult();
        SingleSubmission ss = new SingleSubmission();
        ss.setSubreddit("<a href='/subreddit/GundamBattle'>GundamBattle</a>");
        ss.setAuthor("<a href='/profile/Tron_1981'>Tron_1981</a>");
        ss.setTitle("A Psycho Frame? That's one hell of a trump card Ryusei added to his build");
        ss.setSubmissionLink("https://www.reddit.com/r/GundamBattle/comments/r6ah5k/a_psycho_frame_thats_one_hell_of_a_trump_card/");
        List<SingleSubmission> ssL = new ArrayList<>();
        ssL.add(ss);
        re.setResults(ssL);
        pf.setBuildInLastTenResult(re);
        RedditSearchResult res = pf.PartA_getProfileSumbissions();
        return res.getResults().get(0).getAuthor();
    }

    public String mockGetDistW(){
        re = new RedditSearchResult();
        SingleSubmission ss = new SingleSubmission();
        ss.setSubreddit("<a href='/subreddit/GundamBattle'>GundamBattle</a>");
        ss.setAuthor("<a href='/profile/Tron_1981'>Tron_1981</a>");
        ss.setTitle("A Psycho Frame? That's one hell of a trump card Ryusei added to his build");
        ss.setSubmissionLink("https://www.reddit.com/r/GundamBattle/comments/r6ah5k/a_psycho_frame_thats_one_hell_of_a_trump_card/");
        List<SingleSubmission> ssL = new ArrayList<>();
        ssL.add(ss);
        re.setResults(ssL);
        rex.setHardCodeSubm(re);
        rex.getDistW("trump",10);
        return "trump";
    }

    public String mockPartC(){
        re = new RedditSearchResult();
        SingleSubmission ss = new SingleSubmission();
        ss.setSubreddit("<a href='/subreddit/GundamBattle'>GundamBattle</a>");
        ss.setAuthor("<a href='/profile/Tron_1981'>Tron_1981</a>");
        ss.setTitle("A Psycho Frame? That's one hell of a trump card Ryusei added to his build");
        ss.setSubmissionLink("https://www.reddit.com/r/GundamBattle/comments/r6ah5k/a_psycho_frame_thats_one_hell_of_a_trump_card/");
        List<SingleSubmission> ssL = new ArrayList<>();
        ssL.add(ss);
        re.setResults(ssL);
        rex.setHardCodeSubm(re);
        RedditSearchResult result = rex.PartC_getSubredditSubmissions("trump").join();
        return result.getResults().get(0).getAuthor();
    }

    public String MockGetAPIResult(){
        re = new RedditSearchResult();
        SingleSubmission ss = new SingleSubmission();
        ss.setSubreddit("<a href='/subreddit/GundamBattle'>GundamBattle</a>");
        ss.setAuthor("<a href='/profile/Tron_1981'>Tron_1981</a>");
        ss.setTitle("A Psycho Frame? That's one hell of a trump card Ryusei added to his build");
        ss.setSubmissionLink("https://www.reddit.com/r/GundamBattle/comments/r6ah5k/a_psycho_frame_thats_one_hell_of_a_trump_card/");
        List<SingleSubmission> ssL = new ArrayList<>();
        ssL.add(ss);
        re.setResults(ssL);
        rex.setHardCodeSubm(re);
        RedditSearchResult result = rex.getApiResults("trump");
        System.out.println("search result author is "+result.getResults().get(0).getAuthor());
        return result.getResults().get(0).getAuthor();
    }

    public String MockGetLatestTenSubmission(){
        re = new RedditSearchResult();
        SingleSubmission ss = new SingleSubmission();
        ss.setSubreddit("<a href='/subreddit/GundamBattle'>GundamBattle</a>");
        ss.setAuthor("<a href='/profile/Tron_1981'>Tron_1981</a>");
        ss.setTitle("A Psycho Frame? That's one hell of a trump card Ryusei added to his build");
        ss.setSubmissionLink("https://www.reddit.com/r/GundamBattle/comments/r6ah5k/a_psycho_frame_thats_one_hell_of_a_trump_card/");
        List<SingleSubmission> ssL = new ArrayList<>();
        ssL.add(ss);
        re.setResults(ssL);
        rex.setHardCodeSubm(re);
        rex.setSearchKey("trump");
        User us = new User();
        rex.curUser = us;

        rex.getLatestSubmissions("trump");
        List<RedditSearchResult> test =rex.curUser.getCache();
        //System.out.println("author is "+test.get(0).getResults().get(0).getAuthor());
        return test.get(0).getResults().get(0).getAuthor();
    }
}
