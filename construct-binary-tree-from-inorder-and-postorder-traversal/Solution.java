// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return add(inorder, postorder, 0, n-1, 0, n-1);
    }
    
    public TreeNode add(int inorder[], int postorder[], int i, int j, int x, int y){
        if(i > j){
            return null;
        }else if(i == j){
            return new TreeNode(postorder[y]);
        }
        
        int val = postorder[y];
        int mid = -1;
        for(int k = i;k<=j;k++){
            if(inorder[k] == val){
                mid = k;
                break;
            }
        }
        
        int count = mid - i;
        TreeNode node = new TreeNode(val);
        node.left = add(inorder, postorder, i, mid - 1, x, x + count - 1);
        node.right = add(inorder, postorder, mid + 1, j, x + count, y - 1);
        
        return node; 
    }
}