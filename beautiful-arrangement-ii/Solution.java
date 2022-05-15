// https://leetcode.com/problems/beautiful-arrangement-ii

class Solution {
    public int[] constructArray(int n, int k) {
        int ans[] = new int[n];
        boolean flag[] = new boolean[n + 1];
        Arrays.fill(flag, true);
        flag[0] = false;
        flag[1] = false;
        ans[0] = 1;
        int i = 1;
        int temp = k;
        
        for(i=1;i<n;i++){
            if(k == 0){
                break;
            }
            if(ans[i-1] - k > 0 && flag[ans[i-1] - k]){
                ans[i] = ans[i-1] - k;
                flag[ans[i-1] - k] = false;
            }else if(ans[i-1] + k <= n && flag[ans[i-1] + k]){
                ans[i] = ans[i-1] + k;
                flag[ans[i - 1] + k] = false;
            }
            k--;
        }
        
        // System.out.println(i);
        while(i < n){
            // System.out.println(i);
            for(k=1;k<=temp;k++){
                // System.out.println(k + " " +  flag[9]);
                if(ans[i-1] - k > 0 && flag[ans[i-1] - k]){
                    ans[i] = ans[i-1] - k;
                    flag[ans[i-1] - k] = false;
                    break;
                    // System.out.println(k + " " + flag[ans[i-1] - k]);
                }else if(ans[i-1] + k <= n && flag[ans[i-1] + k]){
                    ans[i] = ans[i-1] + k;
                    flag[ans[i - 1] + k] = false;
                    break;
                    // System.out.println(k + " " + flag[ans[i-1] + k]);
                }
            }
            i++;
        }
        
        return ans;
    }
}