class Solution {
public:
    vector<vector<int>> highFive(vector<vector<int>>& items) {
        vector<vector<int>> res;
        vector<multiset<int>> scores(1001);

        for (auto item : items) {
            scores[item[0]].insert(item[1]);

            if (scores[item[0]].size() > 5)
                scores[item[0]].erase(scores[item[0]].begin());
        }

        for (auto score : scores)  {
            if (score.size()  == 0) continue;

            int sum =  0;

            for (auto it = score.begin(); it != score.end(); ++it)
                sum += *it;
            res.push_back({res.size() + 1, sum/5});
        }

        return res;
    }
};

