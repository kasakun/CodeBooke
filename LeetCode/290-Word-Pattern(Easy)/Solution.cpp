class Solution {
public:
    bool wordPattern(string pattern, string str) {
        int len = pattern.size();
		unordered_map<char, int> pm;
		unordered_map<string, int> sm;

		stringstream ss(str);

		string temp;
		for (int i = 0; i < len; i++) {
			if (ss.eof())
				return false;

			ss >> temp;
			
			if (pm.find(pattern[i]) == pm.end()) {
				// new char in pattern
				pm[pattern[i]] = i + 1;

				if (sm.find(temp) != sm.end())
					return false;

				sm[temp] = i + 1;
			}
			else if (pm[pattern[i]] != sm[temp])
				return false;
		}
                if(!ss.eof()) 
                    return false;
		return true;
    }
};

