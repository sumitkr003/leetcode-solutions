// https://leetcode.com/problems/sum-of-left-leaves

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
    public int sumOfLeftLeaves(TreeNode root) {
        return solve(root, false);
    }
    
    public int solve(TreeNode root, Boolean isLeftNode){
        if(root.left == null && root.right == null){
            if(isLeftNode) return root.val;
            return 0;
        }
        
        int left = 0, right = 0;
        if(root.left != null) left = solve(root.left, true);
        if(root.right != null) right = solve(root.right, false);
        
        return left + right;
    }
}