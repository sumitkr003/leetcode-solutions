// https://leetcode.com/problems/validate-binary-search-tree

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
    public ArrayList<Integer> arr = new ArrayList<>();
    
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return solve();
    }
    
    public boolean solve(){
        for(int i=1;i<arr.size();i++){
            if(arr.get(i) <= arr.get(i-1)){
                return false;
            }
        }
        return true;
    }
    
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
}