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
     * O(logn)
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
        while (parent > 0 && backingArray[index].compareTo(backingArray[parent]) < 0) {
            T temp = backingArray[index];
            backingArray[index] = backingArray[parent];
            backingArray[parent] = temp;

            index = parent;
            parent /= 2;
        }

    }
    
    /**
     * O(logn)
     * @see Interface
     */
    @Override
    public T remove() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }

        T removeItem = backingArray[1];
        int index = size;
        backingArray[1] = backingArray[index];
        backingArray[index] = null;
        --size;
        index = 1;

        while (index <= size/2) {
            int minChild = index*2;
            if (backingArray[index*2 + 1] != null) {
                if (backingArray[index*2 + 1].compareTo(backingArray[minChild]) < 0) {
                    minChild = index*2 + 1;
                }
            }

            if (backingArray[minChild].compareTo(backingArray[index]) < 0) {
                T temp = backingArray[minChild];
                backingArray[minChild] = backingArray[index];
                backingArray[index] = temp;
            }

            index = minChild;
        }

        return removeItem;
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
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public Comparable[] getBackingArray() {
        return backingArray;
    }

 }