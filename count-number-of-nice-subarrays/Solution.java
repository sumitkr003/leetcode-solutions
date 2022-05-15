// https://leetcode.com/problems/count-number-of-nice-subarrays

class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int count = 0;
        int i=0, j=0;
        int start = 0, end = 0;
        int n = arr.length;
        int ans = 0;
        
        while(i < n && j < n){
            if(arr[i] % 2 == 1){
                count++;
            }
            
            if(count == k){
                j = start;
                while(j <= i){
                    if(arr[j] % 2 == 1){
                        break;
                    }
                    j++;
                }
                
                end = i + 1;
                while(end < n){
                    if(arr[end] % 2 == 1){
                        break;
                    }
                    end ++;
                }
                
                int left = j - start;
                int right = end - i - 1;
                
                // System.out.println(start + " " + j + " " + i + " " + end);
                ans += right + left + right * left + 1;
                
                start = j + 1;
                count --;
            }
            
            i++;
        }
        
        return ans;
    }
}