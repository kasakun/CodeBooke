class Solution {
     private boolean isIPv4(String IP) {
        int count = 0;
        for (char ch : IP.toCharArray())
            if (ch == '.')
                ++count;
        
        // bad case: 1.1.1.1.
        if (count != 3) return false;

        // bad case: 1.0.1.
        String[] fields = IP.split("\\.");
        if (fields.length != 4) return false;

        for (String field : fields) {
            if (field.isEmpty() || field.length() > 3)
                return false;

            int sz = field.length();
            for (int i = 0; i < sz; ++i)
                if (!Character.isDigit(field.charAt(i)))
                    return false;

            // bad case: 01.01.01.01
            int num = Integer.valueOf(field);
            if (!String.valueOf(num).equals(field) || num < 0 || num > 255) return false;
        }

        return true;
    }

    private boolean isIPv6(String IP) {
        int count = 0;
        for (char ch : IP.toCharArray())
            if (ch == ':')
                count++;

        if (count != 7) return false;

        String[] fields = IP.split(":");
        if (fields.length != 8) return false;

        for (String field : fields) {
            if (field.isEmpty() || field.length() > 4) return false;

            int sz = field.length();
            for (int i = 0; i < sz; ++i)
                if (!Character.isDigit(field.charAt(i)) && (field.charAt(i) < 'A' || field.charAt(i) > 'F')) 
                    return false;
        }

        return true;
    }

    public String validIPAddress(String IP) {
        if (isIPv4(IP)) return "IPv4";
        if (isIPv6(IP.toUpperCase())) return "IPv6";
        return "Neither";
    }
}