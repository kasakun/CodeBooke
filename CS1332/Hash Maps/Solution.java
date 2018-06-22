import java.io.*;

public class Solution {
    public static void main(String args[]) {
        System.out.println("Test for Hash Map.");
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("Put (3, 4)");
        map.put(3, 4);
        System.out.println("Map contains 3?  :" + map.containsKey(3));
        System.out.print("Map contains 12? :" + map.containsKey(12));
        System.out.println(" size: " + map.size());

        System.out.println("Put (12, 34)");
        map.put(12, 34);
        System.out.print("Map contains 12? :" + map.containsKey(12));
        System.out.println(" size: " + map.size());
    }
}