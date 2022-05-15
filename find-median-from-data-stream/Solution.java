// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int median;
    
    public MedianFinder() {
        min = new PriorityQueue<>((a, b) -> b - a);
        max = new PriorityQueue<>();
        median = Integer.MIN_VALUE;
    }
    
    public void addNum(int num) {
        if(min.size() == 0 && max.size() == 0 && median == Integer.MIN_VALUE){
            median = num;
        }else if(num > median){
            max.add(num);
        }else if(num < median){
            min.add(num);
        }else if(min.size() > max.size()){
            max.add(num);
        }else{
            min.add(num);
        }
        // median = findMedian();
        
        if(Math.abs(min.size() - max.size()) > 1){
            if(min.size() > max.size()){
                max.add(median);
                median = min.remove();
            }else{
                min.add(median);
                median = max.remove();
            }
        }
        
        // System.out.println(min.size() + " " + max.size());
    }
    
    public double findMedian() {
        if(min.size() == max.size()){
            return median;
        }else{
            double newMedian = median;
            newMedian += min.size() > max.size() ? min.peek() : max.peek();
            return newMedian / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */