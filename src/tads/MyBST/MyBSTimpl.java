package tads.MyBST;

public class MyBSTimpl<K extends Comparable<K>,T> implements MyBinarySearchTree<K,T> {
    private NodeBST<K,T> root;

    public MyBSTimpl() {
    }

    @Override
    public T find(K key) {
        return find(key,root).getData();
    }

    private NodeBST<K,T> find(K key,NodeBST<K,T> root){
        NodeBST<K,T> result = null;

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
    public void insert(K key, T data) {
        root = insert(key,data,root);
    }

    private NodeBST<K,T> insert(K key,T data, NodeBST<K,T> root){
        NodeBST<K,T> result = null;

        if (root == null){
            result = new NodeBST<>(key,data);
        }else if(key.compareTo(root.getKey())>0){
            root.setRightChild(insert(key,data,root.getRightChild()));
            result = root;
        }else if (key.compareTo(root.getKey())<0){
            root.setLeftChild(insert(key,data,root.getLeftChild()));
            result  = root;
        }
        return result;
    }

    @Override
    public void delete(K key) {

    }
}
