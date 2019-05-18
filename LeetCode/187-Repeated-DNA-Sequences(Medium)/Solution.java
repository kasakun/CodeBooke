class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        
        for (int i = 0; i + 9 < s.length(); ++i) {
            String str = s.substring(i, i + 10);
            
            if (seen.contains(str))
                repeated.add(str);
            else
                seen.add(str);
        }
        
        return new ArrayList<String>(repeated);
    }
}