package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum {

    // recursive solution
    public List<List<Integer>> combinationSum_1(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum_1(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void combinationSum_1(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                combinationSum_1(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // iterative solution
    static List<List<Integer>> combinationSum_2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // dp[t] stores all combinations that add up to t
        List<List<Integer>>[] dp = new ArrayList[target+1];

        for(int t=0; t<=target; t++) {
            dp[t] = new ArrayList();
            List<List<Integer>> combList = new ArrayList();

            for(int j=0; j<candidates.length && candidates[j] <= t; j++) {
                if(candidates[j] == t) {
                    combList.add(Arrays.asList(candidates[j]));
                } else {
                    for(List<Integer> prevlist: dp[t-candidates[j]]) {
                        // here use our dp definition
                        // i thought it makes more sense to compare with the last element
                        // only add to list when the candidates[j] >= the last element
                        // so the list remains ascending order, can prevent duplicate (ex. has [2 3 3], no [3 2 3])
                        // equal is needed since we can choose the same element many times
                        if(candidates[j] >= prevlist.get(prevlist.size()-1)){
                            List temp = new ArrayList(prevlist); // temp is needed since
                            temp.add(candidates[j]); // cannot edit prevlist inside 4eeach looop
                            combList.add(temp);
                        }
                    }
                }
            }
            dp[t] = combList;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum_2(candidates, 7);
        for (List<Integer> combination: result) {
            for(Integer i: combination) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
