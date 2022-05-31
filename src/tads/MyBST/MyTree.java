package tads.MyBST;

public interface MyTree<K,T> {
    T find(K key);
    void insert (K key,T data,K parentKey);
    void delete(K key);
}
