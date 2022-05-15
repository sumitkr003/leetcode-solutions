// https://leetcode.com/problems/binary-tree-inorder-traversal

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
    public List<Integer> arr = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode A) {
        solve(A);
        return arr;
    }
    
    public void solve(TreeNode node){
        if(node == null){
            return;
        }
        
        solve(node.left);
        arr.add(node.val);
        solve(node.right);
    }
}