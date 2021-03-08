package treegraphs;

import java.util.HashMap;
import java.util.Map;

class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        // initial 2 cases
        map.put(0,1);
        map.put(1,1);

        return numTrees(n, map);
    }

    // the idea is to use each number i as root node,
    // then the left branch will be what's less than i,
    // the right branch will be what's larger than i.)
    // the total number of distinct structure is their product.
    // thus, sum up the product for all numbers. Use a map to memorize the visited number.
    public int numTrees(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) return map.get(n);

        int sum = 0;
        for (int i=1; i <= n; i++) {
            sum += numTrees(i-1, map) * numTrees(n-i, map);
        }   

        map.put(n, sum);

        return sum;
    }
}