// https://leetcode.com/problems/recover-binary-search-tree

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
    public int idx = 0;
    
    public void recoverTree(TreeNode root) {
        recover(root);
        
        if(arr.size() < 2){
            return;
        }
        
        int i = 0, j = 0, n = arr.size();
        
        for(int k=1;k<n;k++){
            if(arr.get(k) < arr.get(k-1)){
                j = k;
            }
        }
        
        for(int k=0;k<n-1;k++){
            if(arr.get(k+1) < arr.get(k)){
                i = k;
                break;
            }
        }
        
        System.out.println(arr.get(i) + " " + arr.get(j));
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
        
        set(root);
    }
    
    public void recover(TreeNode node){
        if(node == null){
            return;
        }
        
        recover(node.left);
        arr.add(node.val);
        recover(node.right);
    }
    
    public void set(TreeNode node){
        if(node == null){
            return;
        }
        
        set(node.left);
        node.val = arr.get(idx);
        idx ++;
        set(node.right);
    }
}