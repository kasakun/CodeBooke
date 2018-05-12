/**
 * Your implementation of a SinglyLinkedList
 *
 * @author Zeyu Chen
 * @version 1.0
 */
public class SinglyLinkedList<T extends Comparable<? super T>> implements
        LinkedListInterface<T> {
    // Do not add new instance variables.
    private SLLNode<T> head;
    private SLLNode<T> tail;
    private int size;

    @Override
    public void addToFront(T data) {
        // check the data
        if (data == null)
            throw new java.lang.IllegalArgumentException("The data is null!");
        //add
        head = new SLLNode<T>(data, head);
        // check if the list is empty before
        if (size == 0)
            tail = head;

        ++size;
    }

    @Override
    public void addAtIndex(T data, int index) {
        // check the data
        if (data == null)
            throw new java.lang.IllegalArgumentException("The data is null!");
        // check the index exists
        if (index < 0 || index > size)
            throw new java.lang.IndexOutOfBoundsException("The index is out of bound!");
        
        SLLNode temp = head;
        for (int i = 0; i < index; ++i) 
            temp = temp.getNext();
        temp = new SLLNode<T>(data, temp);

        ++size;
    }

    @Override
    public void addToBack(T data) {
        // check the data
        if (data == null)
            throw new IllegalArgumentException("The data is null!");

        tail = new SLLNode<T>(data);
        if (size == 0)
            head = tail;

        ++size;
    }

    @Override
    public T removeFromFront() {
        // check the list is empty
        if (size == 0)
            return null;

        SLLNode temp = head;
        head = head.getNext();
       
        --size;
        return temp.getData();
    }

    @Override
    public T removeAtIndex(int index) {
        // check the list is empty
        if (size == 0)
            return null;

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SLLNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }

    @Override
    public SLLNode<T> getTail() {
        // DO NOT MODIFY!
        return tail;
    }
}
