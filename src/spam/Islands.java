package spam;

public class Islands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j ++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i , int j) {
        if(i < 0 || i > grid.length) return;
        if(j < 0 || j > grid[0].length) return;
        if(grid[i][j] == '0') return;
        if(grid[i][j] == '2') return;
        if(grid[i][j] == '1') grid[i][j] = '2';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
