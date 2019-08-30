package search.back.domain;

import search.back.model.Search;
import search.back.model.User;

public class SearchDomain {

    private transient Search search;
    private User user;
    private String conternt;

    public SearchDomain() {}

    public SearchDomain(Search search) {
        this.search = search;
        this.user = search.getUser();
        this.conternt = search.getContent();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getConternt() {
        return conternt;
    }

    public void setConternt(String conternt) {
        this.conternt = conternt;
    }
}
