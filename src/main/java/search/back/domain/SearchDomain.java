package search.back.domain;

public class SearchDomain {

    private String email;
    private String content;

    public SearchDomain() {
    }

    public SearchDomain(String email, String search) {
        this.email = email;
        this.content = search;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
