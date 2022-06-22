import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        System.out.println("1. carga de datos.");
        System.out.println("2. Realizar consultas.");
        System.out.println("3. Finaliar programa.");
        Scanner opcion = new Scanner(System.in);
        while (!opcion.equals(3))
        {
            if (opcion.equals(1))
            {





                //FIXME carga de datos se hace aqui
            }else if(opcion.equals(2))
                {
                System.out.println("1. Las 10 casas de cerveza con mas resenias en un año.");
                System.out.println("2. Top 15 catadores con mas reseñas.");
                System.out.println("3. Cantidad de resenias en un rango dado.");
                System.out.println("4. Top 7 cervezas con mejor aroma.");
                System.out.println("5. Top 5 cervezas con mas reviews.");
                Scanner opcion2 = new Scanner(System.in);
                }
            }
        }
    }
