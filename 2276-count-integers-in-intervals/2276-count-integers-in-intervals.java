class CountIntervals {
    TreeMap<Integer, Integer> map;
    int ans;
    
    public CountIntervals() {
        map = new TreeMap<>();
        ans = 0;
    }
    
    public void add(int left, int right) {
        var interval = map.floorEntry(left);
        if(interval == null || interval.getValue() < left){
            interval = map.higherEntry(left);
        }
        
        for(;interval != null && interval.getKey() <= right; interval = map.higherEntry(left)){
            left = Math.min(left, interval.getKey());
            right = Math.max(right, interval.getValue());
            ans -= interval.getValue() - interval.getKey() + 1;
            map.remove(interval.getKey());
        }
        
        map.put(left, right);
        ans += right - left + 1;
    }
    
    public int count() {
        return ans;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */