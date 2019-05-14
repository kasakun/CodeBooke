class Solution {
    private String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    private List<String> res = new ArrayList<>();
    
    private void findCombinations(String digits, int index, StringBuilder buffer) {
        if (digits.length() == index) {
            res.add(buffer.toString());
            return;
        }
        
        // -2 here is map '2-9' to '0-7'
        String temp = map[digits.charAt(index) - '0' - 2];
        for (int i = 0; i < temp.length(); ++i) {
            buffer.append(temp.charAt(i));
            findCombinations(digits, index + 1, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        StringBuilder buffer = new StringBuilder();
        
        findCombinations(digits, 0, buffer);
        
        return res;
    }
}