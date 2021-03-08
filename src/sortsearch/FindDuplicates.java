package sortsearch;

class FindDuplicates {
    // we first can find duplicates with flip-flop 
    // this solution however violates the modification rule
    // if we could think think problem as finding a cycle in linked list
    // we can solve it without modification of the input
    // with O(n^2) time, O(1) space
    int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;      
    } 
}
