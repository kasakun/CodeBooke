class Solution {
public:
    int calculateTime(string keyboard, string word) {
        int res = 0, prev = 0;
        int _map[26];

        for(int i = 0; i < keyboard.size(); ++i) {
            _map[keyboard[i] - 'a'] = i;
        }

        for(char & c : word) {
            res += abs(prev - _map[c - 'a']);
            prev = _map[c - 'a'];
        }

        return res;
    }
};

