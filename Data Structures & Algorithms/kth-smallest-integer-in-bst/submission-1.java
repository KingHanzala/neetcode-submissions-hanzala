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
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[2];
        inorder(root, k, res);
        return res[1];
    }

    public void inorder(TreeNode node, int k, int[] cnt){
        if(node == null || cnt[0] >= k) return;
        inorder(node.left, k, cnt);
        cnt[0]++;
        if(cnt[0] == k){
            cnt[1] = node.val;
        }
        inorder(node.right, k, cnt);
    }
}
