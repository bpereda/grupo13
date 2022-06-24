
import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayListImpl;
import uy.edu.um.prog2.adt.tads.MyHash.MyHash;
import uy.edu.um.prog2.adt.tads.MyHash.MyHashImpl;
import uy.edu.um.prog2.adt.tads.MyQueue.MyQueue;
import uy.edu.um.prog2.adt.tads.MyQueue.MyQueueImpl;

import java.util.ArrayList;

public class Beer {

    private String name;
    private long id;
    private double abv;
    private Style style;
    private double aromaScoreAvg = 0;

    public double AvgAroma(){
        double sum = 0;
        for(int i=0; i<this.getNumberReviews(); i++)
        {
            sum += this.getReviews().get(i).getAromaScore();
        }
        return this.aromaScoreAvg= sum/this.getNumberReviews();
    }

    public double getAromaScoreAvg() {
        return aromaScoreAvg;
    }

    public void setAromaScoreAvg(double aromaScoreAvg) {
        this.aromaScoreAvg = aromaScoreAvg;
    }

    private MyArrayList<Review> reviews = new MyArrayListImpl<>();

    public Beer(String name, long id, double abv) {
        this.name = name;
        this.id = id;
        this.abv = abv;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public void addReview(Review review) {
        reviews.insert(review);
    }

    public MyArrayList<Review> getReviews() {
        return reviews;
    }

    public int getNumberReviews(){
        return reviews.size();
    }
    public double avgGeneralScore(){
        double result = 0;
        for (int i = 0; i < reviews.size(); i++) {
            result += reviews.get(i).getOverallScore();
        }
        return result/getNumberReviews();
    }
}
