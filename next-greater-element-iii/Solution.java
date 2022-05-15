// https://leetcode.com/problems/next-greater-element-iii

class Solution {
    public int nextGreaterElement(int num) {
        int n = (num + "").length();
        int arr[] = new int[n];
        for(int i=n-1;i>-1;i--){
            arr[i] = num % 10;
            num /= 10;
        }
        
        int i = n-2;
        while(i >= 0){
            int j = i + 1;
            int k = -1;
            while(j < n){
                if(arr[j] > arr[i]){
                    if(k == -1 || arr[j] < arr[k]){
                        k = j;
                    }
                }
                j++;
            }
            
            if(k != -1){
                // System.out.println(i + " " + k);
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                
                Arrays.sort(arr, i+1, n);
                
                long ans = 0;
                for(k=0;k<n;k++){
                    ans = ans * 10 + (long)arr[k];
                }
                    
                if(ans <= Integer.MAX_VALUE){
                    return (int)ans;   
                }
            }
            i--;
        }
        
        return -1;
    }
}