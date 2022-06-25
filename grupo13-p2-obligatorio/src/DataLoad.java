import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayListImpl;
import uy.edu.um.prog2.adt.tads.MyHash.MyHashtable;
import uy.edu.um.prog2.adt.tads.MyHash.MyHashImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Math.abs;


public class DataLoad{
    static MyHashtable<Long, Beer> beers = new MyHashImpl<>();
    static MyHashtable<Long, Brewery> breweries = new MyHashImpl<>();
    static MyHashtable<String,User> users = new MyHashImpl<>();
    static MyHashtable<Long, Review> reviews = new MyHashImpl<>();
    static MyHashtable<String,Style> styles = new MyHashImpl<>();

    public DataLoad() {
    }

    public static MyHashtable<String, User> getUsers() {
        return users;
    }

    public static MyHashtable<Long, Beer> getBeers() {
        return beers;
    }

    public static MyHashtable<Long, Brewery> getBreweries() {
        return breweries;
    }

    public static MyHashtable<Long, Review> getReviews() {
        return reviews;
    }

    public static MyHashtable<String, Style> getStyles() {
        return styles;
    }

    public static void Carga() {
        long countCerveza = 0;

        try {
            long tiempo_final;
            FileReader fileReader = new FileReader("grupo13-p2-obligatorio/src/beer_dataset_full.csv");
            BufferedReader br = new BufferedReader(fileReader);
            String[] vectorStrings;
            String line;
            long tiempo_inicial = System.currentTimeMillis();
            /*int cantidadbeerhash = 0;
            int cantidadbreweriehash = 0;
            int cantidadreviewhash = 0;
            int cantidaduserhash = 0;*/
            //Chequeos chequeo = new Chequeos();
            br.readLine();
            while ((line = br.readLine()) != null) {
                vectorStrings = line.split(",");
                if (vectorStrings.length > 14) {
                    vectorStrings = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                }

                boolean check = true;
                for (int i = 0; i < vectorStrings.length ; i++) {
                    if (vectorStrings[i].length() == 0){
                        check = false;
                        break;
                    }
                }

                if (check) {
                    Long brewery_id = Long.parseLong(vectorStrings[1]);
                    String brewery_name = vectorStrings[2];

                    long review_id = Long.parseLong(vectorStrings[0]);
                    Timestamp ts = new Timestamp(Long.parseLong(vectorStrings[3]));
                    Date review_date = new Date(Long.valueOf(vectorStrings[3]) *1000);
                    double review_overall = Double.parseDouble(vectorStrings[4]);
                    double review_aroma = Double.parseDouble(vectorStrings[5]);
                    double review_appearance = Double.parseDouble(vectorStrings[6]);
                    String review_profilename = vectorStrings[7];

                    String beer_style = vectorStrings[8];
                    //double review_palate = Double.parseDouble(vectorStrings[9]);
                    double review_taste = Double.parseDouble(vectorStrings[10]);
                    String beer_name = vectorStrings[11];
                    double beer_abv = Double.parseDouble(vectorStrings[12]);
                    Long beer_id = Long.parseLong(vectorStrings[13]);

                    Beer newBeer = new Beer(beer_name, beer_id, beer_abv);
                    User newUser = new User(review_profilename);
                    if (users.get(review_profilename) == null){
                        users.put(review_profilename,newUser);
                    }else{
                        newUser = users.get(review_profilename);
                    }
                    Style newStyle = null;

                    if(styles.get(beer_style)==null){
                        newStyle = new Style(beer_style);
                        styles.put(beer_style,newStyle);

                    }else{
                        newStyle = styles.get(beer_style);
                    }

                    newBeer.setStyle(newStyle);
                    Brewery newBrewery = new Brewery(brewery_id, brewery_name);
                    Review newReview = new Review(review_id, review_date, review_overall, review_aroma, review_appearance, review_taste, newUser, brewery_id);
                    reviews.put(review_id,newReview);
                    //cantidadbreweriehash++;
                    newBeer.addReview(newReview);

                    if (breweries.get(brewery_id) == null) {
                        newBrewery.addBeer(beer_id);
                        breweries.put(brewery_id, newBrewery);
                        beers.put(beer_id, newBeer);
                        countCerveza++;
                        //cantidadbreweriehash++;
                        //cantidadbeerhash++;
                    } else {
                        newBrewery = breweries.get(brewery_id);
                        if (beers.get(beer_id) == null) {
                            newBrewery.addBeer(beer_id);
                            beers.put(beer_id,newBeer);
                        } else {
                            newBeer = beers.get(beer_id);
                            newBeer.addReview(newReview);

                        }
                    }
                }
            }



            tiempo_final = System.currentTimeMillis();
            System.out.println("Tiempo de carga: " + (tiempo_final - tiempo_inicial));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}