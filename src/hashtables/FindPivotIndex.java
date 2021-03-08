package hashtables;

class FindPivotIndex {

    // brute force
    static int pivotIndex_1(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int leftSum = 0, rightSum = 0;

            for (int j=0; j<i; j++) leftSum += nums[j];
            for (int k=i+1; k<nums.length; k++) rightSum += nums[k];
            if (leftSum == rightSum) return i;

        }
        return -1;
    }

    // the idea here is that the sum * 2 (left, right) + the current number, which is pivot index, will be equal to total
    static int pivotIndex_2(int[] nums) {
        int total = 0, sum = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 == total - nums[i]) return i;
            sum += nums[i];
        }
        return -1;
    }
}
