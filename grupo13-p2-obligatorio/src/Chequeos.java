public class Chequeos {
    public boolean chequeoDatos(String[] vectorDatos)
    {
        boolean datos_validos = true;
        if(vectorDatos.length!=14)
        {
            datos_validos = false;
        }

        for (int i=0;i<vectorDatos.length;i++)
        {
            if (vectorDatos[i] == null || vectorDatos[i].length()>=1)
            {
                datos_validos = false;
            }
        }
        return datos_validos;
    }

}
