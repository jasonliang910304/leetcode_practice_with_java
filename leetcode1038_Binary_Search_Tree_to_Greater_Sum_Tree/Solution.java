
public class Solution {
    public class TreeNode {
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
    public TreeNode bstToGst(TreeNode root){
        int[] currSum = new int[1];
        helper(root, currSum);
        return root;
    }
    
    private void helper(TreeNode node, int[] currSum){
        if(node == null) return;

        helper(node.right, currSum);
        node.val += currSum[0];
        currSum[0] = node.val;
        helper(node.left, currSum);
    }
}
