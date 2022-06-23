import uy.edu.um.prog2.adt.tads.MyHash.MyHashImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@SuppressWarnings("ALL")
public class DataLoad{
    static MyHashImpl<Long, Beer> beers = new MyHashImpl<>();
    static MyHashImpl<Long, Brewery> breweries = new MyHashImpl<>();

    public DataLoad() {
    }

    public static void Carga() {

        try {
            long tiempo_final;
            FileReader fileReader = new FileReader("grupo13-p2-obligatorio/beer_dataset_test.csv");
            BufferedReader br = new BufferedReader(fileReader);
            String[] vectorStrings;
            String line;
            long tiempo_inicial = System.currentTimeMillis();

            //Chequeos chequeo = new Chequeos();
            br.readLine();
            while ((line = br.readLine()) != null) {

                vectorStrings = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                boolean check = false;
                if (vectorStrings[12] != null) {
                    check = true;
                    for (String vectorString : vectorStrings) {
                        if (vectorString == null || vectorString.length() == 0) {
                            check = false;
                            break;
                        }
                    }
                }

                if (check) {
                    Long brewery_id = Long.parseLong(vectorStrings[1]);
                    String brewery_name = vectorStrings[2];

                    long review_id = Long.parseLong(vectorStrings[0]);
                    Timestamp ts = new Timestamp(Long.parseLong(vectorStrings[3]));
                    Date review_date = new Date(ts.getTime());
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
                    Style newStyle = new Style(beer_style);
                    newBeer.setStyle(newStyle);
                    Brewery newBrewery = new Brewery(brewery_id, brewery_name);
                    Review newReview = new Review(review_id, review_date, review_overall, review_aroma, review_appearance, review_taste, newUser, brewery_id);
                    newBeer.addReview(newReview);

                    if (breweries.get(brewery_id) == null) {
                        newBrewery.addBeer(newBeer);
                        breweries.put(brewery_id, newBrewery);
                        beers.put(beer_id, newBeer);
                    } else {
                        newBrewery = breweries.get(brewery_id);
                        if (beers.get(beer_id) == null) {
                            newBrewery.addBeer(newBeer);
                            breweries.remove(brewery_id);
                            breweries.put(brewery_id, newBrewery);
                            beers.put(beer_id, newBeer);

                        } else {
                            newBeer = beers.get(beer_id);
                            newBeer.addReview(newReview);
                            beers.remove(beer_id);
                            beers.put(beer_id, newBeer);
                            //tengo que volver a agregarla a newBrewerie??? (creo que no pero ta)
                        }

                    }


                }

            }


            tiempo_final = System.currentTimeMillis();
            System.out.println("Tiempo " + (tiempo_final - tiempo_inicial));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        DataLoad prueba = new DataLoad();
        Carga();
    }
}