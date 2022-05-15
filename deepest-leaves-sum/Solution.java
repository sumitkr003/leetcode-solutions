// https://leetcode.com/problems/deepest-leaves-sum

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
    public int deepestLeavesSum(TreeNode root) {
        return traverse(root, 0, findDepth(root, 0));
    }
    
    public int findDepth(TreeNode root, int depth){
        if(root == null) return depth - 1;
        
        return Math.max(findDepth(root.left, depth + 1), findDepth(root.right, depth + 1));
    }
    
    public int traverse(TreeNode root,int depth, int maxDepth){
        if(root == null) return 0;
        
        if(depth == maxDepth) return root.val;
        return traverse(root.left, depth + 1, maxDepth) + traverse(root.right, depth + 1, maxDepth);
    }
}