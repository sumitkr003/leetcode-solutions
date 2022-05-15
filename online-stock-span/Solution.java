// https://leetcode.com/problems/online-stock-span

class StockSpanner {
    Stack<Integer> stocks;
    Stack<Integer> days;
    int index;
    
    public StockSpanner() {
        stocks = new Stack();
        days = new Stack();
        index = 0;
    }
    
    public int next(int price) {
        while(!stocks.isEmpty() && stocks.peek() <= price){
            stocks.pop();
            days.pop();
        }
        int ans = stocks.isEmpty() ? index + 1 : index - days.peek() + 1;
        stocks.add(price);
        days.add(++index);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */