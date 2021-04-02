import java.util.Arrays;

class ProductExceptSelf {

    // the idea here is to go through to right side and back to the left side
    // to make sure we multiply every element except for itself
    static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            int product = 1;
            for (int j=0; j<nums.length; j++) {
                if (i == j) continue;
                product *= nums[j];
            }
            result[i] = product;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}
