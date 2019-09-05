class Solution {
private:
    vector<string> helper(int remain, int n) {
        if (remain == 0) return vector<string>({""});
        if (remain == 1) return vector<string>({"0", "1", "8"});

        vector<string> res;
        vector<string> tmp = helper(remain - 2, n);

        for (int i = 0; i < tmp.size(); ++i) {
            if (remain != n) res.push_back("0" + tmp[i] + "0");
            res.push_back("1" + tmp[i] + "1");
            res.push_back("6" + tmp[i] + "9");
            res.push_back("8" + tmp[i] + "8");
            res.push_back("9" + tmp[i] + "6");
        }

        return res;
    }
public:
    vector<string> findStrobogrammatic(int n) {
        return helper(n, n);
    }
};

