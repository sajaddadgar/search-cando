package search.back.model;

public class Auction {


    private long id;
    private String title;
    private long createDate;
    private long dueDate;
    private int maxUsers;
    private int bookmarkedCount;


    public long getId() {
        return id;
    }

    public Auction setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Auction setTitle(String title) {
        this.title = title;
        return this;
    }

    public long getCreateDate() {
        return createDate;
    }

    public Auction setCreateDate(long createDate) {
        this.createDate = createDate;
        return this;
    }

    public long getDueDate() {
        return dueDate;
    }

    public Auction setDueDate(long dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public Auction setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
        return this;
    }

    public int getBookmarkedCount() {
        return bookmarkedCount;
    }

    public Auction setBookmarkedCount(int bookmarkedCount) {
        this.bookmarkedCount = bookmarkedCount;
        return this;
    }
}
