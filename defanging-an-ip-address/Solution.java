// https://leetcode.com/problems/defanging-an-ip-address

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        for(char c: address.toCharArray()){
            if(c == '.') str.append("[" + c + "]");
            else str.append(c);
        }
        return str.toString();
    }
}