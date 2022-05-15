// https://leetcode.com/problems/reordered-power-of-2

class Solution {
    public boolean reorderedPowerOf2(int num) {
        int n = (num + "").length();
        int arr[] = new int[n];
        boolean bool[] = new boolean[n];
        HashSet<Integer> set = new HashSet<>();
        int pow = 1;
        
        while(pow < (int)(1e9+7)){
            set.add(pow);
            pow = pow * 2;
        }
        
        while(num > 0){
            arr[n-1] = num % 10;
            num = num / 10;
            n--;
        }
        
        // for(int val: arr) System.out.println(val);
        
        return solve(set, arr, bool, 0);
    }
    
    public boolean solve(HashSet<Integer> set, int arr[], boolean bool[], int num){
        // System.out.println(num);
        if((num + "").length() == arr.length && set.contains(num)) return true;
        
        for(int i=0;i<arr.length;i++){
            if(!bool[i]){
                bool[i] = true;
                if(solve(set, arr, bool, num * 10 + arr[i])) return true;
                bool[i] = false;
            }
        }
        
        return false;
    }
}