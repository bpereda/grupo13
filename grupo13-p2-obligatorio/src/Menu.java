/*import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.Scanner;

public class Menu
    {
    public static void Menu()
    {
        CargaDeDatos CargaDatos = new CargaDeDatos();
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. carga de datos.");
        System.out.println("2. Realizar consultas.");
        System.out.println("3. Finaliar programa.");
        int opcion = sc.nextInt();
        while (opcion!=3)
        {
            if (opcion==1)
            {
                try {
                    CargaDeDatos.Carga();
                } catch (IOException e) {
                } catch (CsvValidationException e) {
                }

            }else if(opcion==2)
            {
                System.out.println("1. Las 10 casas de cerveza con mas resenias en un anio.");
                System.out.println("2. Top 15 catadores con mas reseñas.");
                System.out.println("3. Cantidad de resenias en un rango dado.");
                System.out.println("4. Top 7 cervezas con mejor aroma.");
                System.out.println("5. Top 5 cervezas con mas reviews.");
                Scanner opcion2 = new Scanner(System.in);
            }
        }

    }

    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.Menu();
    }

    }*/