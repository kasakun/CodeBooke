class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) return -1;
        int start = 0, costSum = 0, traveled = 0;
        
        for (int i = 0; i < 2*gas.length; ++i) {
            int index = i % gas.length;
            
            costSum += (gas[index] - cost[index]);
            
            if (costSum < 0) {
                costSum = 0;
                traveled = 0;
                start = index + 1;
            } else {
                ++traveled;
                if (traveled >= gas.length) return start;
            }
        }
        
        return -1;
    }
}