// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        for(int i=0;i<=hi;i++){
            if(arr[i] == 0){
                // System.out.println(i + " " + lo + " " + arr[lo]);
                arr[i] = arr[lo];
                arr[lo] = 0;
                lo ++;
            }else if(arr[i] == 2) {
                arr[i] = arr[hi];
                arr[hi] = 2;
                hi--;
                i--;
            }
            
            while(lo <= i && arr[lo] == 0) lo ++;
            while(hi > i && arr[hi] == 2) hi --;
        }
    }
}