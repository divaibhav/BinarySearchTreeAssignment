package myinterface;

public interface BinarySearchTreeADT<E extends Comparable<E>> {
    void insert(E data);
    boolean search(E searchElement);
    void inOrder(Node<E> node);
    void preOrder(Node<E> node);
    void postOrder(Node<E> node);
    void reverseInOrder(Node<E> node);
    void delete(E data);
    int height(Node<E> node);
}
