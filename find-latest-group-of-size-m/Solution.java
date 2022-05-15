// https://leetcode.com/problems/find-latest-group-of-size-m

class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        int ans = -1;
        int count[] = new int[n + 2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int idx = arr[i];
            int leftCount = count[idx-1];
            int rightCount = count[idx + 1];
            count[idx + rightCount] = leftCount + rightCount + 1;
            count[idx - leftCount] = leftCount + rightCount + 1;
            
            if(map.containsKey(leftCount + rightCount + 1)){
                map.put(leftCount + rightCount + 1, map.get(leftCount + rightCount + 1) + 1);
            }else{
                map.put(leftCount + rightCount + 1, 1);
            }
            
            if(leftCount != 0){
                if(map.get(leftCount) == 0){
                    map.remove(leftCount);
                }else{
                    map.put(leftCount, map.get(leftCount) - 1);
                }
            }
            
            if(rightCount != 0){
                if(map.get(rightCount) == 0){
                    map.remove(rightCount);
                }else{
                    map.put(rightCount, map.get(rightCount) - 1);
                }
            }
            
            if(map.containsKey(m) && map.get(m) > 0){
                ans = i + 1;
            }
        }
        return ans;
    }
}