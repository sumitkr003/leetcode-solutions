// https://leetcode.com/problems/prison-cells-after-n-days

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<n;i++){
            int next[] = nextDay(cells);
            if(!set.contains(Arrays.toString(next))){
                count ++;
                set.add(Arrays.toString(next));
            }
            else break;
            cells = next;
        }
        
        if(count == n) return cells;
        n = n % count;
        System.out.println(count + " " + n);
        
        for(int i=0;i<n;i++) cells = nextDay(cells);
        return cells;
    }
    
    public int[] nextDay(int cells[]){
        int next[] = new int[cells.length];
        for(int i=0;i<next.length;i++){
            if(i == 0 || i == next.length - 1){
                next[i] = 0;
                continue;
            }
            next[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return next;
    }
}