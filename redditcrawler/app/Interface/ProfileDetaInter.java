package Interface;

public interface ProfileDetaInter {
    String getName();
    String getId();
    void setName(String name);
    void setId(String id);
    boolean getVerified();
    void setVerified(boolean verified);
    int getTotal_karma();
    void setTotal_karma(int total_karma);
    boolean isVerified();
    int getComment_karma();
    void setComment_karma(int comment_karma);
    int getPost_karma();
    void setPost_karma(int post_karma);
    int getAwarder_karma();
    void setAwarder_karma(int awarder_karma);
    int getAwardedee_karma();
    void setAwardedee_karma(int awardedee_karma);
    String getDescription();
    void setDescription(String description);
}
