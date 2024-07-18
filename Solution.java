public class Solution {
    public int countPairs(TreeNode root, int distance) {
        return DFS(root, distance)[11];
    }
    
    private int[] DFS(TreeNode node, int distance) {
        if (node == null) {
            return new int[12];
        }
        else if (node.left == null && node.right == null) {
            int[] current = new int[12];
            current[0] = 1;
            return current;
        }
        int[] left = DFS(node.left, distance);
        int[] right = DFS(node.right, distance);

        int[] current = new int[12];
        for (int i = 0; i < 10; i++) {
            current[i + 1] += left[i] + right[i];
        }
        current[11] += left[11] + right[11];

        for (int i = 0; i <= distance; i++) {
            for (int j = 0; j <= distance; j++) {
                if(2 + i + j <= distance) {
                    current[11] += left[i] * right[j];

                }
            }
        }

        return current;
    }
}
