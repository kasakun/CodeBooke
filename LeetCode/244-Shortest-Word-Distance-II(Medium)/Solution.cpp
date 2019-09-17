class WordDistance {
private:
    unordered_map<string, vector<int>> _map;
public:
    WordDistance(vector<string>& words) {
        for (int i = 0; i < words.size(); ++i) {
            _map[words[i]].push_back(i);
        }
    }

    int shortest(string word1, string word2) {
        int index1 = 0, index2 = 0, res = INT_MAX;
        auto it1 = _map[word1], it2 = _map[word2];

        while (index1 < it1.size() && index2 < it2.size()) {
            res = min(res, abs(it1[index1] - it2[index2]));

            if (it1[index1] < it2[index2])
                ++index1;
            else
                ++index2;

        }

        return res;
    }
};

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance* obj = new WordDistance(words);
 * int param_1 = obj->shortest(word1,word2);
 */

