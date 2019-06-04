/**
 * O(NlogN)
 * 
 */
class Solution {
private:
    struct myCompare {
        bool operator()(vector<int>& a, vector<int>& b) {
            return (a[0]*a[0] + a[1]*a[1]) > (b[0]*b[0] + b[1]*b[1]);
        }
    };
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int K) {
        int size = points.size();
        vector<vector<int>> res;
        if (size == 0 || K > size) return res;
        
        priority_queue<vector<int>, vector<vector<int>>, myCompare> pq;
        
        for (auto& cord : points) {
            pq.push(cord);
        }
        
        
        while(K--) {
            res.push_back(pq.top());
            pq.pop();
        }
        
        return res;
    }
};