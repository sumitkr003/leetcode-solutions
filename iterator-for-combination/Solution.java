// https://leetcode.com/problems/iterator-for-combination

class CombinationIterator {
    private char arr[];
    private int indexes[];
    private int len, n;
    private boolean hasNext = true;
    
    public CombinationIterator(String str, int combinationLength) {
        arr = str.toCharArray();
        indexes = new int[combinationLength];
        for(int i=0;i<combinationLength;i++){
            indexes[i] = i;
        }
        n = arr.length;
        len = combinationLength;
        Arrays.sort(arr);
    }
    
    public String next() {
        StringBuilder sb = new StringBuilder();
        if(hasNext()){
            for(int i=0;i<len;i++){
                sb.append(arr[indexes[i]]);
            }
        }
        
        int i = len - 1;
        while(i >= 0){
            if(indexes[i] < n - (len - i)) break;
            i--;
        }
        
        hasNext = false;
        if(i < 0) return sb.toString();
        hasNext = true;
        
        indexes[i]++;
        i++;
        while(i < len){
            indexes[i] = indexes[i-1] + 1;
            i++;
        }
        return sb.toString();
    }
    
    public boolean hasNext() {
        return hasNext;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */