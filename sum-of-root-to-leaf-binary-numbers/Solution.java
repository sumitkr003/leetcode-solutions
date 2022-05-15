// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers

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
    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }
    
    public int solve(TreeNode root, int curr){
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return 2 * curr + root.val;
        }
        
        int left = solve(root.left, curr * 2 + root.val);
        int right = solve(root.right, curr * 2 + root.val);
        
        return left + right;
    }
}