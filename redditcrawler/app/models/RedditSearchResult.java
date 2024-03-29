package models;

import Interface.RedditSearInter;

import java.util.List;

/**
 * a model class representing the search results for the search key
 * @author Pooya Zaragaran
 */
public class RedditSearchResult implements RedditSearInter {
    
	private String searchKey;
    private List<SingleSubmission> results;


    public String getSearchKey() {
        return searchKey;
    }

    public List<SingleSubmission> getResults() {
        return results;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public void setResults(List<SingleSubmission> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        String s="";
        s+=searchKey;
        for(int i=0; i<this.results.size();i++){   //should be 2
            s+="\ni is "+i+"\nlist size is "+this.results.get(i).getAuthor()+"*********\n";//should be 100
        }
        return s;
    }
}
