// https://leetcode.com/problems/house-robber-iii

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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int val[] = solve(root);
        return Math.max(val[0], val[1]);
    }
    
    public int[] solve(TreeNode root){
        if(root == null) return new int[]{0,0};
        
        int left[] = solve(root.left);
        int right[] = solve(root.right);
        
        int temp = root.val + Math.max(left[0] - (root.left == null ? 0 : root.left.val),left[1]) + Math.max(right[0] - (root.right == null ? 0 : root.right.val),right[1]);
        return new int[]{temp, Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
    }
}