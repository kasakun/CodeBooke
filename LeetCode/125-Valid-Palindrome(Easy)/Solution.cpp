class Solution {
private:
    bool isAlpabumeric(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9');
    }
    
    char lowerCase(char c) {
        return ('A' <= c && c <= 'Z') ? (c + 32) : c;
    }
public:
    bool isPalindrome(string s) {
        int start = 0, end = s.size() - 1;
        
        while (start < end) {
            while (start < end && !isAlpabumeric(s[start])) ++start;
            while (start < end && !isAlpabumeric(s[end])) --end;
            
            if (lowerCase(s[start]) != lowerCase(s[end]))
                return false;
            
            ++start;
            --end;
        }
        
        return true;
    }
};

