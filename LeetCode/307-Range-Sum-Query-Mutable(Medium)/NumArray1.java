/**
 * Divide the array into blocks
 * 
 * The process of sum via blocks is faster.
 * 
 * Build: O(n)
 * Update: O(1)
 * Sum: O(sqrt(n))
 * 
 * Space: O(sqrt(n)), need additional sqrt(n) space
 * Remove "1" when copy to leetcode
 */
class NumArray1 {
    private int blockSize;
    private int[] block;
    private int[] nums;
    
    public NumArray1(int[] nums) {
        this.nums = nums;
        double numOfBlocks = Math.sqrt(nums.length);
        blockSize = (int) Math.ceil(nums.length/numOfBlocks);
        
        // blockSize*blockSize >= nums.length
        block = new int[blockSize];
        
        for (int i = 0; i < nums.length; ++i) {
            block[i/blockSize] += nums[i];
        }
    }
    
    public void update(int i, int val) {
        block[i/blockSize] += (val - nums[i]);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        
        int startBlock = i/blockSize;
        int endBlock = j/blockSize;
        
        // in one block
        if (startBlock == endBlock) {
            for (int k = i; k <= j; ++k)
                sum += nums[k];
        } else {
            // sum partially in start block
            for (int k = i; k < (startBlock + 1)*blockSize; ++k)
                sum += nums[k];
            // sum up blocks
            for (int k = startBlock + 1; k < endBlock; ++k)
                sum += block[k];
            // sum partially in end block
            for (int k = endBlock*blockSize; k <= j; ++k)
                sum += nums[k];
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