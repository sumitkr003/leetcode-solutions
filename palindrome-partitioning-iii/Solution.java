// https://leetcode.com/problems/palindrome-partitioning-iii

class Solution {
    public int palindromePartition(String s, int x) {
        char arr[] = s.toCharArray();
        int n = arr.length;
        int dp[][] = new int[x][n];
        
        for(int i=1;i<n;i++){
            dp[0][i] = palindrome(arr, 0, i);
        }
        
        for(int i=1;i<x;i++){
            for(int j=i;j<n;j++){
                int val = Integer.MAX_VALUE;
                for(int k=j;k>=i;k--){
                    val = Math.min(val, palindrome(arr, k, j) + dp[i-1][k-1]);
                }
                dp[i][j] = val;
            }
        }
        
        return dp[x-1][n-1];
    }
    
    public int palindrome(char arr[], int i, int j){
        int count = 0;
        while(i < j){
            if(arr[i] != arr[j]){
                count++;
            }
            i++;
            j--;
        }
        return count;
    }
}