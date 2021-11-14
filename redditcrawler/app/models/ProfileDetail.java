package models;

public class ProfileDetail {
    String name ;
    boolean verified ;
    int total_karma;
    int comment_karma;
    int post_karma;
    int awarder_karma;
    int awardedee_karma;
    String id ;
    String description;

    public ProfileDetail(String name, boolean verified, int total_karma, int comment_karma, int post_karma, int awarder_karma, int awardedee_karma, String id, String description) {
        this.name = name;
        this.verified = verified;
        this.total_karma = total_karma;
        this.comment_karma = comment_karma;
        this.post_karma = post_karma;
        this.awarder_karma = awarder_karma;
        this.awardedee_karma = awardedee_karma;
        this.id = id;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getTotal_karma() {
        return total_karma;
    }

    public void setTotal_karma(int total_karma) {
        this.total_karma = total_karma;
    }

    public boolean isVerified() {
        return verified;
    }

    public int getComment_karma() {
        return comment_karma;
    }

    public void setComment_karma(int comment_karma) {
        this.comment_karma = comment_karma;
    }

    public int getPost_karma() {
        return post_karma;
    }

    public void setPost_karma(int post_karma) {
        this.post_karma = post_karma;
    }

    public int getAwarder_karma() {
        return awarder_karma;
    }

    public void setAwarder_karma(int awarder_karma) {
        this.awarder_karma = awarder_karma;
    }

    public int getAwardedee_karma() {
        return awardedee_karma;
    }

    public void setAwardedee_karma(int awardedee_karma) {
        this.awardedee_karma = awardedee_karma;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
