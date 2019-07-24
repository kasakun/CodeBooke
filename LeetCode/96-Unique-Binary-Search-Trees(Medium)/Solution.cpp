class Solution {
public:
    int numTrees(int n) {
        vector<int> vec;
        vec.push_back(1);
        
        for (int i = 1; i <= n; ++i) {
            int ans = 0;
            
            for (int j = 0; j < i; ++j)
                ans += vec[j]*vec[i - j - 1];
            
            vec.push_back(ans);
        }
        
        return vec.back();
    }
};

