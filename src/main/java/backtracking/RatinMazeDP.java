package backtracking;

import java.util.HashSet;
import java.util.Set;

class Point{
    int row,col;
    public Point(int i,int j){
        row =i;
        col =j;
    }
}

public class RatinMazeDP {

    public static void main(String[] args) {
        int maze[][]={{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        RatinMazeDP obj = new RatinMazeDP();
        obj.pathExists(maze);

    }

    public void pathExists(int maze[][]){
        Set<Point> failedPoints = new HashSet<>();
        if(pathExistsUtil(maze,0,0,failedPoints)){
            System.out.println("Path exists till destination");
        }else{
            System.out.println("Sorry!!Path doesn't exist");
        }
    }

    private boolean safecheck(int maze[][],int i, int j){
        if(i<0 || i>=maze.length || j<0 || j>=maze[0].length || maze[i][j]==0){
            return false;
        }else{
            return true;
        }
    }

    private boolean pathExistsUtil(int maze[][],int i, int j,Set<Point> failedPoints){
        if(!safecheck(maze,i,j)){
            return false;
        }

        Point current = new Point(i,j);
        if(failedPoints.contains(current)){
            return false;
        }

        if(i==maze.length-1 && j==maze[0].length-1){
            return true;
        }

        if(pathExistsUtil(maze,i+1,j,failedPoints) || pathExistsUtil(maze,i,j+1,failedPoints)){
            return true;
        }

        failedPoints.add(current);

        return false;
    }
}
