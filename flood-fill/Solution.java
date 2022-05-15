// https://leetcode.com/problems/flood-fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor){
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    public void dfs(int image[][], int r, int c, int prevColor, int newColor){
        if(r < 0 || c < 0 || r == image.length || c == image[0].length){
            return;
        }
        
        System.out.println(r + " " + c + image[r][c]);
        
        image[r][c] = newColor;
        if(r-1 >= 0 && image[r-1][c] == prevColor){
            dfs(image, r-1, c, prevColor, newColor);
        }
        
        if(c-1 >= 0 && image[r][c-1] == prevColor){
            dfs(image, r, c-1, prevColor, newColor);
        }
        
        if(r+1 < image.length && image[r + 1][c] == prevColor){
            dfs(image, r+1, c, prevColor, newColor);
        }
        
        if(c+1 < image[0].length && image[r][c+1] == prevColor){
            dfs(image, r, c+1, prevColor, newColor);
        }
    }
}