// https://leetcode.com/problems/gray-code

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int bits[] = new int[32];
        set.add(0);
        ans.add(0);
        int len = 1;
        solve(set, ans, bits, 1, n);
        return ans;
    }
    
    public void solve(HashSet<Integer> set,List<Integer> ans, int bits[], int len, int n){
        if(len > n) return;
        boolean flag = false;
        for(int i=0;i<len;i++){
            bits[i] = bits[i] == 0 ? 1 : 0;
            int val = toInteger(bits);
            if(!set.contains(val)){
                ans.add(val);
                set.add(val);
                flag = true;
                break;
            }else{
                bits[i] = bits[i] == 0 ? 1 : 0;
            }
        }
        
        solve(set, ans, bits, flag ? len : len + 1, n);
    }
    
    public int toInteger(int bits[]){
        int num = 0, pow = 1;
        for(int bit: bits){
            num += pow * bit;
            pow = pow * 2;
        }
        return num;
    }
}