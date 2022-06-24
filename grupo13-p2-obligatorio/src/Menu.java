import uy.edu.um.prog2.adt.tads.MyHeap.HeapNode;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeapImpl;
import uy.edu.um.prog2.adt.tads.MyHash.NodeHashTable;

import java.util.Scanner;

public class Menu
{
    public static void Menu()
    {
        DataLoad prueba = new DataLoad();
        //CargaDeDatos CargaDatos = new CargaDeDatos();
        int opcion = 0;

        while (opcion != 3)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. carga de datos.");
            System.out.println("2. Realizar consultas.");
            System.out.println("3. Finaliar programa.");
            opcion = sc.nextInt();

            if (opcion == 1)
            {
                //DataLoad.Carga();
                //System.out.println("Carga de datos finalizada.");
            }

            if (opcion == 2)
            {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("1. Las 10 casas de cerveza con mas resenias en un anio.");
                System.out.println("2. Top 15 catadores con mas resenias.");
                System.out.println("3. Cantidad de resenias en un rango dado.");
                System.out.println("4. Top 7 cervezas con mejor aroma.");
                System.out.println("5. Top 5 cervezas con mas reviews.");
                int opcion2 = sc1.nextInt();

                if (opcion2 == 1) {
                    //consulta 1
                }
                if (opcion2 == 2)
                {
                    MyHeapImpl<String, User> UserTop15 = new MyHeapImpl<>(true);
                    NodeHashTable[] review_vector = prueba.getReviews().getElements();
                    User[] user_array = new User[review_vector.length];
                    int j = 0;

                    for(int i = 0; i < review_vector.length; i++)
                    {
                        if(review_vector[i] != null)
                        {
                            Review review_temp = (Review) review_vector[i].getValue();
                            User user_temp = review_temp.getUser();

                            for(int x=0;x<user_array.length;x++)
                            {
                                if(user_array[x]!=null)
                                {
                                    if (user_temp.getUsername() == user_array[x].getUsername())
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
                        System.out.println("Nombre: " + temporal.getValue().getUsername() + ", Cantidad de Resenias: " + temporal.getValue().getCantidad_de_resenias());
                    }
                }
            }
        }
    }



    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.Menu();
    }

}