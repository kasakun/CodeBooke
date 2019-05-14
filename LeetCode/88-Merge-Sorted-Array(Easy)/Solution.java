class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1, len = nums1.length - 1;
        
        for (; index1 >= 0 && index2 >= 0;) {
            
            if (nums1[index1] > nums2[index2])
                nums1[len--] = nums1[index1--];
            else
                nums1[len--] = nums2[index2--];
        }
        
        if (index2 >= 0) {
            while (index2 >= 0) {
                nums1[index2] = nums2[index2];
                --index2;
            }
        }

        return;
    }
}