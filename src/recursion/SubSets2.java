package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubSets2 {

    static List<List<Integer>> subsets_2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsets_2(nums, 0, new ArrayList<>(), result);
        return result;
    }

    static void subsets_2(int[] nums, int pos, List<Integer> path, List<List<Integer>> result) {
        if(pos <= nums.length) result.add(new ArrayList<>(path));

        for(int i=pos; i<nums.length; i++) {
            if(i > pos && nums[i] == nums[i-1]) continue;   // avoid duplicates
            path.add(nums[i]);
            subsets_2(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2};
        List<List<Integer>> results = subsets_2(nums);
        for(List<Integer> result: results) {
            for(Integer element: result) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
