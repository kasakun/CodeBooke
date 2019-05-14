class Solution {
    public int compareVersion(String version1, String version2) {
        int idx1 = 0, idx2 = 0, buffer1 = 0, buffer2 = 0;
        
        while (idx1 < version1.length() && idx2 < version2.length()) {
            buffer1 = 0;buffer2 = 0;
            
            while (idx1 < version1.length() && version1.charAt(idx1) != '.') {
                buffer1 = buffer1*10 + version1.charAt(idx1) - '0';
                ++idx1;
            }
        
            while (idx2 < version2.length() && version2.charAt(idx2) != '.') {
                buffer2 = buffer2*10 + version2.charAt(idx2) - '0';
                ++idx2;
            }
        
            if (buffer1 < buffer2) return -1;
            if (buffer1 > buffer2) return 1;
        
            ++idx1;++idx2;
        }
        
        while (idx1 < version1.length()) {
            buffer1 = 0;
            while (idx1 < version1.length() && version1.charAt(idx1) != '.') {
                buffer1 = buffer1*10 + version1.charAt(idx1) - '0';
                ++idx1;
            }
            
            if (buffer1 > 0) return 1;
            
            ++idx1;
        }
        
        while (idx2 < version2.length()) {
            buffer2 = 0;
            while (idx2 < version2.length() && version2.charAt(idx2) != '.') {
                buffer2 = buffer2*10 + version2.charAt(idx2) - '0';
                ++idx2;
            }
            
            if (buffer2 > 0) return -1;
            
            ++idx2;
        }
        
        return 0;
    }
}