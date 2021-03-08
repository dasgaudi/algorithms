package stringarrays;

class FindMissingPositive {

    // missing positive is in range [1, n]
    static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // ignore all numbers <= 0 or > n, useless elements
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        // edge case: there is no missing elements
        return nums.length + 1;
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums_1 = new int[] {0, 1, 2};
        int[] nums_2 = new int[] {7, 8, 9, 11, 12};
        int[] nums_3 = new int[] {3, 4, -1, 1};
        assert firstMissingPositive(nums_1) == 3;
        assert firstMissingPositive(nums_2) == 1;
        assert firstMissingPositive(nums_3) == 2;
    }
}
