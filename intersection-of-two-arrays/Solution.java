// https://leetcode.com/problems/intersection-of-two-arrays

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                if(ans.size() == 0 || ans.get(ans.size() - 1) != nums1[i]) ans.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]) j++;
            else i++;
        }
        
        int val[] = new int[ans.size()];
        for(i=0;i<val.length;i++) val[i] = ans.get(i);
        return val;
    }
}