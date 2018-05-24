/**
 * Stack backed by a linked list.
 * @author Zeyu Chen
 * @version 0.1
 */


 public class LinkedStack<T> implements StackInterface<T> {
     private LinkedNode<T> head;
     private int size;

     /**
      * @return ture is the stack is empty.
      */
     @Override
     public boolean isEmpty() {
         return size == 0;
     }


     /**
      * Removes and returns the top-most element on the stack.
      * O(1) time.
      * 
      * @return that data from the front of the stack.
      * @throws java.util.NoSuchElementException if the stack is empty.
      */
     @Override
     public T pop() {
         if (isEmpty())
            throw new java.util.NoSuchElementException("No elements in the Stack!");
         
        T temp = head.getData();
        head = head.getNext();

        --size;
        return temp;
     }

     /**
      * 
      * @return data to add
      * @throws IllegalArgumentExceptiom if data is null
      */
     @Override
     public void push(T data) {
         if (data == null)
            throw new java.lang.IllegalArgumentException("Input is null!");
         LinkedNode<T> node = new LinkedNode<>(data, head);
        head = node;
         ++size;
     }

     @Override
     public int size() {
         return size;
     }

     /**
      * @return the head node
      */
     public LinkedNode<T> getHead() {
         return head;
     }

     public void print() {
         LinkedNode<T> node = head;
         System.out.print("Linked Stack: ");
         while(node != null) {
             System.out.print(node.getData() + " ");
             node = node.getNext();
         }
         System.out.println();
     }
 }