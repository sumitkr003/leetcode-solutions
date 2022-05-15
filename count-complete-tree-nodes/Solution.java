// https://leetcode.com/problems/count-complete-tree-nodes

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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        
        if(leftDepth == rightDepth) return leftDepth == 1 ? 1 : (1 << leftDepth) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int leftDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + leftDepth(root.left);
    }
    
    public int rightDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + rightDepth(root.right);
    }
}