// https://leetcode.com/problems/all-elements-in-two-binary-search-trees

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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> pre1 = new ArrayList<>();
        ArrayList<Integer> pre2 = new ArrayList<>();
        
        preOrder(root1, pre1);
        preOrder(root2, pre2);
        
//         for(int val : pre1){
//             System.out.print(val + " ");
//         }
//         System.out.println();
        
//         for(int val : pre2){
//             System.out.print(val + " ");
//         }
//         System.out.println();
        
        int i=0,j=0;
        List<Integer> ans = new ArrayList<>();
        
        while(i < pre1.size() && j < pre2.size()){
            if(pre1.get(i) == pre2.get(j)){
                ans.add(pre1.get(i));
                ans.add(pre1.get(i));
                i++;
                j++;
            }else if(pre1.get(i) < pre2.get(j)){
                ans.add(pre1.get(i));
                i++;
            }else{
                ans.add(pre2.get(j));
                j++;
            }
        }
        
        // System.out.println(i + " " + j);
        if(i != pre1.size()){
            ans = addToArrayList(i, pre1, ans);
        }else{
            ans = addToArrayList(j, pre2, ans);
        }
        
        return ans;
    }
    
    public List<Integer> addToArrayList(int i, ArrayList<Integer> arr, List<Integer> ans){
        // System.out.println(i + " " + arr.size());
        while(i < arr.size()){
            ans.add(arr.get(i));
            i++;
        }
        return ans;
    }
    
    public void preOrder(TreeNode root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        
        preOrder(root.left, arr);
        arr.add(root.val);
        preOrder(root.right, arr);
    }
}