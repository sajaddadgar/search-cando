package search.back.domain;

import search.back.model.Search;

public class SearchInfoDomain {

    private transient Search search;
    private String content;

    public SearchInfoDomain() {}

    public SearchInfoDomain(Search search) {
        this.search = search;
        this.content = search.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
