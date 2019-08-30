package search.back.model;

import javax.persistence.*;

@Entity
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public long getId() {
        return id;
    }

    public Search setId(long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Search setContent(String content) {
        this.content = content;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Search setUser(User user) {
        this.user = user;
        return this;
    }
}
