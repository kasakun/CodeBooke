/**
 * 
 * @author:Zeyu Chen
 * @version:0.1
 */

 public class LinkedQueue<T> implements QueueInterface {
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;

    /**
     * 
     * @see QueueInterface
     */
    @Override
     public boolean isEmpty() {
         return false;
     }

    /**
     * 
     * @see QueueInterface
     */
     @Override
     public T dequeue() {
         if (isEmpty())
            throw new java.util.NoSuchElementException("No element in the queue!");
         T temp = head.getData();
         head = head.getNext();
         if (size == 1) 
             tail = null;
         --size;
         return temp;
     }

     /**
      * 
      * @see QueueInterface
      */
     @Override
     public void enqueue(Object data) {
         if (data == null)
            throw new IllegalArgumentException("The input data is null!");
         
         if (size == 0) {
            tail = new LinkedNode<T>(data);
            head = tail;
         } else {
             tail.setNext(new LinkedNode<T>(data));
             tail = tail.getNext();
         }
         ++size;
     }


     /**
      * 
      * @see QueueInterface
      */
     @Override
     public int size() {
         return size;
     }


     
 }