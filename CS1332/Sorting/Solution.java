import java.io.*;
import java.util.Comparator;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        final Double[] doubleArr = new Double[]{10.0, 9.0, 8.0, 1.2, 123.0, -2.5, 0.9, 8.4, 9.2, 10.0};
        Double[] arr;
        int[] intArr = new int[]{1, 2, 4, 5, 90, 12, 100, 12, 12, 2};
        
        
        System.out.println("Original arr: ");
        printArr(doubleArr);

        System.out.println("=======================================");
        System.out.println("Test cocktail");
        arr = doubleArr;
        Sorting.cocktailSort(doubleArr, new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                int res = 0;

                if (a > b)
                    res = 1;
                else if (a < b)
                    res = -1;
                return res;
            }
        });
        printArr(arr);

        System.out.println("=======================================");
        System.out.println("Test insertion");
        arr = doubleArr;
        Sorting.insertionSort(doubleArr, new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                int res = 0;

                if (a > b)
                    res = 1;
                else if (a < b)
                    res = -1;
                return res;
            }
        });
        printArr(arr);

        System.out.println("=======================================");
        System.out.println("Test selection");
        arr = doubleArr;
        Sorting.selectionSort(doubleArr, new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                int res = 0;

                if (a > b)
                    res = 1;
                else if (a < b)
                    res = -1;
                return res;
            }
        });

        System.out.println("=======================================");
        System.out.println("Test quick sort");
        arr = doubleArr;
        Sorting.quickSort(doubleArr, new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                int res = 0;

                if (a > b)
                    res = 1;
                else if (a < b)
                    res = -1;
                return res;
            }
        }, new Random());
        printArr(arr);

        System.out.println("=======================================");
        System.out.println("Test merge sort");
        arr = doubleArr;
        Sorting.mergeSort(doubleArr, new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                int res = 0;

                if (a > b)
                    res = 1;
                else if (a < b)
                    res = -1;
                return res;
            }
        });
        printArr(arr);

        System.out.println("=======================================");
        System.out.println("Test LSD Radix");
        System.out.println("Original:");
        printArr(intArr);
        System.out.println("=======================================");
        sorting.lsdRadixSort(intArr);
        printArr(intArr);

    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    private static <T> void printArr(T[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}