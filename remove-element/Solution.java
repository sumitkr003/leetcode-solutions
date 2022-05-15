// https://leetcode.com/problems/remove-element

class Solution {
    public int removeElement(int[] arr, int val) {
        int i=0,j=arr.length - 1;
        while(i < j){
            if(arr[i] == val && arr[j] != val){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }else if(arr[i] == val || arr[j] == val){
                j--;
            }else{
                i++;
            }
        }
        
        for(i=0;i<arr.length;i++){
            if(arr[i] == val) return i;
        }
        return arr.length;
    }
}