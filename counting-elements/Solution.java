// https://leetcode.com/problems/counting-elements

class Solution {
    public int countElements(int[] arr) {
        int ans = 0;
        int freq[] = new int[1002];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]] ++;
        }
        
        for(int i=0;i<freq.length;i++){
            if(freq[i] > 0 && freq[i+1] > 0){
                ans += freq[i];
            }
        }
        
        return ans;
    }
}