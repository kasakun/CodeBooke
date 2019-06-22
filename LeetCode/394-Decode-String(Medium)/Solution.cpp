class Solution {
public:
    string decodeString(string s) {
        if (s.size() <= 3) return s;
        stack<string> strs;
        stack<int> counts;
        
        counts.push(1);
        
        strs.push("");
        string res="";
        int index = 0;
        
        while(index < s.size()){
            if (isdigit(s[index])){
                int num = 0;
                while(isdigit(s[index])){
                    num = num*10 + s[index] - '0';
                    ++index;
                }
                counts.push(num);
            }else if (isalpha(s[index])){
                int j = index;
                while(j < s.size() && isalpha(s[j])) ++j;
                string temp = s.substr(index, j - index);
                index = j;
                strs.top() += temp;
            }else if (s[index] == '['){
                ++index;
                strs.push("");
            }else if (s[index] == ']'){
                ++index;
                string temp = strs.top();
                strs.pop();
                for (int index = 0;index < counts.top(); ++index)
                    strs.top() += temp;

                counts.pop();
            }
        }
        return strs.top();
    }
};

