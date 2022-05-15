// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations

class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
        int freq[] = new int[202];
        for(int val : arr){
            if(val < 0){
                freq[101 - (-val)] ++;
            }else{
                freq[101 + val] ++;
            }
        }
        
        for(int j=0;j<freq.length;j++){
            if(freq[j] > 0){
                System.out.println(j + " " + freq[j]);
            }
        }
        
        int i=0;
        while(k > 0 && i < 101){
            if(freq[i] > 0){
                int min = Math.min(freq[i], k);
                freq[i] -= min;
                k -= min;
                freq[202 - i] += min;
            }else{
                i++;
            }
        }
        
        System.out.println("-----");
        for(int j=0;j<freq.length;j++){
            if(freq[j] > 0){
                System.out.println(j + " " + freq[j]);
            }
        }
        
        int min = 0;
        if(k > 0){
            while(i < 202){
                if(freq[i] > 0){
                    min = i - 101;
                    break;
                }
                i++;
            }
        }
        
        System.out.println(min);
        int ans = 0;
        for(int j=0;j<202;j++){
            if(freq[j] > 0){
                if(j > 0){
                    ans += freq[j] * (j-101);
                }else{
                    ans += freq[j] * (j-100);
                }
            }
        }
        
        System.out.println(k + " " + ans);
        if(k > 0 && k % 2 == 1){
            ans -= 2 * min;
        }
        
        return ans;
    }
}