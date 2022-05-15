// https://leetcode.com/problems/remove-interval

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int interval[]: intervals){
            int a = interval[0];
            int b = interval[1];
            int x = toBeRemoved[0];
            int y = toBeRemoved[1];
            List<Integer> temp = new ArrayList<>();
            
            if(a >= y || b <= x){
                temp.add(a);
                temp.add(b);
                ans.add(temp);
            }else if(x <= a && y >= b){
                continue;
            }else if(a <= x && b >= y){
                int m = a;
                int n = x;
                if(m != n && n > m){
                    temp.add(m);
                    temp.add(n);
                    ans.add(temp);
                }
                
                temp = new ArrayList<>();
                m = y;
                n = b;
                if(m != n && n > m){
                    temp.add(m);
                    temp.add(n);
                    ans.add(temp);
                }
            }else if(a < x && y >= b){
                temp.add(a);
                temp.add(x);
                ans.add(temp);
            }else if(x <= a && b > y){
                temp.add(y);
                temp.add(b);
                ans.add(temp);
            }
        }
        
        return ans;
    }
}