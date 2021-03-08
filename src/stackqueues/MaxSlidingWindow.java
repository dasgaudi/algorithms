
import java.util.ArrayDeque;
import java.util.Deque;

class MaxSlidingWindow {

    // the idea is to associate sliding window problems with deque
    // only keep the promising elements
    // that can be potentially max values in [i-k+1, i] or any subsequent window
    int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
			return new int[0];
		}
		int n = nums.length;
		int[] results = new int[n-k+1];
		int index = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				results[index++] = nums[q.peek()];
			}
		}
		return results;
    }
}