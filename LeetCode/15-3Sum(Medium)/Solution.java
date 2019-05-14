import java.util.Arrays;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * First sort the array and then fix a number.
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            if (nums[i] + nums[j] > 0)
                continue;

            while (j < k) {
                int twoSum = nums[j] + nums[k];
                System.out.println(twoSum);
                if (twoSum == target) {
                    res.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                    ++j;
                    --k;
                    while (j < k && nums[j] == nums[j - 1])
                        ++j;
                    while (j < k && nums[k] == nums[k + 1])
                        --k;
                } else if (twoSum > target) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
        return res;
    }
}