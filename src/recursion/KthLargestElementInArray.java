package recursion;

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargestElementInArray {
    static int findKthLargest_1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    static int findKthLargest_2(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

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
                // move to next elements
                i++;
                j--;
            }
        }

        // elements before i will be smaller than pivot
        // elements after i will be larger than pivot
        return i;
    }

    // quick select
    static int findKthLargest_3(int[] nums, int k) {
        k = nums.length - k;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int index = partition(nums, low, high);
            if (index == k) {
                break;
            } else if (index > k) {
                high = index - 1;
            } else {
                low = index + 1;
            }
        }

        return nums[k];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
        int k = 4;

        System.out.println("The result of 1: "+findKthLargest_1(nums, k));
        System.out.println("The result of 2: "+findKthLargest_2(nums, k));
        System.out.println("The result of 3: "+findKthLargest_3(nums, k));
    }

}
