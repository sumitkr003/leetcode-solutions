// https://leetcode.com/problems/binary-tree-maximum-path-sum

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
        return solve(root)[0];
    }
    
    public int[] solve(TreeNode root){
        if(root == null){
            int temp[] = new int[2];
            temp[0] = Integer.MIN_VALUE;
            temp[1] = 0;
            return temp;
        }
        
        int left[] = solve(root.left);
        int right[] = solve(root.right);
        int ans[] = new int[2];
        ans[0] = root.val;
        if(left[1] > 0){
            ans[0] += left[1];
        }
        
        if(right[1] > 0){
            ans[0] += right[1];
        }
        
        ans[0] = Math.max(ans[0], Math.max(left[0], right[0]));
        ans[1] = root.val;
        
        if(Math.max(left[1], right[1]) > 0){
            ans[1] += Math.max(left[1], right[1]);
        }
        return ans;
    }
}