// https://leetcode.com/problems/implement-queue-using-stacks

class MyQueue {
    
    Stack<Integer> remove;
    Stack<Integer> add;

    /** Initialize your data structure here. */
    public MyQueue() {
        remove = new Stack<>();
        add = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(remove.isEmpty()) remove.add(x);
        else add.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int val = remove.pop();
        if(remove.isEmpty()){
            while(!add.isEmpty()){
                remove.add(add.pop());
            }
        }
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
        return remove.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return remove.isEmpty() && add.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */