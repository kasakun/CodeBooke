/**
 * 
 * @author Zeyu Chen
 * @version 0.1
 */
public class MinPriorityQueue<T extends Comparable<? super T>>
    implements PriorityQueueInterface<T> {
    
    private HeapInterface<T> backingHeap;

    public MinPriorityQueue() {
        backingHeap = new MinHeap<>();
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public void enqueue(T item) {
        backingHeap.add(item);
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public T dequeue() {
        return backingHeap.remove();
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public boolean isEmpty() {
        return backingHeap.isEmpty();
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public int size() {
        return backingHeap.size();
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public void clear() {
        backingHeap.clear();
    }

    @Override
    public HeapInterface<T> getBackingHeap() {
        return backingHeap;
    }
}