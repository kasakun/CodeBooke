class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {       
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int aNum : A)
            for (int bNum : B)
                map.put(aNum + bNum, map.getOrDefault(aNum + bNum, 0) + 1);

        for (int cNum : C)
            for (int dNum : D)
                count += map.getOrDefault(-cNum - dNum, 0);
        
        return count;
    }
}