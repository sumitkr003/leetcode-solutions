// https://leetcode.com/problems/relative-sort-array

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val: arr2){
            map.put(val, 0);
        }
        
        for(int val: arr1){
            if(map.containsKey(val)){
                map.put(val, map.get(val) + 1);
            }
        }
        
        int ans[] = new int[arr1.length];
        int count = 0;
        for(int val: arr2){
            for(int i=0;i<map.get(val);i++){
                ans[count] = val;
                count ++;
            }
        }
        
        int j = count;
        for(int i=0;i<arr1.length;i++){
            if(!map.containsKey(arr1[i])){
                ans[count] = arr1[i];
                count ++;
            }
        }
        
        Arrays.sort(ans, j, ans.length);
        return ans;
    }
}