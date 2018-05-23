import java.util.NoSuchElementException;

/**
 * 
 * @author: Zeyu Chen
 * @version: 0.1
 */


public class ArrayQueue<T> implements QueueInterface {
    private T[] arr;

    private int head;
    private int tail;
    private int size;

    /**
     * 
     */
    @SuppressWarnings("unchecked");
    public ArrayQueue() {
        arr = (T[]) new Object[INITIAL_CAPACITY];
        head = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 
     * 
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * After dequeue,
     * If head is at the end of the array: size = 0.
     * head = 0;tail=0;size =0; all reset.
     * If not simply ++head.
     * @see QueueInterface
     */
    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("No such element in queue!");
        T temp = arr[head];

        --size;

        if (head != arr.length - 1)
            ++head;
        else {
            // size = 0, resize the position. O(1).
            head = 0;
            tail = 0;
        }
        
        return temp;

    }


    /**
     * 
     * Before enqueue,
     * if tail at the end:1) arr is full 2) size is not full.
     * To save space, we do complicated way(actually u can simply all double the size,
     * since the time is actucally the same some time.)
     * 1) double the space, and do the copy.
     * 2) re-posiiton all ele to the head of the arr.
     * @see QueueInterface
     */
    @Override
    public void enqueue(Object data) {
        if (data == null)
            throw new IllegalArgumentException("Input data is null!"); 
            
        if (tail == arr.length - 1) {
            if (size == arr.length) {
                T[] tempArr = (T[]) new Object[2*arr.length + 1];
                for (int i = head; i < size; ++i) {
                    // implicitly head = 0
                    tempArr[i] = arr[i];
                }
                arr = tempArr;
            } else {
                // not full, resize.
                // Beacause j is always ahead i, it is ok in the same arr.
                for (int i = head, j = 0; i < size; ++i, ++j) {
                    arr[j] = arr[i];
                }
            }
        }
        arr[size] = data;
        tail = size;
        ++size;
    }

    /**
     * 
     * @see QueueInterace
     */

     @Override
     public int size() {
         return size;
     }
}