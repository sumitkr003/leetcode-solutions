// https://leetcode.com/problems/intersection-of-two-arrays-ii

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val: nums1){
            if(map.containsKey(val)) map.put(val, map.get(val) + 1);
            else map.put(val, 1);
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int val: nums2){
            if(map.containsKey(val) && map.get(val) > 0){
                arr.add(val);
                map.put(val, map.get(val) - 1);
            }
        }
        
        int ans[] = new int[arr.size()];
        for(int i=0;i<arr.size();i++) ans[i] = arr.get(i);
        return ans;
    }
}