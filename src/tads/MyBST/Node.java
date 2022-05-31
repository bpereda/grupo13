package tads.MyBST;

public class Node<K,T> {
    K key;
    T data;

    Node<K,T> leftChild;
    Node<K,T> rightChild;

    public Node(K key, T data) {
        this.key = key;
        this.data = data;

    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
