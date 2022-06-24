/*public class Ordenamiento<T> {

    public static <T extends Comparable<T>> T[] Orden(T[] array, int begin, int end)
    {
        T auxiliar;
        int i = begin;
        int j = end;
        T pivote = array[((begin + end)/2)];

        do {
            while (array[i].compareTo(pivote) == 1) {
                i--;
            }
            while (array[j].compareTo(pivote) == 1) {
                j++;
            }
            if(i<=j)
            {
                auxiliar=array[i];
                array[i]=array[j];
                array[j]=auxiliar;
                i--;
                j++;
            }
        } while (array[j].compareTo(pivote) == -1);

        if(begin<j)
        {
            Orden(array, begin, j);
        }
        if(i<end)
        {
            Orden(array, i, end);
        }
        return array;
    }

    /*public static void main(String[] args) {
        Ordenamiento a = new Ordenamiento();
        User u1 = new User("Agus");
        u1.setCantidad_de_resenias(3);
        User u2 = new User("Lu");
        u2.setCantidad_de_resenias(1);
        User u3 = new User("Euge");
        u3.setCantidad_de_resenias(2);
        User u4 = new User("Belu");
        u4.setCantidad_de_resenias(4);
        User[] usuarios = {u1,u2,u3,u4};
        a.Orden(usuarios, 0, usuarios.length-1);
    }
}*/