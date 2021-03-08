package sortsearch;

class QuickSort {
    static int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        int temp;
        int pivot = nums[left + (right - left)/2];

        while (i<=j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;

            if (i<=j) {
                // swap
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j--;
            }
        }

        // elements before i will be smaller than pivot
        // elements after i will be larger than pivot
        return i;
    }

    static void quickSort(int[] nums, int left, int right) {
        int index = partition(nums, left, right);
        if (left < index-1) {
            quickSort(nums, left, index-1);
        }
        if (index < right) {
            quickSort(nums, index, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 12, 5, 26, 7, 14, 3, 7, 2};
        quickSort(nums, 0, nums.length-1);
    }
}
