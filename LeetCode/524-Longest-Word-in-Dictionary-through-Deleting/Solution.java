class Solution {
    private boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        
        for (; i < s.length() && j < word.length(); ++i)
            if (word.charAt(j) == s.charAt(i))
                ++j;
        
        return j == word.length();
    }

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (s1, s2) -> s1.length() != s2.length() ? s2.length() - s1.length() : s1.compareTo(s2));
    
        for (String word : d) {
            if (isSubsequence(word, s))
                return word;
        }

        return "";
    }
}