// https://leetcode.com/problems/implement-stack-using-queues

class MyStack {
    Queue<Integer> q1;
    int top;
    
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        top = -1;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        while(q1.size() > 1){
            top = q1.remove(); 
            temp.add(top);
        }
        int val = q1.remove();
        q1 = temp;
        return val;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */