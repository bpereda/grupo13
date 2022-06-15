package uy.edu.um.prog2.adt.tads.MyHash;

public class MyHashImpl<Key, Value> implements MyHash<Key, Value> {

    private NodeHashTable<Key, Value>[] elements;
    private final int INITIAL_SIZE = 10;
    public int load;
    private final static float LOAD_FACTOR = 0.8f;

    public void MyHashTableImpl()
    {
        elements = new NodeHashTable[INITIAL_SIZE];
        load = 0;
    }

    @Override
    public void put(Key K, Value V)
    {
        int position = K.hashCode() %  elements.length;
        if (elements[position] == null || elements[position].isDeleted()
                || elements[position].getKey().equals(K))
        {
            NodeHashTable<Key, Value> nodo = new NodeHashTable<>(K,V);
            elements[position] = nodo;
        }else
        {
            int nroColision = 1;
            int newPosition = 0;

            do {
                nroColision++;
                newPosition = (K.hashCode() + colision(nroColision)) % elements.length;
            } while(elements[newPosition]!=null && !elements[newPosition].isDeleted()
                    && nroColision < elements.length);

            if(nroColision < elements.length)
            {
                NodeHashTable<Key, Value> node = new NodeHashTable<>(K,V);
                elements[newPosition] = node; // Aca YO cambie position por new position
            }
        }
        load++;
        // me fijo lo del factor de carga
        if (load >= elements.length*LOAD_FACTOR) //relacion entre largo y elementos cargados
        {
            rehash(elements.length*2);
        }
    }

    private void rehash(int newSize)
    {
        NodeHashTable<Key, Value>[] newElements = new NodeHashTable[newSize];
        NodeHashTable<Key, Value>[] oldElements = elements;
        elements = newElements;
        for (int i = 0; i<elements.length; i++)
        {
            if (elements[i] != null && !elements[i].isDeleted())
            {
                put(elements[i].getKey(), elements[i].getValue());
            }
        }
    }

    private int colision(int intento)
    {
        return intento;
    }

    @Override
    public Value get(Key k) {

        int posititon = k.hashCode() % elements.length;
        Value exit = null;
        if (this.elements[posititon] != null)
        {
            if (!this.elements[posititon].isDeleted()
                    && this.elements[posititon].getKey().equals(k))
            {
                // encontre el valor
                exit = elements[posititon].getValue();
            }else{

                //pudo haber una colision
                int nroColision = 1;
                int newPosition = 0;

                do {
                    nroColision++;
                    newPosition = (k.hashCode() + colision(nroColision)) % elements.length;
                } while(elements[newPosition]!=null && !elements[newPosition].isDeleted()
                        && nroColision < elements.length);
                if(nroColision < elements.length)
                {
                    if(elements[newPosition]!=null && !elements[newPosition].isDeleted())
                    {
                        exit = this.elements[newPosition].getValue();
                    }
                }
            }
        }
        return exit;
    }

    @Override
    public void remove(Key K) {

        int posititon = K.hashCode() % elements.length;
        if (this.elements[posititon] != null) {
            if (!this.elements[posititon].isDeleted()
                    && this.elements[posititon].getKey().equals(K)) {
                elements[posititon].setDeleted(true);
                this.load--;
            } else {
                int nroColision = 1;
                int newPosition = 0;
                do {
                    nroColision++;
                    newPosition = (K.hashCode() + colision(nroColision)) % elements.length;
                } while (elements[newPosition] != null && nroColision < elements.length && !elements[newPosition].getKey().equals(K));

                if (elements[newPosition] != null && nroColision < elements.length) {
                    elements[newPosition].setDeleted(true);
                    this.load--;
                }
            }
        }
    }


    @Override
    public int size() {
        return elements.length;
    }



}
