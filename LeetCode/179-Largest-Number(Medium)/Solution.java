/**
 * Very simple solution. The only thing to make clear is comparator.
 * 
 * let's say o1 - o2: o1 is before o2 by default
 * if -1, then the order is ascending, otherwise descending
 *
 * A trick to remember Comparator(o1, o2)
 * 1. The default order is o1, o2.
 * 2. The default formula is o1 - o2, here minus is a generic minus
 * 3. if o1 - o2 give us negaytive, which means the order is ascending
 *    Otherwise it's descending.
 */

class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] stringNums = new String[nums.length];
        
        for(int i = 0; i < nums.length; ++i)
		    stringNums[i] = String.valueOf(nums[i]);
        
        // lambda expression better
        Arrays.sort(stringNums, (String str1, String str2) ->
            (str2 + str1).compareTo(str1 + str2));
//         Arrays.sort(stringNums, new Comparator<String>() {
//             @Override
//             public int compare(String str1, String str2) {
//                 String res1 = str1 + str2;
//                 String res2 = str2 + str1;
                
//                 // if res2 - res1 > 0, str2 should be before str1
//                 // return positive to make an exchange
//                 return res2.compareTo(res1);
//             }
//         });
        
        for (String stringNum : stringNums) {
            sb.append(stringNum);
        }
        if (stringNums[0].charAt(0) == '0') return "0";
        return sb.toString();
    }
}