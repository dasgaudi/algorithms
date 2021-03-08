package treegraphs;

import java.util.LinkedList;
import java.util.Queue;

class CousinsInBinaryTree {

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

    static class Wrapper {
        int depth;
        TreeNode parent;

        public Wrapper() {
            this.depth = 0;
            this.parent = null;
        }

        public Wrapper(int depth, TreeNode parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    // equal depth
    // different parents
    static boolean isCousins_1(TreeNode root, int x, int y) {
        Wrapper result1 = new Wrapper(0, root);
        Wrapper result2 = new Wrapper(0, root);

        depthAndParent(root, root, result1, x, 0);
        depthAndParent(root, root, result2, y, 0);

        return result1.depth == result2.depth && result1.parent != result2.parent;

    }

    static void depthAndParent(TreeNode parent, TreeNode root, Wrapper result, int target, int k) {
        if (root == null) return ;

        if (root.val == target) {
            result.depth = k;
            result.parent = parent;
            return;
        }

        depthAndParent(root, root.left, result, target, k+1);
        depthAndParent(root, root.right, result, target, k+1);
    }

    // iterative solution
    static boolean isCousins_2(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAexist = false;
            boolean isBexist = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) isAexist = true;
                if (cur.val == y) isBexist = true;

                // case of both nodes having the same parent node
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y) {
                        return false;
                    }
                    if (cur.left.val == y && cur.right.val == x) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (isAexist && isBexist)  return true;
        }
        return false;
    }
}
