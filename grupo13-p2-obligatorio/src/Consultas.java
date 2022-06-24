import uy.edu.um.prog2.adt.tads.MyHash.MyHash;
import uy.edu.um.prog2.adt.tads.MyHash.NodeHashTable;
import uy.edu.um.prog2.adt.tads.MyHeap.HeapNode;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeap;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeapImpl;

import java.text.SimpleDateFormat;
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
        MyHeapImpl<Integer, User> UserTop15 = new MyHeapImpl<>(true);
        MyHash<Long, Review> reviews = DataLoad.getReviews();
        MyHash<Integer, User> users = DataLoad.getUsers();
        NodeHashTable[] usersElements = users.getElements();
        NodeHashTable[] reviewsElements = reviews.getElements();

        for(NodeHashTable<Long, Review> reviewElement : reviewsElements)
        {
            if (reviewElement != null)
            {
                Review reviewTemp = reviewElement.getValue();
                User userTemp = reviewTemp.getUser();
                userTemp.setCountReviews();
            }
        }

        for(NodeHashTable<Integer, User> userElement : usersElements)
        {
            if(userElement!=null)
            {
                UserTop15.insert(userElement.getValue().getcountReviews(), userElement.getValue());
            }
        }

        for(int z=0;z<15;z++)
        {
            HeapNode<Integer, User> temporal = UserTop15.delete();
            System.out.println("Nombre: " + temporal.getValue().getUsername() + ", Cantidad de Resenias: " + temporal.getValue().getcountReviews());
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

    public void Consulta4()
    {
        long tiempo_inicial = System.currentTimeMillis();
        MyHash<Long, Beer> beers = DataLoad.getBeers();
        NodeHashTable[] beersElements = beers.getElements();
        MyHeapImpl<Double, Beer> Top7 = new MyHeapImpl<>(true);
        for(NodeHashTable<Long, Beer> beersElement : beersElements)
        {
            if(beersElement!=null)
            {
                beersElement.getValue().AvgAroma();
                Top7.insert(beersElement.getValue().getAromaScoreAvg(), beersElement.getValue());
            }
        }
        for(int i=0; i<7; i++)
        {
            HeapNode<Double, Beer> temporal = Top7.delete();
            System.out.println("Cerveza: " + temporal.getValue().getName() + ", Promedio de Aroma " + temporal.getValue().getAromaScoreAvg());
        }
        long tiempo_final = System.currentTimeMillis();
        System.out.println("Tiempo consulta 4: " + (tiempo_final - tiempo_inicial));
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

}

