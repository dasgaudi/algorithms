package treegraphs;

class FlattenBinaryTreeIntoLinkedList {

    private static TreeNode prev = null;

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

    // the idea here is to post order and change the pointer
    // 6 -> 5 -> 4 -> 3 -> 2 -> 1
    static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
