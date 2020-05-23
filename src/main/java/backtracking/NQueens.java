package backtracking;

import java.util.Arrays;

public class NQueens {
    static int N = 8;
    public static void main(String[] args) {
        char[][] board =new char[N][N];
        for( char[] row : board){
            Arrays.fill(row, '.');
        }

        NQueens nQueens = new NQueens();
        nQueens.display(board);
        nQueens.nQueensProblem(board,0);
    }

    private void nQueensProblem(char[][] board, int colIndex){
        if(colIndex==N){
            System.out.println("\nNQueens Solution found.");
            display(board);
            return;
        }

//        display(board);

        for(int i=0; i<N; i++){
            if(isValid(board,i,colIndex)){
                board[i][colIndex]='Q';
                nQueensProblem(board, colIndex+1);
                //Backtracking
                board[i][colIndex]='.';
            }
        }
    }

    private void display(char[][] board){
        System.out.print("\nCurrent board:");
        for(char[] row: board){
            System.out.print("\n");
            for(char col:row){
                System.out.print("\t"+col);
            }
        }
    }

    private boolean isValid(char[][] board, int x, int y){

        for(int i=0; i< N; i++){
            if((board[x][i]=='Q') || (board[i][y]=='Q')){
                return false;
            }
            if((x+i)<N && (y+i)<N){
                if(board[x+i][y+i]=='Q'){
                    return false;
                }
            }
            if((x-i)>=0 && (y-i)>=0){
                if(board[x-i][y-i]=='Q'){
                    return false;
                }
            }
            if((x+i)<N && (y-i)>=0){
                if(board[x+i][y-i]=='Q'){
                    return false;
                }
            }
            if((x-i)>=0 && (y+i)<N){
                if(board[x-i][y+i]=='Q'){
                    return false;
                }
            }
        }
        return true;
    }
}
