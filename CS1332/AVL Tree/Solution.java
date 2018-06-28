import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Integer[] data = {10, 6, 7, 4, 12, 5, 1, 13, 11, 15, 17, 19, 22, 24, 14};
        ArrayList<Integer> dataColl = new ArrayList<>(Arrays.asList(data));
        AVL<Integer> tree = new AVL<>(dataColl);

    }
}