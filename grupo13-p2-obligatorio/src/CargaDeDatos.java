import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import uy.edu.um.prog2.adt.tads.MyHash.MyHashImpl;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class CargaDeDatos {
    static MyHashImpl<Integer, Beer> BeerHash = new MyHashImpl();
    static MyHashImpl<Long, Brewery> BreweryHash = new MyHashImpl<Long, Brewery>();
    static MyHashImpl<Long, Review> ReviewHash = new MyHashImpl<Long, Review>();
    MyHashImpl<Long, Style> StyleHash = new MyHashImpl<Long, Style>();

    public static void Carga() throws IOException, CsvValidationException {

        try {

            FileReader fileReader = new FileReader("C:\\Users\\agust\\Downloads\\2022_obligatorio_dataset\\beer_dataset_test.csv");
            CSVReader csvReader = new CSVReader(fileReader);
            //BufferedReader br = new BufferedReader(fileReader);
            csvReader.readNext();
            String[] vectorStrings;
            //String[] linea;
            long tiempo_inicial = System.currentTimeMillis();
            long tiempo_final;
            Chequeos chequeo = new Chequeos();

            while ((vectorStrings = csvReader.readNext()) != null) {

                //System.out.println(vectorStrings[12]);
                //vectorStrings = csvReader.readNext();
                //String[] vectorStrings = linea.split(",");

                if (chequeo.chequeoDatos(vectorStrings)) {
                    String id_review_str = vectorStrings[0];
                    Long id_review = Long.parseLong(id_review_str);
                    String brewery_id_str = vectorStrings[1];
                    Long brewery_id = Long.parseLong(brewery_id_str);
                    String brewery_name = vectorStrings[2];
                    String review_time_str = vectorStrings[3];
                    Date review_date = new Date(review_time_str);
                    String review_overall_str = vectorStrings[4];
                    Double review_overall = Double.parseDouble(review_overall_str);
                    String review_aroma_str = vectorStrings[5];
                    Double review_aroma = Double.parseDouble(review_aroma_str);
                    String review_appearance_str = vectorStrings[6];
                    Double review_appearance = Double.parseDouble(review_appearance_str);
                    String review_profilename = vectorStrings[7];
                    String beer_style = vectorStrings[8];
                    String review_palate_str = vectorStrings[9];
                    Double review_palate = Double.parseDouble(review_palate_str);
                    String review_taste_str = vectorStrings[10];
                    Double review_taste = Double.parseDouble(review_taste_str);
                    String beer_name = vectorStrings[11];
                    String beer_abv_str = vectorStrings[12];
                    Double beer_abv = Double.parseDouble(beer_abv_str);
                    String beer_id_str = vectorStrings[13];
                    Long beer_id = Long.parseLong(beer_id_str);
                    User user = new User(review_profilename);
                    Style style = new Style(beer_style);

                    Brewery brewery = new Brewery(Math.toIntExact(brewery_id), brewery_name);
                    BreweryHash.put(brewery_id, brewery);

                    Review review = new Review(id_review, review_date, review_overall, review_aroma, review_appearance, review_taste, user, brewery);
                    Beer beer = new Beer(beer_name, beer_id, beer_abv);
                    if (BeerHash.get(Math.toIntExact(beer_id))==null){
                        BeerHash.put(Math.toIntExact(beer_id), beer);
                    }else{
                        BeerHash.get(Math.toIntExact(beer_id)).getReviews().put(id_review, review);
                    }

                    if(BreweryHash.get(brewery_id).getBeers().get(beer_id)==null)
                    {
                            BreweryHash.get(brewery_id).getBeers().put(beer_id, beer);
                    }

                    tiempo_final = System.currentTimeMillis();
                    //System.out.println("Tiempo "+ (tiempo_final-tiempo_inicial));

                }
            }
                        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}