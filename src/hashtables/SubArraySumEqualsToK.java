package hashtables;

import java.util.HashMap;
import java.util.Map;

class SubArraySumEqualsToK {

    // SUM[i, j]. we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum=0, result=0;
        // number of cases that sum to 0 = '1'
        map.put(0,1);
        for (int num: nums) {
            sum += num;
            if (map.containsKey(sum-k)) result+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}
