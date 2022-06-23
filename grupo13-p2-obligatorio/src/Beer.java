import uy.edu.um.prog2.adt.tads.MyHash.MyHashImpl;

public class Beer {

    private String name;
    private long id;
    private double abv;
    private Style style;
    private MyHashImpl<Long,Review> reviews = new MyHashImpl<>();

    public Beer(String name, long id, double abv) {
        this.name = name;
        this.id = id;
        this.abv = abv;
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public MyHashImpl<Long, Review> getReviews() {
        return reviews;
    }

    public void setReviews(MyHashImpl<Long, Review> reviews) {
        this.reviews = reviews;
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
}
