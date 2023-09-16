package leetcode.dfs;

class NumberIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        System.out.println(String.format("i=%s,j=%s", i,j));
        for (char[] arr : grid) {
            for(char c : arr) {
                System.out.print(c + ",");
            }
            System.out.println();
        }
        System.out.println("\n");
        if(i < 0 || j < 0 
        || i >= grid.length  || j >= grid[0].length
        || grid[i][j] == '0'  || grid[i][j] == '2') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        NumberIslands nil = new NumberIslands();
        char[][] grid =new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(nil.numIslands(grid));
    }
}