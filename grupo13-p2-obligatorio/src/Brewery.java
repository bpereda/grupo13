import uy.edu.um.prog2.adt.tads.MyHash.MyHashImpl;

public class Brewery {

    private long id;
    private String name;
    private MyHashImpl<Long, Beer> Beers = new MyHashImpl<>();

    public void setId(long id) {
        this.id = id;
    }

    public MyHashImpl<Long, Beer> getBeers() {
        return Beers;
    }

    public void setBeers(MyHashImpl<Long, Beer> beers) {
        Beers = beers;
    }

    public Brewery(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
