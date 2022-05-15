// https://leetcode.com/problems/rotate-array

class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        if(k % n == 0) return;
        k = k % n;
        int temp[] = new int[k];
        for(int i=0;i<n;i++){
            if(k-i-1 >= 0) temp[k-i-1] = arr[n-i-1];
            // System.out.println(i + " " + (n-i-k-1) + " " + (n-i-1));
            arr[n-i-1] = n-i-k-1 >= 0 ? arr[n-i-k-1] : temp[n-i-1];
        }
    }
}