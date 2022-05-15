// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        
        for(int i=0;i<indices.length;i++){
            int r = indices[i][0];
            int c = indices[i][1];
            if(row.containsKey(r)){
                row.put(r, row.get(r) + 1);
            }else{
                row.put(r, 1);
            }
            
            if(col.containsKey(c)){
                col.put(c, col.get(c) + 1);
            }else{
                col.put(c, 1);
            }
        }
        
        int count = 0;
        for(int i=0;i<n;i++){
            int x = row.containsKey(i) ? row.get(i) : 0;
            for(int j=0;j<m;j++){
                int y = col.containsKey(j) ? col.get(j) : 0;
                // System.out.println((x + y));
                if((x + y) % 2  == 1){
                    count ++;
                }
            }
        }
        
        return count;
    }
}