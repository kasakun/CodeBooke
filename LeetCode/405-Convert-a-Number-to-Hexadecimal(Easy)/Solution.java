class Solution {
    private char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    
    public String toHex(int num) {
        if (num == 0) return "0";
        int hex = 0;
        String res = "";
        
        while (num != 0) {
            res = map[15 & num] + res;
            
            num = (num >>> 4);
        }
        
        return res;
    }
}