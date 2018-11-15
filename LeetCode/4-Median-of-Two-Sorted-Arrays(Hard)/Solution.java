/**
 * The problem can be also called top-k problem.
 * The thought is every time we eliminate k/2 elements in one iteration
 * finding kth of total. We will do specific explanation below.
 * 
 * Let's say we have two sorted arrays A and B and we are looking for kth.
 * The total length of arrays A and B is L, call it C
 * We take first k/2 elements from both A and B, then these k elements must have
 * some elements smaller than kth elemnt. 
 * 
 * For example, if A[k/2] < B [k/2]:
 * We can assert first k/2 elements of A can be eliminated. Why?
 * 
 * If there is A[i] in the first k/2 of A is larger than the C[k], then
 * we will have:
 *          C[k] < A[i] < A[k/2] < B[k/2]
 * 
 * Let make A[k/2] and B[k/2] in C noted as C[k + a], C[k + b](a < b),
 * and the most number before A[k/2] can be k/2 + k/2 - 1. The situation is
 * B[0], ..., B[k/2 - 1] < A[k/2]. Then the index of A[k/2] in C is k which
 * contradicts the C[k + a].
 * 
 * We can recursively do that until we reaches the kth at first we want.
 * 
 */
class Solution {
    /**
     * This method find the kth top number in arrays A and B
     * with starting from aStart and bStart.
     *
     */
    private int findKth(int[] A, int aStart, int[] B, int bStart, int k) {
        // corner case.
        if (aStart >= A.length) return B[bStart + k -1];
        if (bStart >= B.length) return A[aStart + k -1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);
        
        // We take k/2 from each arrays if we can
        int aIndex = aStart + k/2 - 1;
        int bIndex = bStart + k/2 - 1;
        
        int aValue = aIndex >= A.length ? Integer.MAX_VALUE : A[aIndex];
        int bValue = bIndex >= B.length ? Integer.MAX_VALUE : B[bIndex];
        
        // we eliminate k/2 elements, so the kth element becomes k - k/2th element.
        if (aValue <= bValue) {
            return findKth(A, aIndex + 1, B, bStart, k - k/2);
        } else {
            return findKth(A, aStart, B, bIndex + 1, k - k/2);
        }
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        
        if (len%2 == 0) {
            double left = (double) findKth(nums1, 0, nums2, 0, len/2);
            double right = (double) findKth(nums1, 0, nums2, 0, len/2 + 1);
            
            return (double) (left + right)/2;
        } else {
            return findKth(nums1, 0, nums2, 0, len/2 + 1);
        }
            
    }
}