package search.back.domain;

public class SearchDomain {

    private long id;
    private String email;
    private String content;

    public SearchDomain() {
    }

    public SearchDomain(long id, String email, String search) {
        this.id = id;
        this.email = email;
        this.content = search;
    }


    public String getEmail() {
        return email;
    }

    public SearchDomain setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getContent() {
        return content;
    }

    public SearchDomain setContent(String content) {
        this.content = content;
        return this;
    }

    public long getId() {
        return id;
    }

    public SearchDomain setId(long id) {
        this.id = id;
        return this;
    }
}
