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


    /*public static void main(String[] args) {
        MyBinarySearchTree arbol = new MyBSTimpl();
        arbol.insert(6,6);
        arbol.insert(2,2);
        arbol.insert(8,8);
        arbol.insert(4,4);
        arbol.insert(1,1);
        arbol.insert(3,3);
        arbol.insert(7,7);

        arbol.preOrden();

    }*/
}
