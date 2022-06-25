import uy.edu.um.prog2.adt.tads.MyHash.MyHash;
import uy.edu.um.prog2.adt.tads.MyHash.MyHashImpl;

import java.util.Date;

public class Brewery {

    private long id;
    private String name;
    private MyHash<Long,Beer> beers = new MyHashImpl<>();
    private int reviewsPerYear = 0;

    public Brewery(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBeer(Beer beer){
        beers.put(beer.getId(), beer);
    }

    public MyHash<Long, Beer> getBeers() {
        return beers;
    }

    public void setBeers(MyHash<Long, Beer> beers) {
        this.beers = beers;
    }

    public int getReviewsPerYear() {
        return reviewsPerYear;
    }

    public void setReviewsPerYear() {
        this.reviewsPerYear++;
    }
}
