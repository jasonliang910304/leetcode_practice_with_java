/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == 0) return false;
        else if (root == 1) return true;
        else if (root == 2) return evaluateTree(root.left) || evaluateTree(root.right);
        else if (root == 3) return evaluateTree(root.left) && evaluateTree(root.right);
    }
}
