/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardGame.Models;

import java.util.HashMap;

/**
 *
 * @author Rei
 */
public class BoardXO {
    private String[][] board;
    private int p1Score;    
    private int p2Score;
    private int tieScore;
    private int turn;
     
    public BoardXO(){
       this.board = createBoard();
       this.p1Score=0;
       this.p2Score=0;
       this.tieScore=0;
       this.turn=0;
    }
    
    public String[][] createBoard() {
        String[][] newBoard = new String[3][3];
        return newBoard;
    }

    public HashMap playerPlayAtPosition(String position){
        HashMap<String,Object> playerPlayMap = new HashMap<>();
        int rowIndex = Integer.parseInt(position.substring(1, 2)) - 1;
        int columnIndex = Integer.parseInt(position.substring(4)) - 1;
        
        playerPlayMap.put("row", rowIndex);
        playerPlayMap.put("column", columnIndex);
        if(turn % 2 == 0){
            playerPlayMap.put("symbol", "x");
        }else{
            playerPlayMap.put("symbol", "o");
        }
        return playerPlayMap;
    }
    
    public boolean checkPositionInBoardIsEmpty(int row, int column){
        Boolean result = false;
        if(board[row][column] == null){
            result = true;
        }
        return result;
    }
    
    public void play(int playAtRow, int playAtColumn, String playSymbol) {
        board[playAtRow][playAtColumn] = playSymbol;
        turn++;
    }
    
    public boolean checkTurnFive(){
        return (this.turn >= 5);
    }
    
    public boolean checkColumn(int col,String symbol) {
        int num =col==2?1:col++;
        boolean isWin = false;
        for(int row=0;row<3;row++){
            
            if(board[row][col]==null){
                break;
            }
            if((board[0][col].equals(board[1][col]))&& (board[2][col].equals(board[1][col]))&& (board[0][col].equals(board[2][col]))){
                isWin = true;
            } else {
                break;
            }
        }
        return isWin;
    }
    
    public boolean checkRow(int row,String symbol) {
        int num =row==2?1:row++;
        boolean isWin = false;
        for(int col=0;col<3;col++){
            
            if(board[row][col]==null){
                break;
            }
            if((board[row][0].equals(board[row][1]))&& (board[row][2].equals(board[row][1]))&& (board[row][0].equals(board[row][2]))){
                isWin = true;
            } else {
                break;
            }
        }
        return isWin;
        
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public int getP1Score() {
        return p1Score;
    }

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    public int getTieScore() {
        return tieScore;
    }

    public void setTieScore(int tieScore) {
        this.tieScore = tieScore;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
 
}
