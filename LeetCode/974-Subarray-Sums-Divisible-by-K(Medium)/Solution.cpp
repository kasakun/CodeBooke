/**
 * The key idea is to understand:
 * we first create a list of presum.
 *
 * (sum[i] - sum[j])%K == 0 -> we only need to care about previous sum with same remainder
 *
 * sum[i]%K == sum[j]%K
 *
 * Example: 4, 5, 0, -2, -3, 1
 * 
 * r[0]=1
 *
 * 1.r[4]=1, res = 0
 * 2.r[4]=2, res = 1
 * 3.r[4]=3, res = 3 2 number make up area, we have 4, 5, 0 -> [4,5] [5, 0] [4, 5, 0]
 * 4.r[2]=1, res = 3
 * 5.r[4]=4, res = 6
 * 6.r[0]=2, res = 7
 */ 
class Solution {
public:
    int subarraysDivByK(vector<int>& A, int K) {
        int remainders[K] = {0};
        int res = 0, preSum = 0;
        
        remainders[0] = 1;
        
        for (int a : A) {
            preSum = (preSum + a) % K;
            if (preSum < 0) preSum += K;
            
            res += remainders[preSum];
            ++remainders[preSum];
        }
        
        return res;
    }
};

