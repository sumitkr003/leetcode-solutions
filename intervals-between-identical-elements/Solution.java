// https://leetcode.com/problems/intervals-between-identical-elements

class Solution {
    public long[] getDistances(int[] arr) {
        HashMap<Integer, long[]> map = new HashMap<>();
        int n = arr.length;
        long ans[] = new long[n];
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                long temp[] = map.get(arr[i]);
                long val = (long)(i - temp[2]) + temp[0] + (i - temp[2]) * (temp[1] - 1);
                map.put(arr[i], new long[]{val, temp[1] + 1, i});
                ans[i] += val;
                
                // System.out.println(arr[i] + " " + (i - temp[2]) + " " + temp[0] + " " + (i - temp[2]) + " " + (temp[1] - 1));
            }else{
                // System.out.println(arr[i] + " " + 0);
                // map has element -> (prevAnswer, freq of element, last index of element)
                map.put(arr[i], new long[]{0, 1, i});
            }
        }
        
        System.out.println("-------");
        map = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            if(map.containsKey(arr[i])){
                long temp[] = map.get(arr[i]);
                long val = (long)(temp[2] - i) + temp[0] + (temp[2] - i) * (temp[1] - 1);
                map.put(arr[i], new long[]{val, temp[1] + 1, i});
                ans[i] += val;
                
                // System.out.println(arr[i] + " " + (temp[2] - i) + " " + temp[0] + " " + (temp[2] - i) + " " + (temp[1] - 1));
            }else{
                // System.out.println(arr[i] + " " + 0);
                // map has element -> (prevAnswer, freq of element, last index of element)
                map.put(arr[i], new long[]{0, 1, i});
            }
        }
        
        return ans;
    }
}