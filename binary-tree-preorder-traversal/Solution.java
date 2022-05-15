// https://leetcode.com/problems/binary-tree-preorder-traversal

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
    public List<Integer> ans = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode A) {
        solve(A);
        return ans;
    }
    
    public void solve(TreeNode node){
        if(node == null){
            return;
        }
        
        ans.add(node.val);
        solve(node.left);
        solve(node.right);
    }
}