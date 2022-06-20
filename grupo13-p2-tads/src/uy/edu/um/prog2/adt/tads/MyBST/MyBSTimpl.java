package uy.edu.um.prog2.adt.tads.MyBST;

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
        root = delete(root,key);

    }

    private NodeBST<K,T> delete(NodeBST<K,T> root, K key){

        if (root == null) {
            return null;
        }else if (key.compareTo(root.getKey()) < 0){

            root.setLeftChild(delete(root.getLeftChild(),key));

        }else if (key.compareTo(root.getKey())> 0){

            root.setRightChild(delete(root.getRightChild(),key));

        }else {
            if (root.getLeftChild() == null && root.getRightChild() == null){

                return null;

            }else if (root.getRightChild() == null){

                return root.getLeftChild();

            }else if (root.getLeftChild() == null){

                return root.getRightChild();

            }else {
                root.setKey(getMax(root.getLeftChild()));
                root.setLeftChild(delete(root.getLeftChild(),root.getKey()));
            }
        }
        return root;
    }

    private K getMin(NodeBST<K,T> root){
        K result = null;

        if (root.getLeftChild()==null){
            result = root.getKey();
        }else {
            result = getMin(root.getLeftChild());
        }
        return result;
    }

    private K getMax(NodeBST<K,T> root){
        K result = null;

        if(root.getRightChild() == null){
            result = root.getKey();
        }else {
            result = getMax(root.getRightChild());
        }
        return result;
    }

    @Override
    public void preOrden(){
        preOrden(root);
    }

    private void preOrden(NodeBST<K,T> root){
        if(root == null)
            return;

        System.out.println(root.getData());
        preOrden(root.getLeftChild());
        preOrden(root.getRightChild());

    }

    @Override
    public void inOrden(){
        inOrden(root);
    }

    private void inOrden(NodeBST<K,T> root){
        if(root == null)
            return;
        inOrden(root.getLeftChild());
        System.out.println(root.getData());
        inOrden(root.getRightChild());

    }

    @Override
    public void postOrden(){
        postOrden(root);
    }

    private void postOrden(NodeBST<K,T> root){
        if(root == null)
            return;

        postOrden(root.getLeftChild());
        postOrden(root.getRightChild());
        System.out.println(root.getData());

    }


    public static void main(String[] args) {
        MyBinarySearchTree arbol = new MyBSTimpl();
        arbol.insert(6,6);
        arbol.insert(2,2);
        arbol.insert(8,8);
        arbol.insert(4,4);
        arbol.insert(1,1);
        arbol.insert(3,3);
        arbol.insert(7,7);

        arbol.preOrden();
        arbol.delete(2);
        System.out.println();
        arbol.preOrden();
    }
}
