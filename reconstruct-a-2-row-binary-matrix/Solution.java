// https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> t = new ArrayList<>();
        ans.add(t);
        t = new ArrayList<>();
        ans.add(t);
        
        for(int i=0;i<n;i++){
            int s = colsum[i];
            List<Integer> temp = new ArrayList<>();
            if(s == 0){
                ans.get(0).add(0);
                ans.get(1).add(0);
            }else if(s == 2){
                ans.get(0).add(1);
                ans.get(1).add(1);
                upper --;
                lower --;
            }else{
                if(upper > lower){
                    ans.get(0).add(1);
                    ans.get(1).add(0);
                    upper --;
                }else{
                    ans.get(0).add(0);
                    ans.get(1).add(1);
                    lower --;
                }
            }  
        }
    
//         System.out.println(upper + " " + lower);
//         for(List<Integer> temp : ans){
//             for(int val: temp){
//                 System.out.print(val + " ");
//             }
//             System.out.println();
//         }
        
        if(upper != 0 || lower != 0){
           List<List<Integer>> temp = new ArrayList<>();
           return temp;
        }
        
        return ans;
    }
}