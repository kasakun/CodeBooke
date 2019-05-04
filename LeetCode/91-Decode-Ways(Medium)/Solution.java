class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if (length == 1 && !s.equals("0")) return 1;
        
        int[] dp = new int[length + 1];
        
        if(s.charAt(0) != '0') {dp[0] = dp[1] = 1;}
        
        for (int i = 2; i < dp.length; ++i) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26)
                dp[i] += dp[i - 2];
        }
        
        return dp[length];
    }
}