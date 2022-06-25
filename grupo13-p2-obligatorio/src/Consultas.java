import uy.edu.um.prog2.adt.tads.MyArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.MyHash.MyHashtable;
import uy.edu.um.prog2.adt.tads.MyHash.MyHashtable;
import uy.edu.um.prog2.adt.tads.MyHash.NodeHashTable;
import uy.edu.um.prog2.adt.tads.MyHeap.HeapNode;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeap;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeapImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;


public class Consultas {

    public Consultas() {
    }

    private MyHashtable<Long,Brewery> breweries = DataLoad.getBreweries();
    private MyHashtable<Long,Beer> beers = DataLoad.getBeers();
    private MyHashtable<Long,Review> reviews = DataLoad.getReviews();
    private MyHashtable<String, User> users = DataLoad.getUsers();
    private MyHashtable<String,Style> styles = DataLoad.getStyles();
    private MyArrayList<Beer> beersValues= beers.getValues();
    private MyArrayList<Brewery> breweriesValues = breweries.getValues();
    private MyArrayList<User> usersValues = users.getValues();
    private MyArrayList<Review> reviewsElements = reviews.getValues();
    private MyArrayList<Style> stylesValues = styles.getValues();

    public void Consulta1(String year){
        long tiempo_final;
        long tiempo_inicial = System.currentTimeMillis();
        MyHeap<Integer,Brewery> topTen = new MyHeapImpl<>(true);

        for (int i = 0; i < beersValues.size(); i++) {
            for (int j = 0; j < beersValues.get(i).getReviews().size() ; j++) {
                Review review = beersValues.get(i).getReviews().get(j);
                String yearStr = review.getYear();
                if (yearStr.equals(year)){
                    Long breweryId = review.getIdBrewery();
                    if (breweries.get(breweryId) != null){
                        Brewery brewery = breweries.get(breweryId);
                        brewery.setReviewsPerYear(brewery.getReviewsPerYear() + 1);
                    }

                }
            }
        }


        for (int i = 0; i < breweriesValues.size(); i++) {
             topTen.insert(breweriesValues.get(i).getReviewsPerYear(),breweriesValues.get(i));

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

        //NodeHashTable[] usersElements = users.getElements();
        //NodeHashTable[] reviewsElements = reviews.getElements();
        //int contador = 0;
        //int contador2 = 0;
        //int contador3 = 0;
        //System.out.println("Elementos del hash reviews: "+ DataLoad.reviews.load);
        //System.out.println("Elementos del arrayhash reviews: "+ reviews.size());

       for (int i = 0; i < reviewsElements.size(); i++) {
           Review reviewTemp = reviewsElements.get(i);
           User userTemp = reviewTemp.getUser();
           if (users.get(userTemp.getUsername()) != null)
               users.get(userTemp.getUsername()).setCantReviews(users.get(userTemp.getUsername()).getCantReviews() + 1);
       }

       for (int i = 0; i < usersValues.size(); i++) {
           UserTop15.insert(usersValues.get(i).getCantReviews(),usersValues.get(i));
       }


        for(int z=0;z<15;z++)
        {
            HeapNode<Integer, User> temporal = UserTop15.delete();
            System.out.println("Nombre: " + temporal.getValue().getUsername() + ", Cantidad de Resenias: " + temporal.getValue().getCantReviews());
        }
        tiempo_final = System.currentTimeMillis();
        System.out.println("Tiempo Consulta1: " + (tiempo_final - tiempo_inicial));

    }

    public void Consulta3(Date inicio, Date fin){
        long tiempo_final;
        long tiempo_inicial = System.currentTimeMillis();
        int count = 0;


        for (int i = 0; i < reviewsElements.size(); i++) {
            if ((reviewsElements.get(i).getDate().compareTo(inicio) > 0) && (reviewsElements.get(i).getDate().compareTo(fin) < 0)){
                count++;
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
        MyHeapImpl<Double,String> Top7 = new MyHeapImpl<>(true);
        for (int i = 0; i < beersValues.size(); i++) {
            Beer temp = beersValues.get(i);
            MyArrayList<Review> reviews = temp.getReviews();
            Style tmp = temp.getStyle();

            for (int j = 0; j < reviews.size(); j++) {
                tmp.getAromaScores().insert(reviews.get(j).getAromaScore());
            }
        }
        for (int i = 0; i < stylesValues.size(); i++) {
            Style temp = stylesValues.get(i);
            MyArrayList<Double> aromasScore = temp.getAromaScores();
            double promedio = 0;
            for (int j = 0; j < aromasScore.size(); j++) {
                promedio += aromasScore.get(j);
            }
            promedio /= aromasScore.size();
            Top7.insert(promedio,temp.getName());
        }

        for(int i=0; i<7; i++)
        {
            HeapNode<Double, String> temporal = Top7.delete();
            System.out.println("Estilo: " + temporal.getValue() + ", Promedio de Aroma: " + temporal.getKey());
        }
        long tiempo_final = System.currentTimeMillis();
        System.out.println("Tiempo consulta 4: " + (tiempo_final - tiempo_inicial));
    }

    public void Consulta5(){
        long tiempo_final;
        long tiempo_inicial = System.currentTimeMillis();
        MyHeap<Integer,Beer> topFive = new MyHeapImpl<>(true);

        for (int i = 0; i < beersValues.size(); i++) {
            topFive.insert(beersValues.get(i).getNumberReviews(),beersValues.get(i));
        }

        for (int i = 0; i < 5; i++) {
            HeapNode<Integer,Beer> temp = topFive.delete();
            System.out.println("Nombre: "+temp.getValue().getName()+" Cantidad de reviews: "+temp.getKey()+" Puntaje General: "+temp.getValue().avgGeneralScore());
        }
        tiempo_final = System.currentTimeMillis();
        System.out.println("Tiempo Consulta5: " + (tiempo_final - tiempo_inicial));
    }


}

