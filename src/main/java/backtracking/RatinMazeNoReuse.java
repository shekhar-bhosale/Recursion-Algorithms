package backtracking;

/**
 * This code checks if path exists from source to destination without stepping same block again
 */
public class RatinMazeNoReuse {

    public static void main(String[] args) {
        int maze[][]={{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 0, 1}};
        RatinMazeNoReuse obj = new RatinMazeNoReuse();
        obj.pathExists(maze);

    }

    public void pathExists(int maze[][]){
        boolean visited[][]=new boolean[maze.length][maze[0].length];

        if(pathExistsUtil(maze,0,0,visited)){
            System.out.println("Path exists till destination");
        }else{
            System.out.println("Sorry!!Path doesn't exist");
        }
    }

    private boolean safecheck(int maze[][],int i, int j,boolean visited[][]){
        if(i<0 || i>=maze.length || j<0 || j>=maze[0].length || maze[i][j]==0 || visited[i][j]){
            return false;
        }else{
            return true;
        }
    }

    private boolean pathExistsUtil(int maze[][],int i, int j,boolean visited[][]){

        if(!safecheck(maze,i,j,visited)){
            return false;
        }

        if(i==maze.length-1 && j==maze[0].length-1){
            return true;
        }

        visited[i][j]=true;

        if(pathExistsUtil(maze,i+1,j,visited) || pathExistsUtil(maze,i,j+1,visited)){
            return true;
        }

        visited[i][j] = false;

        return false;
    }
}
