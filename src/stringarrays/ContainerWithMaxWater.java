class ContainerWithMaxWater {
    static int maxArea(int[] height) {
        int a = 0, b = height.length-1;
        int max = 0;
        
        while (a <= b) {
            // the amount of water that can be contained
            // width: b-a
            // height: Math.min(height[a], height[b])
            if (height[a] < height[b]) {
                max = Math.max(max, (b-a) * height[a]);
                a++;
            } else {
                max = Math.max(max, (b-a) * height[b]);
                b--;
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        int[] heights = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println("The result of max area: " +maxArea(heights));
    }
}
