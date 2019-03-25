class Solution {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        int res = 0;
        for (int i = 0; i < words.length; ++i) {
        for (int j = 0; j < words[i].length(); ++j)
            mask[i] |= 1 << (words[i].charAt(j) - 'a');
        for (int j = 0; j < i; ++j)
            if ((mask[i] & mask[j]) == 0)
                res = Math.max(res, words[i].length() * words[j].length());
    }
        return res;
    }
}