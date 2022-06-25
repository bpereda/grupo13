public class User {
    private String username;
    private int cantReviews = 0;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCantReviews() {
        return cantReviews;
    }

    public void setCantReviews(int cantReviews) {
        this.cantReviews = cantReviews;
    }
}
