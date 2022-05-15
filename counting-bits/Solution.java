// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        ArrayList<Integer> bits = new ArrayList<>();
        bits.add(0);
        for(int i=0;i<=n;i++){
            ans[i] = count(bits);
            bits = add(bits, 1);
        }
        return ans;
    }
    
    public ArrayList<Integer> add(ArrayList<Integer> bits, int carry){
        for(int i=0;i<bits.size();i++){
            int val = bits.get(i) + carry;
            if(val > 1){
                carry = 1;
                val = 0;
            }else{
                carry = 0;
            }
            bits.set(i, val);
        }
        if(carry == 1) bits.add(carry);
        return bits;
    }
    
    public int count(ArrayList<Integer> bits){
        int count = 0;
        for(int b: bits) if(b == 1) count++;
        return count;
    }
}