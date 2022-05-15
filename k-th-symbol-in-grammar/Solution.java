// https://leetcode.com/problems/k-th-symbol-in-grammar

class Solution {
    public int kthGrammar(int n, int k) {
        int arr[] = new int[n];
        int ans[] = new int[n];
        
        while(n > 0){
            arr[n-1] = k;
            k = (k + 1) / 2;
            n--;
        }
        
        n = ans.length;
        for(int i=1;i<n;i++){
            if(ans[i-1] == 0){
                if(arr[i] == 2 * arr[i-1]){
                    ans[i] = 1;
                }else{
                    ans[i] = 0;
                }
            }else{
                if(arr[i] == 2 * arr[i-1]){
                    ans[i] = 0;
                }else{
                    ans[i] = 1;
                }
            }
        }
        
        // for(int val: arr) System.out.print(val + " ");
        // System.out.println();
        // for(int val: ans) System.out.print(val + " ");
        
        return ans[n-1];
    }
}