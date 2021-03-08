package treegraphs;

import java.util.ArrayList;
import java.util.List;

class UniqueBinarySearchTrees2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        
        List<TreeNode> left, right;
        for (int i=start; i<=end; i++) {
            left = generateTrees(start, i-1);
            right = generateTrees(i+1,end);
        
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode root = new TreeNode(i); 
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }    
        }
        
        return list;
    }

    static void printNode(TreeNode root) {
        if (root == null) return;
        if (root != null) System.out.print(root.val + " ");
        printNode(root.left);
        printNode(root.right);
    }


    public static void main(String[] args) {
        List<TreeNode> results = generateTrees(3);

        for(TreeNode result: results) {
            printNode(result);
            System.out.println("");
        }
    }
}
