// https://leetcode.com/problems/implement-trie-prefix-tree

class Trie {
    public class Node{
        boolean eow;
        Node children[];
        
        Node(){
            this.eow = false;
            this.children = new Node[26];
        }
    }
    
    public Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null) curr.children[ch - 'a'] = new Node(); 
            curr = curr.children[ch - 'a'];
            if(i == word.length() - 1) curr.eow = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = traverse(word);
        return curr == null ? false : curr.eow;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }
    
    public Node traverse(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null) return null; 
            curr = curr.children[ch - 'a'];
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */