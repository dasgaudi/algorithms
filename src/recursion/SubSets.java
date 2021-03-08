package recursion;

import java.util.ArrayList;
import java.util.List;

class SubSets {
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets_1(nums, 0, new ArrayList<>(), result);
        return result;
    }


    static void subsets_1(int[] nums, int pos, List<Integer> path, List<List<Integer>> result) {
        if (pos == nums.length) {
            result.add(new ArrayList<>(path));
            return ;
        }

        List<Integer> pathWithCurrent = new ArrayList<>(path);
        pathWithCurrent.add(nums[pos]);

        // exclude the current path
        subsets_1(nums, pos+1, path, result);
        // include the current path
        subsets_1(nums, pos+1, pathWithCurrent, result);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> results = subsets(nums);
        for(List<Integer> result: results) {
            for(Integer element: result) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
