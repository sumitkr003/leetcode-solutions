// https://leetcode.com/problems/thousand-separator

class Solution {
    public String thousandSeparator(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(true){
            int mod = n % 10;
            arr.add(mod);
            n /= 10;
            if(n == 0){
                break;
            }
        }
        
        int mod = arr.size() % 3;
        String ans = "";
        for(int i=arr.size() -1;i>=0;i--){
            ans += arr.get(i);
            if((arr.size() - i) % 3 == mod && i != 0){
                ans += ".";
            }
        }
        return ans;
    }
}