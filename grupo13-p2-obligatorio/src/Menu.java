import uy.edu.um.prog2.adt.tads.MyHeap.HeapNode;
import uy.edu.um.prog2.adt.tads.MyHeap.MyHeapImpl;
import uy.edu.um.prog2.adt.tads.MyHash.NodeHashTable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Menu
{
    public static void Menu()
    {

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
                DataLoad.Carga();
            }

            if (opcion == 2)
            {
                Consultas consulta = new Consultas();
                Scanner sc1 = new Scanner(System.in);
                System.out.println("1. Las 10 casas de cerveza con mas resenias en un anio.");
                System.out.println("2. Top 15 catadores con mas resenias.");
                System.out.println("3. Cantidad de resenias en un rango dado.");
                System.out.println("4. Top 7 cervezas con mejor aroma.");
                System.out.println("5. Top 5 cervezas con mas reviews.");
                int opcion2 = sc1.nextInt();

                if (opcion2 == 1) {
                    System.out.println(" Ingrese año en formato yyyy: ");
                    String year = sc1.next();
                    consulta.Consulta1(year);
                }
                if (opcion2 == 2)
                {
                    consulta.Consulta2();
                }
                if (opcion2 == 3){
                    System.out.println("Ingrese una fecha de comienzo dd/mm/yy: ");
                    String inicio = sc1.next();
                    System.out.println();
                    System.out.println("Ingrese una fecha de fin dd/mm/yyyy: ");
                    String fin = sc1.next();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                    try{
                        Date fecha_inicio = dateFormat.parse(inicio);
                        Date fecha_fin = dateFormat.parse(fin);
                        consulta.Consulta3(fecha_inicio,fecha_fin);
                    }catch (DateTimeParseException e){
                        throw new RuntimeException(e);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
                if (opcion2 == 4){
                    consulta.Consulta4();
                }
                if(opcion2 == 5){
                    consulta.Consulta5();
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