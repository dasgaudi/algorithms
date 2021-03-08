
import java.util.ArrayList;
import java.util.List;

class BinaryTreeRightView {
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    // the idea is to think each depth, we select only one node
    // if right sub tree exist, pick the right one
    // otherwise pick the left one
    // check it is weather added or not with the size of results on each depth
    // e.g) depth = 2, the result size should be 2
    List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        traverse(0, root, result);
        
        return result;
    }
    
    void traverse(int depth, TreeNode root, List<Integer> result) {
        if (root == null) return;
        
        if (depth == result.size()) {
            result.add(root.val);
        }
        
        traverse(depth+1, root.right, result);
        traverse(depth+1, root.left, result);
    }
}
