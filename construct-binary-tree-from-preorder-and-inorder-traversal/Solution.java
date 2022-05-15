// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return add(inorder, preorder, 0, n-1, 0, n-1);
    }
    
    public TreeNode add(int inorder[], int preorder[], int i, int j, int x, int y){
        if(i > j){
            return null;
        }else if(i == j){
            return new TreeNode(preorder[x]);
        }
        
        int val = preorder[x];
        int mid = -1;
        for(int k = i;k<=j;k++){
            if(inorder[k] == val){
                mid = k;
                break;
            }
        }
        
        int count = mid - i;
        TreeNode node = new TreeNode(val);
        node.left = add(inorder, preorder, i, mid - 1, x + 1, x + count);
        node.right = add(inorder, preorder, mid + 1, j, x + count + 1, y);
        
        return node; 
    }
}