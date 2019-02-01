class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1, n = b.length() - 1, c = 0;
        StringBuilder res = new StringBuilder();
        
        for (; m >= 0 || n >= 0; --m, --n) {
            int sum = c;
            if (m >= 0) sum += a.charAt(m) - '0';
            if (n >= 0) sum += b.charAt(n) - '0';
            
            res.append(sum%2);
            c = sum/2;
        }
        
        if (c == 1)
            res.append(1);
        
        return res.reverse().toString();
    }
}