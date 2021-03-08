package treegraphs;

import java.util.LinkedList;
import java.util.Queue;

class InvertTree {

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

    // recursive solution, bound to stack
    static TreeNode invertTree_1(TreeNode root) {
        if (root == null) {
            return null;
        }

        final TreeNode left = root.left;
        final TreeNode right = root.right;

        root.left = invertTree_1(right);
        root.right = invertTree_1(left);

        return root;
    }

    // iterative solution
    static TreeNode invertTree_2(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode n = queue.poll();
            TreeNode left = n.left;
            n.left = n.right;
            n.right = left;

            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }

        return root;
    }
}
