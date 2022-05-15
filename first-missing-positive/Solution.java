// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] arr) {
        int i=0, n = arr.length;
        while(i < n){
            int num = arr[i];
            if(num <= 0 || num > n || num == i + 1){
                i++;
                continue;
            }
            
            int temp = arr[num - 1];
            if(temp == num){
                i++;
                continue;
            }
            arr[num - 1] = num;
            arr[i] = temp;
        }
        
        int curr = 1;
        for(i=0;i<n;i++){
            if(arr[i] != curr){
                break;
            }
            curr++;
        }
        
        return curr;
    }
}