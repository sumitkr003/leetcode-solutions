// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int diff[] = new int[n + n - 1];
        int count = 0;
        for(int i=0;i<n;i++){
            diff[i] = gas[i] - cost[i];
            count += diff[i];
        }
        
        if(count < 0){
            return -1;
        }
        
        for(int i=n;i<2*n - 1;i++){
            diff[i] = gas[i % n] - cost[i % n];
        }
        
        for(int i=1;i<diff.length;i++){
            if(diff[i-1] >= 0){
                diff[i] = diff[i] + diff[i-1];
            }
        }
        
        for(int val: diff){
            System.out.print(val + " ");
        }
        
        int i = 2 * n - 2;
        int j = i;
        while(i >= 0){
            if(diff[i] >= 0){
                j = i;
            }else{
                break;
            }
            i--;
        }
        
        return j % n;
    }
}