class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        int arr[][] = new int[n][32];
        for(int i=0;i<n;i++){
            arr[i] = getBits(candidates[i]);
        }
        
        int ans = 0;
        for(int i=0;i<32;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(arr[j][i] == 1) count ++;
            }
            // System.out.println(i + " " + count);
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
    
    public int[] getBits(int num){
        int arr[] = new int[32];
        int index = 0;
        while(num > 0){
            int rem = num % 2;
            arr[index] = rem;
            num /= 2;
            index ++;
        }
        return arr;
    }
}