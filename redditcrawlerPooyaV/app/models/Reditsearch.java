package models;

import java.util.List;

public class Reditsearch {
    private String searchKey;
    private List<SingleReddit> results;


    public String getSearchKey() {
        return searchKey;
    }

    public List<SingleReddit> getResults() {
        return results;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public void setResults(List<SingleReddit> results) {
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
