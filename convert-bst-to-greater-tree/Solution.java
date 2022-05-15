// https://leetcode.com/problems/convert-bst-to-greater-tree

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
    public TreeNode convertBST(TreeNode root) {
        traverseTree(root, 0);
        return root;
    }
    
    public int traverseTree(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        
        if(root.right == null){
            root.val += sum;
        }
        int rightSum = traverseTree(root.right, sum);
        root.val += rightSum;
        int leftSum = traverseTree(root.left, root.val);
        
        return root.left == null ? root.val : leftSum;
        
    }
}