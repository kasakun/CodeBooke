import java.util.NoSuchElementException;

/**
 * 
 * @author Zeyu Chen
 * @version 0.1
 */

 public class MinHeap< T extends Comparable< ? super T >> 
    implements HeapInterface<T> {
    
    private T[] backingArray;
    private int size;

    public MinHeap() {
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Input item is null");
        }
        // resize
        if (size >= backingArray.length - 1) {
            T[] newArray = (T[]) new Comparable[backingArray.length*2];
            for (int i = 1; i <= size; ++i) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }

        // check if already in the heap
        for (int i = 1; i <= size; ++i) {
            if (backingArray[i].compareTo(item) == 0) {
                return;
            }
        }

        // add
        // If new item is smaller than father, swap
        ++size;
        int index = size;
        int parent = size/2;
        backingArray[index] = item;
        while (parent > 0 && backingArray[parent].compareTo(item) < 0) {
            T temp = backingArray[index];
            backingArray[index] = backingArray[parent];
            backingArray[parent] = temp;

            index = parent;
            parent /= 2;
        }

    }
    
    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        arr = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public Comparable[] getBackingArray() {
        return backingArray;
    }

 }