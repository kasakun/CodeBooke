class Solution {
public:
    bool isStrobogrammatic(string num) {
        unordered_map<char, char> _map{{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        for (int l = 0, r = num.size() - 1; l <= r; l++, r--) {
            if (_map.find(num[l]) == _map.end() || _map[num[l]] != num[r]) {
                return false;
            }
        }
        return true;
    }
};

