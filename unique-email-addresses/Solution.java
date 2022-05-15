// https://leetcode.com/problems/unique-email-addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String str: emails){
            String email = uniqueEmail(str);
            // System.out.println(email);
            set.add(email);
        }
        return set.size();
    }
    
    public String uniqueEmail(String str){
        String s[] = str.split("@");
        StringBuilder sb = new StringBuilder();
        for(char ch: s[0].toCharArray()){
            if(ch == '+') break;
            
            if(ch != '.') sb.append(ch);
        }
        sb.append("@");
        sb.append(s[1]);
        return sb.toString();
    }
}