// https://leetcode.com/problems/interval-list-intersections

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int i=0,j=0;
        while(i < firstList.length && j < secondList.length){
            int min = Math.max(firstList[i][0], secondList[j][0]);
            int max = Math.min(firstList[i][1], secondList[j][1]);
            
            if(min <= max){
                int temp[] = {min, max};
                ans.add(temp);
            }
            
            // System.out.println(min + " " + max + " " + i + " " + j);
            if(firstList[i][1] == max) i++;
            else j++;
        }
        
        int temp[][] = new int[ans.size()][];
        for(i=0;i<ans.size();i++){
            temp[i] = ans.get(i);
        }
        return temp;
    }
}