// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(root == p || root == q) return root;
        
        TreeNode pNode = lowestCommonAncestor(root.left, p, q);
        TreeNode qNode = lowestCommonAncestor(root.right, p, q);
        
        if(pNode != null && qNode != null) return root;
        else if(pNode != null) return pNode;
        else return qNode;
    }
}