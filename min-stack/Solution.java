// https://leetcode.com/problems/min-stack

class MinStack {
    PriorityQueue<Integer> pq;
    Stack<Integer> st;
    /** initialize your data structure here. */
    public MinStack() {
        pq = new PriorityQueue<>();
        st = new Stack();
    }
    
    public void push(int val) {
        pq.add(val);
        st.push(val);
    }
    
    public void pop() {
        int val = st.pop();
        pq.remove(val);
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */