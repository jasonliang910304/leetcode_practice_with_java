
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int move = 0;

    private int dfs(TreeNode input) {
        if (input == null)
            return 0;
        int leftCoin = dfs(input.left);
        int rightCoin = dfs(input.right);
        move += Math.abs(leftCoin) + Math.abs(rightCoin);
        return input.val - 1 + leftCoin + rightCoin;
    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }
}
