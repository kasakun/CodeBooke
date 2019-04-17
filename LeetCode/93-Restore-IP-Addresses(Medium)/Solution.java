/**
 * dfs
 */
class Solution {
    private boolean isValidSubAddress(String s) {
        if (s.length() > 3 || s.charAt(0) == '0' && s.length() > 1) return false;
        if (s.length() < 3) return true;
        
        int num = Integer.parseInt(s);

        return num < 256;
    }

    private void dfs(String s, String sb, int start, int count, List<String> res) {
        if (count > 4) return;
        if (count == 4 && start == s.length()) {
            res.add(sb);
            return;
        }

        for (int i = start + 1; i <= start + 4 && i <= s.length(); ++i) {
            String value = s.substring(start, i);
            if (isValidSubAddress(value)) {
                if (start == 0) {
                    dfs(s, value, i, count + 1, res);
                }
                else {
                    dfs(s, sb + "." + value, i, count + 1, res);
                }
            }
        }
        
        return;
    }

    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        List<String> res = new LinkedList<>();
        if (length > 12 || length < 4) return res;
        
        dfs(s, "", 0, 0, res);

        return res;
    }
}