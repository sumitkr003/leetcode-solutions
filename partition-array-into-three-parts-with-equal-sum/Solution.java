// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for(int val: arr) sum += val;
        if(sum % 3 != 0) return false;
        
        int temp = sum/3 - arr[0];
        int i=1, j=arr.length - 2;
        while(i < arr.length && temp != 0){
            temp -= arr[i];
            i++;
        }
        
        temp = sum/3 - arr[arr.length - 1];
        while(j > i && temp != 0){
            temp -= arr[j];
            j--;
        }
        // System.out.println(i + " " + j + " " + temp + " " + sum/3);
        if(temp != 0 || i > j) return false;
        
        temp = sum/3;
        while(i <= j){
            temp -= arr[i];
            i++;
        }
        // System.out.println(i + " " + j + " " + temp + " " + sum/3);
        return temp == 0;
    }
}