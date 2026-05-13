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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        solve(root, res);
        return res[0];
    }
    public int solve(TreeNode node, int[] global) {
        if(node == null) return 0;
        int left = solve(node.left, global);
        int right = solve(node.right, global);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        global[0] = Math.max(global[0], node.val + left + right);
        return left>right?node.val+left:node.val+right;
    }
}
