class Solution {
public:
    bool areSentencesSimilar(vector<string>& words1, vector<string>& words2, vector<vector<string>>& pairs) {
        if (words1.size() != words2.size()) return false;

        unordered_map<string, unordered_set<string>> _map;

        for (auto pair : pairs) {
            _map[pair[0]].insert(pair[1]);
            _map[pair[1]].insert(pair[0]);
        }

        for (int i = 0; i < words1.size(); ++i) {
            auto _set = _map[words1[i]];
            if (words1[i] == words2[i] ||
                _set.find(words2[i]) != _set.end())
                continue;
            else
                return false;
        }
        return true;
    }
};

