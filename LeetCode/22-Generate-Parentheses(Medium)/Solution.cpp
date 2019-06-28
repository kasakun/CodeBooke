/**
 * DFS
 */
class Solution {
private:
    int right = 0;
    void dfs(vector<string>& res, string str, int n, int k) {
        if (k == 0 && right == 0) {
            cout << str << endl;
            res.push_back(str);
            return;
        }

        if (k > 0) {
            ++right;
            dfs(res, str + "(", n, k - 1);
            --right;
        }

        if (right > 0) {
            --right;
            dfs(res, str + ")", n, k);
            ++right;
        }
    }
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;

        dfs(res, "", n, n);

        return res;
    }
};

