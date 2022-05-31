package tads.MyBST;

public class Tree<K extends Comparable<K>,T> implements MyTree<K,T> {
    private Node<K,T> root;

    @Override
    public T find(K key) {
        return find(key,root).getData();

    }

    private Node<K,T> find(K key,Node<K,T> root){
        Node<K,T> result = null;

        if(root != null){
            if (key.compareTo(root.getKey())>0){
                result = find(key,root.getRightChild());

            }else if (key.compareTo(root.getKey())<0){
                result = find(key,root.getLeftChild());
            }
        }

        return result;
    }
    @Override
    public void insert(K key, T data, K parentKey) {
        Node<K,T> parentNode = find(parentKey,root);
        Node<K,T> newNode = new Node<>(key,data);

        if (parentNode != null){
            if (key.compareTo(parentKey) > 0){
                insert(key,data,parentNode.getRightChild().getKey());
            }else if (key.compareTo(parentKey) <= 0){
                insert(key,data,parentNode.getLeftChild().getKey());
            }
        }
    }


    @Override
    public void delete(K key) {


    }

}
