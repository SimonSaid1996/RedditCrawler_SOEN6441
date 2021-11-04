package model;

public class Reddit {
    private String author;
    private String body;

    public String getAuthor(){
        return author;
    }

    public String getBody(){
        return body;
    }

    public String toString(){    //printing out values
        return this.author+"\n"+this.body;
    }
}
