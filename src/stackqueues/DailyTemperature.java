
import java.util.Stack;

class DailyTemperature {

    int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        // set default to 0
        int[] results = new int[T.length];

        for (int i=0; i<T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                results[index] = i - index;
            }
            stack.push(i);
        }

        return results;
    }
}
