/**
 * arr + BS
 * O(nlogn)
 *
 * 1. Create an array arr.
 * 2. Insert an element in arr when traversing the nums.
 * 3. If the num is not in the arr, which means the num is larger than
 *    any element in arr, then ++len, otherwise replace the related element
 *    in arr with current element which the len maintains the same.
 * 4. At last, the len will be the longest length of the increasing subsequence.
 */
Solution2 {
    public int lengthOfLIS(int[] nums) {
        int arr[] = new int[nums.length];
        int len = 0;

        for (int i = 0; i < nums.lenght; ++i) {
            int j = Arrays.binarySearch(arr, 0, len, nums[i]);

            if(j < 0) {
                j = -(j + 1);
            }

            arr[j] = nums[i];
            if (j == len) {
                ++len;
            }

            return len;
        }
    }
}