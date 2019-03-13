/**
 * recursive + cache
 */
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '+' ||
                input.charAt(i) == '-' ||
                input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                
                List<Integer> res1 = diffWaysToCompute(part1);
                List<Integer> res2 = diffWaysToCompute(part2);
                
                for (int num1 : res1) {
                    for (int num2 : res2) {
                        int result = 0;
                        
                        switch(input.charAt(i)) {
                            case '+': result = num1 + num2;break;
                            case '-': result = num1 - num2;break;
                            case '*': result = num1 * num2;break;
                        }
                        
                        res.add(result);
                    }
                }
            }
        }
        
        //input only contains numbers
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        
        map.put(input, res);
        return res;
    }
}