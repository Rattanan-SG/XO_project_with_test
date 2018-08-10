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
       createBoard();
       this.p1Score=0;
       this.p2Score=0;
       this.tieScore=0;
       this.turn=0;
    }
    
    public void createBoard() {
        String[][] newBoard = new String[3][3];
        this.board =  newBoard;
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
    
    public boolean checkTurnNine(){
        return (this.turn == 9);
    }
    
    public boolean checkWinColumn(int lastPlayAtColumn,String lastPlaySymbol) {
        boolean isWin = false;
     
        for (int i = 0; i < 3; i++) {
            if(board[i][lastPlayAtColumn] == lastPlaySymbol){
                isWin = true;
            }else{
                isWin = false;
                break;
            }
        }
        return isWin;  
    }
    
    public boolean checkWinRow(int lastPlayAtRow, String lastPlaySymbol) {
        boolean isWin = false;
     
        for (int i = 0; i < 3; i++) {
            if(board[lastPlayAtRow][i] == lastPlaySymbol){
                isWin = true;
            }else{
                isWin = false;
                break;
            }
        }
        return isWin;  
    }
    
    public boolean checkWinDiagonally(String lastSymbol) {
        boolean isWin = false;
        if (board[1][1] != null && board[1][1] == lastSymbol) {
            if(board[0][0] == board[1][1] && board[2][2] == board[1][1]){
                isWin = true;
            }
            else if (board[0][2] == board[1][1] && board[2][0] == board[1][1]){
                isWin = true;
            }
        }
        return isWin;
    }
    
    public void increaseWinScore(){
        if(turn % 2 == 0){
            p2Score++;
        }else{
            p1Score++;
        }
        turn = 0;
    }
    
    public void increaseTieScore(){
        tieScore++;
        turn = 0;
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
