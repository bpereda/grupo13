import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayListImpl;

public class Style {
    private String name;
    private MyArrayList<Double> aromaScores = new MyArrayListImpl<>();

    public Style(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyArrayList<Double> getAromaScores() {
        return aromaScores;
    }

    public void setAromaScores(MyArrayList<Double> aromaScores) {
        this.aromaScores = aromaScores;
    }
}
