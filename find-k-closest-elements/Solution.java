// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int i=n-1,j=n;
        List<Integer> ans = new ArrayList<>();
        for(i=0;i<n;i++){
            if(arr[i] >= x){
                j = i;
                break;
            }
        }
        
        i--;
        while(i >= 0 && j < n && k > 0){
            // System.out.println((x - arr[i]) + " " + (arr[j] - x) + " " + i + " " + j);
            if(x - arr[i] <= arr[j] - x){
                ans.add(arr[i]);
                i--;
            }else{
                ans.add(arr[j]);
                j++;
            }
            k--;
        }
        
        while(i >= 0 && k > 0){
            ans.add(arr[i]);
            i--;
            k--;
        }
        
        while(j < n && k > 0){
            ans.add(arr[j]);
            j++;
            k--;
        }
        
        Collections.sort(ans);        
        return ans;
    }
}