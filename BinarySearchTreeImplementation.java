package BinarySearchTree;

interface Nodes<E extends Comparable<E>> {
    public Node<E> getLeft();
    public Node<E> getRight();
    public void setLeft(Node<E> left);
    public void setRight(Node<E> right);
    public E getData();
    public void setData(E data);
}
interface BinaryTreeADT<E extends Comparable<E>>{
    void insert(E data);
    boolean search(E searchElement);
    void inOrder(Node<E> node);
    void preOrder(Node<E> node);
    void postOrder(Node<E> node);
    void reverseInOrder(Node<E> node);
    void delete(E data);
    int height(Node<E> node);
}
class Node<E> implements Nodes{
    private E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data){
        this.data = data;
    }

    @Override
    public Node<E> getLeft() {
        return null;
    }

    @Override
    public Node<E> getRight() {
        return null;
    }

    @Override
    public void setLeft(Node left) {
        this.left = left;
    }

    @Override
    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public Comparable getData() {
        return (Comparable) data;
    }

    @Override
    public void setData(Comparable data) {
        this.data = (E) data;
    }

}
class Implementation<E extends Comparable<E>> implements BinaryTreeADT{
    private Node<E> root;

    public Node<E> getRoot() {
        return root;
    }
    public boolean isEmpty(){
        return root == null;
    }

    @Override
    public void insert(Comparable data) {
        Node<E> node = new Node<E>((E) data);
        if(isEmpty()){
            root = node;
        }
        else{
            Node<E> temp = root;
            Node<E> parent = null;
            while(temp != null){
                parent = temp;
                if(data.compareTo(temp.getData())<=0){
                    temp = temp.getLeft();
                }
                else{
                    temp = temp.getRight();
                }
            }
            if(data.compareTo(parent.getData()) <= 0){
                parent.setLeft(node);
            }
            else{
                parent.setRight(node);
            }
        }
    }

    @Override
    public boolean search(Comparable searchElement) {
        Node<E> temp = root;
        boolean response = false;
        if(isEmpty()){
            System.out.println("Tree is Empty!");
        }
        else{
            if(temp.getData() == searchElement){
                response = true;
            }
            if(response==false && temp.getLeft()!=null){
                temp = temp.getLeft();
                if(temp.getData() == searchElement){
                    response = true;
                }
            }
            if(response==false && temp.getRight()!=null){
                temp = temp.getRight();
                if(temp.getData() == searchElement){
                    response = true;
                }
            }
        }
        return response;
    }

    @Override
    public void inOrder(Node node) {
        if(node != null){
            inOrder(node.getLeft());
            System.out.print(node.getData()+" ");
            inOrder(node.getRight());
        }
    }

    @Override
    public void preOrder(Node node) {
        if(node != null){
            System.out.print(node.getData()+" ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }

    }

    @Override
    public void postOrder(Node node) {
        if(node != null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData()+" ");
        }

    }

    @Override
    public void reverseInOrder(Node node) {

    }

    @Override
    public void delete(Comparable data) {

    }

    @Override
    public int height(Node node) {
        int response = 0;
        Node<E> temp = root;
        if(isEmpty()){
            response = 0;
        }
        else{
            int leftHeight = 0,rightHeight = 0;
            if(temp.getLeft()!= null){
                leftHeight=height(temp.getLeft());
            }
            if(temp.getRight()!=null){
                rightHeight=height(temp.getRight());
            }
            int maxHeight = (leftHeight>rightHeight)?leftHeight:rightHeight;
            response = maxHeight+1;
        }

        return response;
    }
}
public class Main{
    public static void main(String[] args) {
        Implementation<Integer> obj = new Implementation<Integer>();
        Node<Integer> node = new Node<>(5);
        obj.insert(5);
        obj.insert(10);
        obj.insert(25);
        obj.insert(2);
        obj.insert(34);
        obj.postOrder(node);

    }
}
