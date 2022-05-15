// https://leetcode.com/problems/maximum-frequency-stack

class FreqStack {
    private int index;
    private PriorityQueue<Node> frequencyQueue;
    private Map<Integer, Integer> numberFrequency;
    
    public FreqStack() {
        index = -1;
        numberFrequency = new HashMap<>();
        frequencyQueue = new PriorityQueue<>((a, b) -> {
            if(a.frequency == b.frequency) {
                return b.index - a.index;
            }

            return b.frequency - a.frequency;
        });
    }

    public void push(int x) {
        int frequency = numberFrequency.getOrDefault(x, 0);
        index++;
        Node node = new Node(x, frequency+1, index);
        numberFrequency.put(x, frequency+1);
        frequencyQueue.add(node);
    }

    public int pop() {
        Node node = frequencyQueue.remove();
        numberFrequency.put(node.val, node.frequency-1);
        //index--;
        return node.val;
    }
    
    class Node {
        int val, index, frequency;

        Node(int val, int frequency, int index) {
            this.val = val;
            this.frequency = frequency;
            this.index = index;
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */