// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        return solve(digits, 0);
    }
    
    public List<String> solve(String digits, int i){
        if(i == digits.length()){
            List<String> l = new ArrayList<>();
            l.add("");
            return l;
        }
        
        List<Character> l = characters(digits.charAt(i));
        List<String> prev = solve(digits, i+1);
        List<String> ans = new ArrayList<>();
        
        for(Character ch: l){
            for(String s: prev){
                ans.add("" + ch + s);
            }
        }
        
        return ans;
    }
    
    public List<Character> characters(char n){
        List<Character> l = new ArrayList<>();
        if(n == '2'){
            l.add('a');
            l.add('b');
            l.add('c');
        }else if(n == '3'){
            l.add('d');
            l.add('e');
            l.add('f');
        }else if(n == '4'){
            l.add('g');
            l.add('h');
            l.add('i');
        }else if(n == '5'){
            l.add('j');
            l.add('k');
            l.add('l');
        }else if(n == '6'){
            l.add('m');
            l.add('n');
            l.add('o');
        }else if(n == '7'){
            l.add('p');
            l.add('q');
            l.add('r');
            l.add('s');
        }else if(n == '8'){
            l.add('t');
            l.add('u');
            l.add('v');
        }else if(n == '9'){
            l.add('w');
            l.add('x');
            l.add('y');
            l.add('z');
        }
        return l;
    } 
}