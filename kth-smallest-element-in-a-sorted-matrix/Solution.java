// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.num - b.num);
        int n = matrix.length;
        for(int i=0;i<n;i++){
            pq.add(new Node(matrix[0][i], 0, i));
        }
        
        while(k > 1){
            Node node = pq.poll();
            // System.out.println(node.num + " " + node.r + " " + node.c);
            if(node.r != n-1){
                pq.add(new Node(matrix[node.r + 1][node.c], node.r + 1, node.c));
            }
            k--;
        }
        
        return pq.poll().num;
    }
    
}

public class Node{
    int num, r, c;
    Node(int n, int i, int j){
        this.num = n;
        this.r = i;
        this.c = j;
    }
}