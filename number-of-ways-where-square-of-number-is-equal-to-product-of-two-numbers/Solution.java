// https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers

class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = 0;
        ans += solve(nums1, nums2);
        // System.out.println(ans);
        ans += solve(nums2, nums1);
        return ans;
    }
    
    public int solve(int nums1[], int nums2[]){
        int ans = 0;
        
        for(int i=0;i<nums1.length;i++){
            int j=0, k=nums2.length-1;
            while(j < k){
                // System.out.println(i + " " + j + " " + k);
                if((long)nums1[i] * (long)nums1[i] == (long)nums2[j] * (long)nums2[k]){
                    if(nums2[j] == nums2[k]){
                        int f = moveIndex(j+1, nums2[j], nums2, true) - j;
                        j += f;
                        ans += (f * (f-1)) / 2;
                    }else{
                        int f = moveIndex(j+1, nums2[j], nums2, true) - j;
                        j += f;
                        int s = k - moveIndex(k-1, nums2[k], nums2, false);
                        k -= s;
                        ans += f * s;
                    }
                }else if((long)nums1[i] * (long)nums1[i] > (long)nums2[j] * (long)nums2[k]){
                    j++;
                }else{
                    k--;
                }
            }
            
        }
        
        return ans;
    }
    
    public int moveIndex(int i,int val, int arr[], boolean bool){
        while(i < arr.length){
            if(arr[i] != val){
                return i;
            }
            i = bool ? i + 1 : i - 1;
        }
        return i;
    }
}