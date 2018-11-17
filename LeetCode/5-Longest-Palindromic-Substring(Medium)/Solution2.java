/**
 * The method is based on DP
 */
class Solution2 {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String res = "";
        Boolean[][] dp = new Boolean[s.length()][s.length()];

        for(int i=s.length()-1; i >= 0; --i){
            for(int j=i; j < s.length(); ++j){
                // if char at i and j is equal
                // 1. j - i <= 2 i.e. a)1,2,1;b)1,1;c)1
                // 2. dp[i + 1] == dp[j - 1]
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if(dp[i][j]){
                    if(maxLen < (j - i + 1)){
                        maxLen = (j - i) + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}