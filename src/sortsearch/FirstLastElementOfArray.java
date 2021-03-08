class FindFirstLastElementOfArray {
    
    int[] searchRange1(int[] nums, int target) {
        int[] results = new int[] {-1,-1};
        int i,j;
        
        // edge case 
        if (nums.length == 0 || nums == null) {
            return results;
        }
        
        for (i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                j=i;
                while (nums[j] == target && nums[j+1] == target && j+1 < nums.length) j++;
                results[0] = i;
                results[1] = j;
                return results;
            }
        }
        
        return results;
    }

    // the idea is to run 2 different binary searches 
    // to find the furthest left index 
    // -> when found the target, move left
    // to find the furthest right index 
    // -> when found the target, move right
    int[] searchRange2(int[] nums, int target) {
        return new int[] { binarySearchFirst(nums, target), binarySearchLast(nums, target)};
    }

    int binarySearchFirst(int[] nums, int target) {
        // default value
        int index = -1;
        int low = 0, high = nums.length;
        int mid = low + (high-low)/2;
        
        while (low <= high) {
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    int binarySearchLast(int[] nums, int target) {
        // default value
        int index = -1;
        int low = 0, high = nums.length;
        int mid = low + (high-low)/2;
        
        while (low <= high) {
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }
}