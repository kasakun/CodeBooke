import java.util.NoSuchElementException;

/**
 * Stack backed by an array.
 * @author Zeyu Chen
 * @version 1.0 
 */

 public class ArrayStack<T> implements StackInterface<T> {
    private T[] arr;
    private int size;

    /**
     * Construct a new ArrayStack, the initial size is 13.
     */
    @SuppressWarnings("unchecked") //blcok the force trandfer warning.
    public ArrayStack() {
         arr = (T[]) new Object[INITIAL_CAPACITY];
         size = 0; 
    }

    /**
     * 
     * @return true if the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 
     * @return 
     * @throws java.util.NoSuchElementException
     */
    @Override
    public T pop() {
        if (size == 0)
            throw new NoSuchElementException("No elements in the Stack!");
        T temp = arr[--size];
        arr[size] = null;
        return temp;
    }

    /**
     * 
     * @see StackInterface
     */
    @SuppressWarnings("unchecked")
    @Override
    public void push(T data) {
        if (data == null) 
            throw new IllegalArgumentException("Input data is null.");
        
        if (size == arr.length) {
            T[] temp = (T[]) new Object[2*arr.length + 1];
            for (int i = 0; i < arr.length; ++i) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[size] = temp;
        ++size;
    }

    /**
     * @return arr size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return the arr
     */
    public Object[] getArr() {
        return arr;
    }



 } 