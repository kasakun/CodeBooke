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
        
        if (index == 0)
            addToFront(data);
        else if (index == size)
            addToBack(data);
        else {
            SLLNode<T> temp = head;
            for (int i = 0; i < index - 1; ++i) 
                temp = temp.getNext();
            temp.setNext(new SLLNode<T>(data, temp.getNext()));
            
            ++size;
        }
    }

    @Override
    public void addToBack(T data) {
        // check the data
        if (data == null)
            throw new IllegalArgumentException("The data is null!");

        tail.setNext(new SLLNode<T>(data));  
        tail = tail.getNext();
        if (size == 0)
            head = tail;

        ++size;
    }

    @Override
    public T removeFromFront() {
        // check the list is empty
        if (size == 0)
            return null;

        SLLNode<T> temp = head;
        head = head.getNext();
       
        --size;
        return temp.getData();
    }

    @Override
    public T removeAtIndex(int index) {
        // check the index exists
        if (index < 0 || index >= size)
            throw new java.lang.IndexOutOfBoundsException("The index is out of bound!");
        
        if (index == 0)
            return removeFromFront();
        else if (index == size - 1)
            return removeFromBack();
        else {
            SLLNode<T> temp = head;
            for (int i = 0; i < index - 1; ++i) 
                temp = temp.getNext();

            T tempData = temp.getNext().getData();
            temp.setNext(temp.getNext().getNext());
            --size;
            return tempData;
        }
        
    }

    @Override
    public T removeFromBack() {
        // check the list is empty
        if (size == 0)
            return null;
        else if (size == 1)
            return removeFromFront();
        
        SLLNode<T> temp = head;
        for (int i = 0; i < size - 2; ++i) 
            temp = temp.getNext();
        
        T tempData = temp.getNext().getData();
        temp.setNext(null);
        tail = temp;
       
        --size;
        return tempData;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new java.lang.IndexOutOfBoundsException("The index is out of bound!");
        
        if (index == 0)
            return head.getData();
        else if(index == size - 1)
            return tail.getData();
        else {
            SLLNode<T> temp = head;
            for (int i = 0; i < index; ++i)
                temp = temp.getNext();
            return temp.getData();
        }
    }

    @Override
    public T findLargestElement() {
        if (size == 0)
            return null;
        T max = head.getData();
        
        SLLNode<T> temp = head;

        while (temp != null) {
            if (max.compareTo(temp.getData()) < 0)
                max = temp.getData();
            temp = temp.getNext();
        }
        return max;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        SLLNode<T> temp = head;

        for (int i = 0; i < size; ++i) {
            arr[i] = temp.getData();
            temp = temp.getNext();
        }

        return arr;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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

    // print test
    public void print() {
        if (size == 0) {
            System.out.println("Print: No data in the list.");
        } else {
            System.out.print("List: ");
            SLLNode ptr = head;
            for (int i = 0; i < size; ++i) {
                if (i == size - 1)
                    System.out.println(ptr.getData() + ".");    
                else
                    System.out.print(ptr.getData() + ", ");
                
                ptr = ptr.getNext();
            }
        }

        return;
    }
}
