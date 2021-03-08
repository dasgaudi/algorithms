package sortsearch;

import java.util.Arrays;

class BucketSort {

    static int[] sort(int[] nums, int max) {
        int[] buckets = new int[max+1];
        int[] sorted_nums = new int[nums.length];

        for (int num : nums) {
            buckets[num]++;
        }

        int pos=0;
        for(int i=0; i<buckets.length; i++) {
            for(int j=0; j<buckets[i]; j++) {
                sorted_nums[pos++] = i;
            }
        }
        return sorted_nums;
    }

    static int max(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 6, 1, 7, 2};
        System.out.println("The result of bucket sort: "+ Arrays.toString(sort(nums, max(nums))));
    }
}
