public class MyQueueImpl<T> implements MyQueue<T>{

    private Node first;
    private Node last;
    int size = 0;

    @Override
    public void enqueue(T element) {

        Node<T> nuevo = new Node(element);

        if(isEmpty())
        {
            this.first = nuevo;
            this.last = nuevo;
        }else
        {
            this.last.setNext(nuevo);
            this.last = nuevo;
        }
        size++;
    }

    @Override
    public T dequeue() throws EmptyQueueException {

        Node<T> buscado = null;

        if(isEmpty())
        {
            throw new EmptyQueueException();
        }else
        {
            buscado = this.first;
            this.first = this.first.getNext();
        }

        return (T) buscado;
    }

    @Override
    public boolean isEmpty() {
        if(this.first==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean contains(T value) {

        boolean contains = false;

        Node<T> temporal = this.first;

        while(temporal!=null && !temporal.getValue().equals(value)){
            temporal = temporal.getNext();
        }

        if(temporal!=null)
        {
            contains = true;
        }
        return contains;
    }
}

