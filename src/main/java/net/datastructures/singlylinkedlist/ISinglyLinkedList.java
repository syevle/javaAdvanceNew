package net.datastructures.singlylinkedlist;

/**
 * Created by Santosh on 6/24/17.
 */
public interface ISinglyLinkedList<E> {

    public int size();
    public boolean isEmpty();
    public E first();
    public E last();
    public void addFirst(E e);
    public void addLast(E e);
    public E removeFirst();

}