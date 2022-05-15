// https://leetcode.com/problems/majority-element

class Solution {
    public int majorityElement(int[] arr) {
        int num = arr[0];
        int count = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == num){
                count ++;
            }else{
                count --;
            }
            
            if(count == 0){
                num = arr[i];
                count = 1;
            }
        }
        
        return num;
    }
}