/** 
 * The idea is expand from the middle
 */
class Solution1 {
    String res = "";
    private void expandSearch(String s, int i, int j){
        while(i >=0 && j < s.length() &&
              i <= j && s.charAt(i) == s.charAt(j)){
            --i;
            ++j;
        }

        if(res.length() < (j-1-(i+1)+1))
            res = s.substring(i+1, j);
    }

    public String longestPalindrome(String s) {
        for(int i=0; i < s.length(); i++){
            expandSearch(s, i, i);   //odd
            expandSearch(s, i, i+1); //even
        }
        return res;
    }
}