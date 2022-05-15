// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            if(i == 0 || (arr[i] != arr[i-1])){
                int j=i+1, k=n-1;
                while(j < k){
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        ans.add(temp);
                        j++;
                        k--;
                        for(;j<n;j++){
                            if(arr[j] != arr[j-1]){
                                break;   
                            }
                        }
                        
                        for(;k>=0;k--){
                            if(arr[k] != arr[k+1]){
                                break;
                            }
                        }
                    }else if(sum > 0){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
        
        return ans;
    }
}