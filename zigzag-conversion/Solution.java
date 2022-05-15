// https://leetcode.com/problems/zigzag-conversion

class Solution {
    public String convert(String s, int r) {
        if(r == 1){
            return s;
        }
        
        int j=0;
        int n = s.length();
        char ans[] = new char[n];
        
        for(int i=0;i<n;i+=2*(r-1)){
            ans[j] = s.charAt(i);
            j++;
        }
        
        for(int i=1;i<r-1;i++){
            boolean bool = true;
            int k = i;
            while(k < n){
                ans[j] = s.charAt(k);
                
                if(bool){
                    k += 2 * (r - i - 1);
                }else{
                    k += 2 * i;
                }
                j++;
                bool = !bool;
            }
        }
        
        for(int i=r-1;i<n;i+=2*(r-1)){
            ans[j] = s.charAt(i);
            j++;
        }
        
        String str = new String(ans);
        return str;
    }
}