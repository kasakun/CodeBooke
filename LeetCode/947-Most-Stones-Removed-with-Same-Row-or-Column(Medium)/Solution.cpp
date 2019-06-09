/**
 * Union find
 * 
 * Time O(n^2*logn)
 * 
 * DFS meybe better, basically counting how many independent sets
*/
class Solution {
private:
    // roots[i] = j, j is i's parent
    vector<int> roots;
    
    int getRoot(int stoneId) {
        // not change, represents a root of tree
        if (roots[stoneId] == stoneId)
            return stoneId;
        
        return  getRoot(roots[stoneId]);
    }
public:
    int removeStones(vector<vector<int>>& stones) {
        int size = stones.size();
        roots = vector<int>(size);
        
        int rootCount = 0;
        
        // initialize the roots table
        for (int i = 0; i < size; ++i)
            roots[i] = i;
        
        // connect
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                // check if in the same line
                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1])
                    roots[getRoot(i)] = getRoot(j);
            }
        }
        
        for (int i = 0; i < size; ++i) {
            if (roots[i] == i) ++rootCount;
        }
        
        // in each union set, there must be one element cant be removed
        // so the problem becomes how many independent sets we have here?
        return size - rootCount;
    }
};