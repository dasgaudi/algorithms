package recursion;

/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
 */

class NumberOfIslands {
    static int numIslands(char[][] grid) {
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] != '1') {
            return ;
        }
        grid[i][j] = '0';

        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
    }
}

