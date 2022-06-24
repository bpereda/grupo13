import uy.edu.um.prog2.adt.tads.MyHash.MyHash;
import uy.edu.um.prog2.adt.tads.MyHash.NodeHashTable;
import uy.edu.um.prog2.adt.tads.MyHeap.HeapNode;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeap;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeapImpl;

import java.security.Key;


public class Consultas {

    public Consultas() {
        DataLoad.Carga();
    }

    private MyHash<Long,Brewery> breweries = DataLoad.getBreweries();
    private MyHash<Long,Beer> beers = DataLoad.getBeers();

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
        //prueba.Consulta1("1970");
        prueba.Consulta5();
    }
}

