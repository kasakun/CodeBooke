/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Constructor initializes an empty nested list.
 *     NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     NestedInteger(int value);
 *
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Set this NestedInteger to hold a single integer.
 *     void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     void add(const NestedInteger &ni);
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */
class Solution {
private:
    void dfs(NestedInteger &nest, vector<int>& res, int depth) {
        if (res.size() < depth + 1) res.resize(depth + 1);

        if (nest.isInteger()) {
            res[depth] += nest.getInteger();
        } else {
            for (auto n : nest.getList())
                dfs(n, res, depth + 1);
        }
    }
public:
    int depthSumInverse(vector<NestedInteger>& nestedList) {
        int sum = 0;
        vector<int> res;

        for (auto nest : nestedList) {
            dfs(nest, res, 0);
        }

        for (int i = res.size() - 1, level = 1; i >= 0; --i, ++level) {
            sum += res[i]*level;
        }

        return sum;
    }
};

