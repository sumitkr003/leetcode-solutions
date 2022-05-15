// https://leetcode.com/problems/image-overlap

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(A[i][j] == 1){
                    a.add(i * 100 + (j+1));
                }
                if(B[i][j] == 1){
                    b.add(i * 100 + (j+1));
                }
            }
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int val : a){
            for(int val2 : b){
                if(map.containsKey(val - val2)){
                    map.put(val - val2, map.get(val - val2) + 1);
                    max = Math.max(max, map.get(val - val2));
                }else{
                    map.put(val - val2, 1);
                    max = Math.max(max, 1);
                }
            }
        }
        
        return max;
    }
}