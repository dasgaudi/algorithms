
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeInOrderTraverse {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    // iterative solution
    List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            result.add(n.val);
            TreeNode right = n.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }

        return result;
    }

    // recursive solution
    List<Integer> inorderTraversalRecursion(TreeNode root) {
        // edge case
        if (root == null) return new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        traverse(root, results);
        return results;
    }

    void traverse(TreeNode root, List<Integer> results) {
        if (root == null) return;

        traverse(root.left, results);
        results.add(root.val);
        traverse(root.right, results);
    }
}

