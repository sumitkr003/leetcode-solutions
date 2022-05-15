// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int max = max(end);
        int n = start.length;
        int dp[] = new int[max + 1];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int e = end[i];
            ArrayList<Integer> temp = new ArrayList<>();
            
            if(map.containsKey(e)){
                temp = map.get(e);
            }
            
            
            temp.add(i);
            map.put(e, temp);
        }
        
        
        for(int i=1;i<=max;i++){
            
            if(map.containsKey(i)){
                ArrayList<Integer> idxs = map.get(i);
                for(int j: idxs){
                    int s = start[j];
                    int p = profit[j];
                    
                    dp[i] = Math.max(Math.max(dp[i-1], dp[i]), dp[s] + p);
                    // if(i == 48){
                    //     System.out.println(s + " " + p + " " + (dp[s] + p) + " " + dp[i-1] + " " + dp[i]);
                    // }
                }
            }else{
                dp[i] = dp[i-1];
            }
            
        }
        
        // System.out.println("-----");
        // int j = 0;
        // for(int val: dp){
        //     System.out.println(j + " " + val + " ");
        //     j ++;
        // }
        
        return dp[max];
    }
    
    public int max(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int val: arr){
            max = val > max ? val : max;
        }
        return max;
    }
}