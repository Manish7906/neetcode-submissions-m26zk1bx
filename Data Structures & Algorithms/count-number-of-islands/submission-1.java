class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c]=='1'){
                    count++;
                    Queue<int[]> queue=new LinkedList<>();
                    queue.offer(new int[]{r,c});
                    grid[r][c]='0';
                    while(!queue.isEmpty()){
                        int[] curr=queue.poll();
                        int row=curr[0];
                        int col=curr[1];
                        for(int[]  dir:directions){
                            int nr=row+dir[0];
                            int nc=col+dir[1];
                            if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]=='1'){
                                queue.offer(new int[]{nr, nc});
                                grid[nr][nc]='0';
                            }
                        }
                    }
                }
            }
        } 
        return count;   
    }
}
/*
Short BFS Logic

Loop all cells: grid[r][c]

If '1':

count++ → new island

Add (r,c) to queue → mark '0'

While queue not empty:

Poll (row,col)

Explore 4 directions (up, down, left, right)

If neighbor '1' → add to queue → mark '0'
  
  
   | Explanation Step           | Code Line                                                                  |
| -------------------------- | -------------------------------------------------------------------------- |
| Poll `(0,0)` from queue    | `int[] curr = queue.poll();`                                               |
| Explore 4 directions       | `for (int[] dir : directions)`                                             |
| Check if neighbor is valid | `if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1')` |
| Add neighbor to queue      | `queue.offer(new int[]{nr, nc});`                                          |
| Mark neighbor visited      | `grid[nr][nc] = '0';`  
                                                    |
*/
