import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayListImpl;

public class Brewery {

    private long id;
    private String name;
    private MyArrayList<Long> beers = new MyArrayListImpl<>();
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

    public void addBeer(Long beerId){
        beers.insert(beerId);
    }

    public MyArrayList<Long> getBeers() {
        return beers;
    }

    public void setBeers(MyArrayList<Long> beers) {
        this.beers = beers;
    }

    public int getReviewsPerYear() {
        return reviewsPerYear;
    }

    public void setReviewsPerYear(int reviewsPerYear) {
        this.reviewsPerYear = reviewsPerYear;
    }
}
