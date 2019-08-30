package search.back.domain;

import java.util.List;

public class SearchPageDomain {

    private List<SearchInfoDomain> domainList;
    private int page;
    private int count;
    private long totalElements;
    private int totalPages;


    public SearchPageDomain() {
    }

    public SearchPageDomain(List<SearchInfoDomain> domainList, long totalElements, int totalPages) {
        this.domainList = domainList;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }


    public int getPage() {
        return page;
    }

    public SearchPageDomain setPage(int page) {
        this.page = page;
        return this;
    }

    public int getCount() {
        return count;
    }

    public SearchPageDomain setCount(int count) {
        this.count = count;
        return this;
    }

}
