// https://leetcode.com/problems/lru-cache

class LRUCache {
    int n = 0;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;
    
    public LRUCache(int capacity) {
        n = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	Node node = map.get(key);
        	
        	map.remove(key);
        	remove(node);

        	Node newNode = add(key, node.val);
        	map.put(key, newNode);
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
        	Node node = map.get(key);
        	map.remove(key);
            remove(node);
        }else if(map.size() == n){
            map.remove(head.key);
            remove(head);    
        }
        Node newNode = add(key, value);
        map.put(key, newNode);
    }
    
    public void remove(Node node){
        if(map.size() == 0){
            head = null;
            tail = null;
            return;
        }     
      
        if(node.prev == null){
            head = node.next;
            head.prev = null;
            node.next = null;
        }else if(node.next == null){
            tail = node.prev;
            tail.next = null;
            node.prev = null;
        }else{
            Node prev = node.prev;
            Node next = node.next;
            
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
        }
    }
    
    public Node add(int key, int val){
        Node newNode = new Node(key, val, null, null);
        if(head == null){
            head = newNode;
        }else{
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        return newNode;
    }
    
//     public static void main(String args[]) {
//     	LRUCache lru = new LRUCache(2);
//     	lru.put(2,1);
//     	lru.put(2,2);
//     	System.out.println(lru.get(2));
//     	lru.put(1,1);
// //    	System.out.println(lru.get(2));
//     	lru.put(4,1);
//     	System.out.println(lru.get(2));
// //    	System.out.println(lru.get(3));
// //    	System.out.println(lru.get(4));
//     }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    Node(int k, int v, Node p, Node n){
        this.key = k;
        this.val = v;
        this.prev = p;
        this.next = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */