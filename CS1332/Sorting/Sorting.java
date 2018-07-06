import java.util.Random;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author Zeyu Chen
 * @version 0.1
 */

public class Sorting {
    /**
     * Implement cocktail sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable).
     *
     * See the PDF for more info on this sort.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Null array or comparator!");
        }

        boolean swapped = false;
        int start = 0, end = arr.length - 1;

        // if once not swap in one cycle, then done
        while(true) {
            for (int i = start; i < end; ++i) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            } else {
                swapped = false;
                --end;
            }

            for (int i = end; i > start; --i) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            } else {
                swapped = false;
                ++start;
            }
        }
    }

    /**
     * Insertion Sort
     * 
     * a0, a1, a2, a3,..., an is sorted.
     * an+1,..., am is not sorted.
     * 
     * select one in n+1~m to insert in the sorted array
     * 
     * Implement insertion sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable).
     *
     * See the PDF for more info on this sort.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Null array or comparator!");
        }        
        
        for (int i = 1; i < arr.length; ++i) {
            int j = i;

            while (j > 0 && comparator.compare(arr[j - 1], arr[j]) > 0) {
                swap(arr, j -1, j);
                --j;
            }
        }
    }

    /**
     * 
     * loop n + 1~m -> find min, swap n, i
     * 
     * 
     * Implement selection sort.
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n^2)
     *
     * Note that there may be duplicates in the array, but they may not
     * necessarily stay in the same relative order.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Null array or comparator!");
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }

            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * Implement quick sort.
     *
     * Use the provided random object to select your pivots.
     * For example if you need a pivot between a (inclusive)
     * and b (exclusive) where b > a, use the following code:
     *
     * int pivotIndex = r.nextInt(b - a) + a;
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * Note that there may be duplicates in the array.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not use the one we have taught you!
     *
     * @throws IllegalArgumentException if the array or comparator or rand is
     * null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand the Random object used to select pivots
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator, Random rand) {
        if (arr == null || comparator == null || rand == null) {
            throw new IllegalArgumentException("Null array or comparator or random!");
        }

        quickSort(arr,comparator, rand, 0, arr.length - 1) ;
    }

    /**
     * Helper function for quicksort
     * 
     * @param arr        ArrayList
     * @param comparator comparator
     * @param random     Random pivot
     * @param start      The start index
     * @param end        The end index
     */
    private static <T> void quickSort(T[] arr, Comparator<T> comparator, Random rand,
                                      int start, int end) {
        if (start >= end) // minimum
            return;
        
        int pivotIndex = rand.nextInt(end + 1 - start) + start;

        T pivot = arr[pivotIndex];

        swap(arr, pivotIndex, start);

        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= right && comparator.compare(arr[left], pivot) <= 0) {
                ++left;
            }
            while (left <= right && comparator.compare(arr[right], pivot) >= 0) {
                --right;
            }

            if (left <= right) {
                swap(arr, left, right);
                ++left;
                --right;
            }

            swap(arr, start, right);
            quickSort(arr, comparator, rand, start, right - 1);
            quickSort(arr, comparator, rand, right + 1, end);
        }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(n log n)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * You can create more arrays to run mergesort, but at the end,
     * everything should be merged back into the original T[]
     * which was passed in.
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Null array or comparator!");
        }

        mergeSort(arr, comparator, 0, arr.length - 1);
    }

    /**
     * Helper method for merge sort
     * 
     * @param arr           array list
     * @param comparator    comparator
     * @param start         start index
     * @param end           end index
     */
    private static <T> void mergeSort(T[]arr, Comparator<T> comparator, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start)/2;

        mergeSort(arr, comparator, start, mid);
        mergeSort(arr, comparator, mid + 1, end);
        merge(arr, comparator, start, mid, end);
    }

    /**
     * Helper method to merge two sorted arrays 
     * 
     */
    private static <T> void merge(T[]arr, Comparator<T> comparator,
                                  int start, int mid, int end) {
        int left = start;
        int right = end;

        int leftEnd = mid;
        int rightEnd = end;

        T[] temp = (T[]) new Object[arr.length];

        int index = start;

        while (left <= leftEnd && right <= rightEnd) {
            if (comparator.compare(arr[left], arr[right]) < 0) {
                temp[index] = arr[left];
                ++left;
            } else {
                temp[index] = arr[right];
                ++right;
            }
            ++index;
        }

        while (left <= leftEnd) {
            temp[index] = arr[left];
            ++left;++index;
        }

        while (right <= rightEnd) {
            temp[index] = arr[right];
            ++right;++indexl;
        }

        for (int i = start; i <= end; ++i) {
            arr[i] = temp[i];
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(kn)
     *
     * And a best case running time of:
     *  O(kn)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable)
     *
     * Do NOT use {@code Math.pow()} in your sort.
     *
     * You may use {@code java.util.ArrayList} or {@code java.util.LinkedList}
     * if you wish, but it may only be used inside radix sort and any radix sort
     * helpers. Do NOT use these classes with other sorts.
     *
     * @throws IllegalArgumentException if the array is null
     * @param arr the array to be sorted
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Null arr!");
        }

        Queue<Integer>[] buckets = new Queue<>[19];
        for (Queue<Integer> bucket: buckets) {
            bucket = new LinkedList<>();
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
            }
        }

        // find tha maxium, because its length = iteration
        int it = 0;
        while (max != 0) {
            ++it;
            max = max/10;
        }

        // start iterations
        for (int i = 0; i < it; ++i) {
            for (int j = 0; j < arr.length; ++j) {
                int temp = arr[j]/power(10, i);
                int bucket = (temp % 10) + 9;

                if (buckets[bucket] == null) {
                    buckets[bucket] = new LinkedList<>();
                }
                buckets[bucket].add(arr[j]);
            }

            int index = 0;
            for (Queue<Integer> bucket: buckets) {
                while(bucket != null && !bucket.isEmpty()) {
                    arr[index] = bucket.remove();
                    ++index;
                }
            }
        }
    }

    /**
     * power method
     */
    private static int power(int base, int exp) {
        if (exp == 0)
            return 1;
        if (exp == 1)
            return base;

        int half = power(base, exp/2);

        if (exp % 2 == 0) {
            return half*half;
        } else {
            return half*power(base, exp/2 + 1);
        }
    }

    /**
     * A method to swap two items in array
     * @param arr the current array
     * @param i index of one item
     * @param j index of the other item
     * @param <T> data type to sort
     */
    private static <T> void swap(T[] arr, int i, int j) {

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}