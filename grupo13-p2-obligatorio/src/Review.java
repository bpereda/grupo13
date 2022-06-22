import java.util.Date;

public class Review {
    private Style style;
    private long id;
    private Date date;
    private double overallscore;
    private double aromaScore;
    private double appearanceScore;
    private double flavourScore;

    public Review(long id, Date date, double overallscore, double aromaScore, double appearanceScore, double flavourScore,Style style) {
        this.id = id;
        this.date = date;
        this.overallscore = overallscore;
        this.aromaScore = aromaScore;
        this.appearanceScore = appearanceScore;
        this.flavourScore = flavourScore;
    }


}
