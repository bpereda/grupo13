import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.MyHash.MyHash;
import uy.edu.um.prog2.adt.tads.MyHash.NodeHashTable;
import uy.edu.um.prog2.adt.tads.MyHeap.HeapNode;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeap;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeapImpl;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Consultas {

    public Consultas() {
    }

    private MyHash<Long,Brewery> breweries = DataLoad.getBreweries();
    private MyHash<Long,Beer> beers = DataLoad.getBeers();
    private MyHash<Long,Review> reviews = DataLoad.getReviews();

    public void Consulta1(String year){
        long tiempo_final;
        long tiempo_inicial = System.currentTimeMillis();
        MyHeap<Integer,Brewery> topTen = new MyHeapImpl<>(true);
        NodeHashTable<Long, Beer>[] beersElements = beers.getElements();
        NodeHashTable<Long,Brewery>[] breweriesElements = breweries.getElements();
        for (NodeHashTable<Long, Beer> beersElement : beersElements) {
            if (beersElement != null) {
                for (int j = 0; j < beersElement.getValue().getReviews().size(); j++) {
                    String yearStr = beers.get(beersElement.getKey()).getReviews().get(j).getYear();
                    if (yearStr.equals(year)) {
                        Long breweryId = beersElement.getValue().getId();
                        if(breweries.get(breweryId) != null){
                            breweries.get(breweryId).setReviewsPerYear();
                        }

                    }
                }

            }
        }
        for (int i = 0; i < breweries.size(); i++) {
            if(breweriesElements[i] != null){
                if (breweries.get(breweriesElements[i].getKey()) != null){
                    topTen.insert(breweries.get(breweriesElements[i].getKey()).getReviewsPerYear(),breweriesElements[i].getValue());
                }

            }

        }
        for (int i = 0; i < 10; i++) {
            HeapNode<Integer,Brewery> temp = topTen.delete();
            System.out.println("Id: "+temp.getValue().getId()+" Nombre: "+temp.getValue().getName()+" Reviews en el año"+year+": "+temp.getValue().getReviewsPerYear());
        }
        tiempo_final = System.currentTimeMillis();
        System.out.println("Tiempo Consulta1: " + (tiempo_final - tiempo_inicial));
    }

    public void Consulta2(){
        long tiempo_final;
        long tiempo_inicial = System.currentTimeMillis();
        MyHeapImpl<String, User> UserTop15 = new MyHeapImpl<>(true);
        NodeHashTable[] review_vector = reviews.getElements();
        User[] user_array = new User[review_vector.length];
        int j = 0;
        for(int i = 0; i < review_vector.length; i++) {
            if(review_vector[i] != null) {
                Review review_temp = (Review) review_vector[i].getValue();
                User user_temp = review_temp.getUser();
                for(int x=0;x<user_array.length;x++)
                {
                    if(user_array[x]!=null)
                    {
                        if (user_temp.getUsername().equals(user_array[x].getUsername()))
                        {
                            user_temp = user_array[x];
                        }
                    }
                }
                if(user_temp.getCantidad_de_resenias()==0)
                {
                    user_array[j] = user_temp;
                    j++;
                }
                int incremento = user_temp.getCantidad_de_resenias() + 1;
                user_temp.setCantidad_de_resenias(incremento);
            }

        }
        for (int num = 0; num < user_array.length; num++) {
            if(user_array[num]!=null)
            {
                UserTop15.insert(user_array[num].getUsername(), user_array[num]);
            }
        }
        for(int z=0;z<15;z++)
        {
            HeapNode<String, User> temporal = UserTop15.delete();
            System.out.println("Nombre: " + temporal.getValue().getUsername() + "Cantidad de Resenias: " + temporal.getValue().getCantidad_de_resenias());
        }
        tiempo_final = System.currentTimeMillis();
        System.out.println("Tiempo Consulta1: " + (tiempo_final - tiempo_inicial));

    }

    public void Consulta3(Date inicio, Date fin){
        long tiempo_final;
        long tiempo_inicial = System.currentTimeMillis();
        int count = 0;
        NodeHashTable<Long,Review>[] reviewsElements = reviews.getElements();
        for (NodeHashTable<Long, Review> reviewsElement : reviewsElements) {
            if (reviewsElement != null) {
                if ((reviews.get(reviewsElement.getKey()).getDate().compareTo(inicio) > 0) && (reviews.get(reviewsElement.getKey()).getDate().compareTo(fin) < 0)){
                    count++;
                }
            }
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        String fecha_inicio = dateFormat.format(inicio);
        String fecha_fin = dateFormat.format(fin);
        System.out.println("Fecha de inicio: "+fecha_inicio+" Fecha de fin: "+fecha_fin+" Reviews entre estas fechas: "+count);

        tiempo_final = System.currentTimeMillis();
        System.out.println("Tiempo Consulta3: " + (tiempo_final - tiempo_inicial));
    }

    public void Consulta5(){
        long tiempo_final;
        long tiempo_inicial = System.currentTimeMillis();
        NodeHashTable<Long, Beer>[] beersElements = beers.getElements();
        MyHeap<Integer,Beer> topFive = new MyHeapImpl<>(true);

        for (NodeHashTable<Long, Beer> beersElement : beersElements) {
            if (beersElement != null) {
                topFive.insert(beers.get(beersElement.getKey()).getNumberReviews(), beersElement.getValue());
            }
        }

        for (int i = 0; i < 5; i++) {
            HeapNode<Integer,Beer> temp = topFive.delete();
            System.out.println("Nombre: "+temp.getValue().getName()+" Cantidad de reviews: "+temp.getKey()+" Puntaje General: "+temp.getValue().avgGeneralScore());
        }
        tiempo_final = System.currentTimeMillis();
        System.out.println("Tiempo Consulta5: " + (tiempo_final - tiempo_inicial));
    }

    public static void main(String[] args) {
        Consultas prueba = new Consultas();
    }
}

