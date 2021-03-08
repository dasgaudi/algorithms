package treegraphs;

class MergeTwoBinaryTrees {

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

    TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // edge cases 
        if (root1 == null && root2 == null) return null;
        if (root1 != null && root2 == null) return root1; 
        if (root1 == null && root2 != null) return root2;
        
        TreeNode root = new TreeNode(root1.val+root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        
        return root;
    }

    void printNode(TreeNode root) {
        if (root == null) return;
        if (root != null) System.out.println(root.val);
        printNode(root.left);
        printNode(root.right);
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees ob = new MergeTwoBinaryTrees();
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));

        TreeNode root = ob.mergeTrees(root1, root2);
        ob.printNode(root);       
  
    }
}