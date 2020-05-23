package backtracking;

public class RatinMaze {
    public static void main(String[] args) {
        int maze[][]={{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        RatinMaze obj = new RatinMaze();
        obj.pathExists(maze);

    }

    public void pathExists(int maze[][]){
        if(pathExistsUtil(maze,0,0)){
            System.out.println("Path exists till destination");
        }else{
            System.out.println("Sorry!!Path doesn't exist");
        }
    }

    public boolean pathExistsUtil(int maze[][],int i, int j){
        if(i<0 || i>=maze.length || j<0 || j>=maze[0].length || maze[i][j]==0){
            return false;
        }

        if(i==maze.length-1 && j==maze[0].length-1){
            return true;
        }

        if(pathExistsUtil(maze,i+1,j) || pathExistsUtil(maze,i,j+1)){
            return true;
        }

        return false;
    }
}
