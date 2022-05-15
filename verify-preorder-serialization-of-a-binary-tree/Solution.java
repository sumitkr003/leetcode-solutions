// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree

class Solution {
    public boolean isValidSerialization(String preorder) {
        String nodes[] = preorder.split(",");
        int lastIndex = traverse(nodes, 0);
        return lastIndex == nodes.length - 1;
    }
    
    public int traverse(String arr[], int index){
        if(index >= arr.length || arr[index].equals("#")){
            return index;
        }
        
        int rightIndex = traverse(arr, index + 1);
        if(rightIndex >= arr.length) return rightIndex;
        int finalIndex = traverse(arr, rightIndex + 1);
        
        return finalIndex;
    }
}