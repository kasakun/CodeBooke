/**
 * segment tree
 * 
 * parent = left + right
 * 
 * Time O(logn)
 * 
 * additional space O(1)
 */
class NumArray2 {
    
    private int n;
    private int[] tree;
    
    private void buildTree(int[] nums) {
        for (int i = 0, j = n; j < 2*n; ++i, ++j)
            tree[j] = nums[i];
        
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[2*i] + tree[2*i + 1];
    }
    
    public NumArray2(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            
            // n + n/2 + n/4 + n/8 + ... + 1 <= 2n
            tree = new int[2*n];
            buildTree(nums);
        }
    }
    
    public void update(int i, int val) {
        int pos = i + n;
        
        tree[pos] = val;
        
        // update parent;
        
        while (pos > 0) {
            int left = pos, right = pos;
            
            if (pos%2 == 0)
                right = pos + 1;  // pos hit left
            else
                left = pos - 1;  // pos hit right
            
            tree[pos/2] = tree[left] + tree[right];
            pos /= 2;
        }
    }
    
    public int sumRange(int i, int j) {
        int start = i + n, end = j + n, sum = 0;
        
        while (start <= end) {
            // if start is right leaf, add itself to the sum, skip the parent
            if (start%2 == 1) {
                sum += tree[start];
                ++start; // next must be a left leaf
            }
            
            // same reason
            if (end%2 == 0) {
                sum += tree[end];
                --end;
            }
            
            start /= 2;
            end /= 2;
        }
        
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */