// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int ans = 10000 + target;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int j = i + 1,k = arr.length - 1;
            int num = target - arr[i];
            while(j < k){
                if(Math.abs(ans - target) > Math.abs(arr[i] + arr[j] + arr[k] - target)) ans = arr[i] + arr[j] + arr[k];
                if(arr[j] + arr[k] == num){
                    return target;
                }else if(arr[j] + arr[k] > num){
                    k--;
                }else{
                    j++;
                }
                
            }
        }
        
        return ans;
    }
}