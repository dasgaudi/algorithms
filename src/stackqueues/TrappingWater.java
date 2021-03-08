
import java.util.Stack;

public class TrappingWater {

    // the idea here is the fact that water can be trapped only there is an increasing sequence in heights
    static int trapWaters_1(int[] heights) {
        int totalWater = 0;
        Stack<Integer> stack = new Stack<>();

        for (int right=0; right<heights.length; right++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[right]) {
                int bottom = stack.pop();
                // there is no way to trap water
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                totalWater += (right-left-1) * (Math.min(heights[right], heights[left]) - heights[bottom]);
            }
            stack.push(right);
        }

        return totalWater;
    }

    static int trapWaters_2(int[] heights) {
        int a = 0, b = heights.length-1;
        int leftWall = 0, rightWall = 0;
        int totalWater = 0;

        while (a<=b) {
            leftWall = Math.max(leftWall, heights[a]);
            rightWall = Math.max(rightWall, heights[b]);

            if (leftWall < rightWall) {
                totalWater += leftWall - heights[a];
                a++;
            } else {
                totalWater += rightWall - heights[b];
                b--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] heights = new int[] {4,2,0,3,2,5};
        System.out.println("The result of trap water: "+trapWaters_1(heights));
        System.out.println("The result of trap water: "+trapWaters_2(heights));
    }
}
