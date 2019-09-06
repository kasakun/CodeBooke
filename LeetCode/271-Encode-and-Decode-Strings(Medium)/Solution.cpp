class Codec {
public:

    // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        string res = "";

        for (auto& str: strs) {
            int len = str.size();
            res += to_string(len) + "@" + str;
        }

        return res;
    }

    // Decodes a single string to a list of strings.
    vector<string> decode(string s) {
        int i = 0;
        vector<string> res;

        while (i < s.size()) {
            int index = s.find_first_of('@', i);
            int len = stoi(s.substr(i, index - i));

            i = index + 1;
            res.push_back(s.substr(i, len));

            i += len;
        }

        return res;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.decode(codec.encode(strs));
