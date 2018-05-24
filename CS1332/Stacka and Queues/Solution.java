import java.io.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Test beigin.");
        System.out.println("================================================");

        System.out.println("Test: LinkedStack.");
        LinkedStack<Integer> stack1 = new LinkedStack<>();
        System.out.println("LinkedStack: push 10, 20, 30.");
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        stack1.print();        
        System.out.println("LinkedStack: pop.");
        stack1.pop();
        stack1.print();
        System.out.println("LinkedStack: pop.");
        System.out.println("LinkedStack: pop.");        
        stack1.pop();
        stack1.pop();
        stack1.print();
        System.out.println("================================================");

        System.out.println("Test: ArrayStack.");
        ArrayStack<Integer> stack2 = new ArrayStack<>();
        System.out.println("ArrayStack: push 10, 20, 30.");
        stack2.push(10);
        stack2.push(20);
        stack2.push(30);
        stack2.print();        
        System.out.println("ArrayStack: pop.");
        stack2.pop();
        stack2.print();
        System.out.println("ArrayStack: pop.");
        System.out.println("ArrayStack: pop.");        
        stack2.pop();
        stack2.pop();
        stack2.print();
        System.out.println("================================================");
        
        System.out.println("Test: LinkedQueue.");
        LinkedQueue<Double> queue1 = new LinkedQueue<>();
        System.out.println("Linked Queue: enqueue 10, 20, 30.");        
        queue1.enqueue(10.0);
        queue1.enqueue(20.0);
        queue1.enqueue(30.0);
        queue1.print();        
        System.out.println("Linked Queue: dequeue ==> " + queue1.dequeue());
        queue1.print();
        System.out.println("Linked Queue: dequeue ==> " + queue1.dequeue());        
        System.out.println("Linked Queue: enqueue 36.0.");
        queue1.enqueue(36.0);
        queue1.print(); 
        System.out.println("Linked Queue: dequeue ==> " + queue1.dequeue());        
        queue1.print();    
        System.out.println("================================================");
        
        System.out.println("Test: ArrayQueue.");
        ArrayQueue<Double> queue2 = new ArrayQueue<>();
        System.out.println("Array Queue: enqueue 10, 20, 30, 37.0, 43.0, 34.0.");        
        queue2.enqueue(10.0);queue2.enqueue(20.0);queue2.enqueue(30.0);
        queue2.enqueue(37.0);queue2.enqueue(43.0);queue2.enqueue(34.0);
        System.out.println("Array Queue: enqueue 10, 20, 30, 37.0, 43.0, 34.0.");        
        queue2.enqueue(10.0);queue2.enqueue(20.0);queue2.enqueue(30.0);
        queue2.enqueue(37.0);queue2.enqueue(43.0);queue2.enqueue(34.0);
        System.out.println("Array Queue: enqueue 10, 20, 30, 37.0, 43.0, 34.0.");        
        queue2.enqueue(10.0);queue2.enqueue(20.0);queue2.enqueue(30.0);
        queue2.enqueue(37.0);queue2.enqueue(43.0);queue2.enqueue(34.0);
        queue2.print();

        System.out.println("Array Queue: dequeue ==> " + queue2.dequeue());
        queue2.dequeue();
        queue2.print(); 
        System.out.println("Array Queue: dequeue ==> " + queue2.dequeue());
        queue2.print();    
        
        
        

    }
}