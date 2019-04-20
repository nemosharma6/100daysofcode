/* https://leetcode.com/problems/sudoku-solver/ */
class Solution {
    
    boolean[][] row=new boolean[9][9];
    boolean[][] col=new boolean[9][9];
    boolean[][] sub=new boolean[9][9];
    boolean solved=false;
    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int ch=board[i][j]-'1';
                row[i][ch]=true;
                col[j][ch]=true;
                int box=getBox(i,j);
                sub[box][ch]=true;
            }
        }
        
        rec(board);
    }
    
    public boolean rec(char[][] b){
        
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                boolean in=false;
                if(b[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        int box=getBox(i,j);
                        int n=k-'1';
                        if(!row[i][n] && !col[j][n] && !sub[box][n]){
                            in=true;
                            b[i][j]=k;
                            row[i][n]=col[j][n]=sub[box][n]=true;
                            boolean st=rec(b);
                            if(st) return st;
                            b[i][j]='.';
                            row[i][n]=col[j][n]=sub[box][n]=false;
                        } 
                    }
                    
                    return false;
                }
            }
        
        return true;
    }
    
    public int getBox(int i, int j){
        if(i>=0 && i<3 && j>=0 && j<3) return 0;
        else if(i>=0 && i<3 && j>=3 && j<6) return 1;
        else if(i>=0 && i<3 && j>=6 && j<9) return 2;
        else if(i>=3 && i<6 && j>=0 && j<3) return 3;
        else if(i>=3 && i<6 && j>=3 && j<6) return 4;
        else if(i>=3 && i<6 && j>=6 && j<9) return 5;
        else if(i>=6 && i<9 && j>=0 && j<3) return 6;
        else if(i>=6 && i<9 && j>=3 && j<6) return 7;
        else if(i>=6 && i<9 && j>=6 && j<9) return 8;
        return -1;
    }
}
