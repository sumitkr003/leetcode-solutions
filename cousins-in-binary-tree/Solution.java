// https://leetcode.com/problems/cousins-in-binary-tree

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
    public boolean isCousins(TreeNode root, int x, int y) {
        return findDepth(root, x) == findDepth(root, y) && findParent(root, x) != findParent(root, y);
    }
    
    public int findDepth(TreeNode root, int val){
        if(root == null){
            return -1;
        }
        
        if(root.val == val){
            return 0;
        }
        int left = findDepth(root.left, val);
        int right = findDepth(root.right, val);
        int d = Math.max(left, right) + 1;
        if(d == 0){
            return -1;
        }
        return d;
    }
    
    public TreeNode findParent(TreeNode root, int val){
        if(root == null){
            return null;
        }
        
        if((root.left != null && root.left.val == val) || (root.right != null && root.right.val == val)){
            return root;
        }
        
        TreeNode left = findParent(root.left, val);
        TreeNode right = findParent(root.right, val);
        
        if(left != null){
            return left;
        }else if(right != null){
            return right;
        }
        
        return null;
    }
}