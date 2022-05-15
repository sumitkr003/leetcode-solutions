// https://leetcode.com/problems/capitalize-the-title

class Solution {
    public String capitalizeTitle(String title) {
        Boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(char ch: title.toCharArray()){
            if(flag){
                if(ch < 'A' || ch > 'Z'){
                    sb.append((char)(ch - 'a' + 'A'));
                }else{
                    sb.append(ch);
                }
            }else if(ch >= 'A' && ch <= 'Z'){
                sb.append((char)(ch + 'a' - 'A'));
            }else{
                sb.append(ch);
            }
            
            if(ch == ' ') flag = true;
            else flag = false;
        }
        
        String ans[] = sb.toString().split(" ");
        sb = new StringBuilder();
        
        for(int i=0;i<ans.length;i++){
            if(ans[i].length() < 3){
                char ch = ans[i].charAt(0);
                sb.append((char)(ch + 'a' - 'A'));
                sb.append(ans[i].substring(1));
            }else{
                sb.append(ans[i]);
            }
            
            if(i != ans.length-1){
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}