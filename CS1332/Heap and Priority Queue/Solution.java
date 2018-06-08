import java.io.*;

public class Solution {
    public static void main(String[] args) {
        MinPriorityQueue<Integer> pQueue = new MinPriorityQueue<>();

        System.out.println("Test begin.");
        System.out.println("================================================");
        System.out.println("pQueue add -23, 10, 13, 17, 18, 90, 100, 23");
        pQueue.enqueue(-23);
        pQueue.enqueue(10);
        pQueue.enqueue(13);
        pQueue.enqueue(17);
        pQueue.enqueue(18);
        pQueue.enqueue(90);
        pQueue.enqueue(100);
        pQueue.enqueue(23);
        System.out.println("Dequeue: " + pQueue.dequeue());
        System.out.println("Dequeue: " + pQueue.dequeue());
        System.out.println("Dequeue: " + pQueue.dequeue());
        System.out.println("Dequeue: " + pQueue.dequeue());

        System.out.println("================================================");
        System.out.println("Done.");

    }
}