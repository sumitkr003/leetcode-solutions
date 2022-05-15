// https://leetcode.com/problems/circular-permutation-in-binary-representation

class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        HashSet<Integer> map = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        map.add(start);
        ans.add(start);
        
        int binary[] = toBinary(start, n);
        int max = (int)Math.pow(2, n);
        while(max > 0){
            for(int i=0;i<n;i++){
                binary[i] = 1 - binary[i];
                int num = toInteger(binary);
                if(!map.contains(num)){
                    ans.add(num);
                    map.add(num);
                    break;
                }else{
                    binary[i] = 1 - binary[i];
                }
            }
            max --;
        }
        
        return ans;
    }
    
    public int[] toBinary(int val, int n){
        int ans[] = new int[n];
        int idx = 0;
        
        while(val > 0){
            int rem = val % 2;
            val = val / 2;
            ans[idx] = rem;
            idx++;
        }
        
        while(ans.length < n && idx < n){
            ans[idx] = 0;
            idx++;
        }
        return ans;
    }
    
    public int toInteger(int[] binary){
        int val = 0;
        int p = 1;
        
        for(int b: binary){
            val += b * p;
            p = p * 2;
        }
        
        return val;
    }
}