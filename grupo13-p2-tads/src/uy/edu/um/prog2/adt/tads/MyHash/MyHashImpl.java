package uy.edu.um.prog2.adt.tads.MyHash;

import static java.lang.Math.abs;

public class MyHashImpl<Key, Value> implements MyHash<Key, Value> {

    private NodeHashTable<Key, Value>[] elements;
    private final static int INITIAL_SIZE = 10;
    public int load;
    private final static float LOAD_FACTOR = 0.8f;

    public MyHashImpl() {
        this.elements = new NodeHashTable[INITIAL_SIZE];
        this.load = 0;
    }

    public NodeHashTable<Key, Value>[] getElements() {
        return elements;
    }

    public void setElements(NodeHashTable<Key, Value>[] elements) {
        this.elements = elements;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public void put(Key key, Value V)
    {
        int position = Math.abs(key.hashCode()) %  elements.length;

        if (elements[position] == null || elements[position].isDeleted()
                || elements[position].getKey().equals(key))
        {
            NodeHashTable<Key, Value> nodo = new NodeHashTable(key,V);
            elements[position] = nodo;
            load++;
        }else
        {
            int nroColision = 1;
            int newPosition = 0;

            do {
                nroColision++;
                newPosition = (Math.abs(key.hashCode()) + colision(nroColision)) % elements.length;
            } while(elements[newPosition]!=null && !elements[newPosition].isDeleted()
                    && nroColision < elements.length);

            if(nroColision < elements.length)
            {
                NodeHashTable<Key, Value> node = new NodeHashTable<>(key,V);
                elements[newPosition] = node; // Aca YO cambie position por new position
                load++;
            }
        }
        //load++;
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
        //load = 0;
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
    public Value get(Key key) {

        int position = Math.abs(key.hashCode()) % elements.length;
        Value exit = null;
        if (this.elements[position] != null)
        {
            if (!this.elements[position].isDeleted()
                    && this.elements[position].getKey().equals(key))
            {
                // encontre el valor
                exit = this.elements[position].getValue();
            }else{
                //pudo haber una colision
                int nroColision = 1;
                int newPosition = 0;

                do {
                    nroColision++;
                    newPosition = (Math.abs(key.hashCode()) + colision(nroColision)) % elements.length;
                } while(elements[newPosition]!=null && !elements[position].isDeleted() && elements[newPosition].getKey() == key
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
    public void remove(Key key) {

        int position = Math.abs(key.hashCode()) % elements.length;
        if (this.elements[position] != null) {
            if (!this.elements[position].isDeleted()
                    && this.elements[position].getKey().equals(key)) {
                elements[position].setDeleted(true);
                this.load--;
            } else {
                int nroColision = 1;
                int newPosition = 0;
                do {
                    nroColision++;
                    newPosition = (Math.abs(key.hashCode()) + colision(nroColision)) % elements.length;
                } while (elements[newPosition] != null && nroColision < elements.length
                        && !elements[newPosition].getKey().equals(key) && nroColision < elements.length
                        && elements[newPosition].getKey() == key);

                if (elements[newPosition] != null && nroColision < elements.length && !elements[newPosition].isDeleted())
                {
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
