/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardGame.Tests;

import BoardGame.Models.BoardXO;
import java.util.HashMap;
import javafx.print.Collation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rei
 */
public class EntityTest {
    
    public EntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void checkCreateBoard(){
        BoardXO board = new BoardXO();
        String[][] expectBoard = new String [3][3];
        assertArrayEquals(expectBoard, board.getBoard());
    }

    @Test
    public void checkPlayerPlayAtPosition(){
        String playerPlayAtPosition = "R3_C1";
        int expectRow = Integer.parseInt(playerPlayAtPosition.substring(1, 2)) - 1;
        int expectColumn = Integer.parseInt(playerPlayAtPosition.substring(4)) - 1;
        int playTurn = 1;
        String expectSymbol = playTurn % 2 == 0 ? "x" : "o";
        
        BoardXO board = new BoardXO();
        board.setTurn(playTurn);
        HashMap playMap = board.playerPlayAtPosition(playerPlayAtPosition);

        assertEquals(expectRow, playMap.get("row"));
        assertEquals(expectColumn, playMap.get("column"));
        assertEquals(expectSymbol, playMap.get("symbol"));

    }
    
    @Test
    public void checkPlay(){
        BoardXO board = new BoardXO();
        int playAtRow = 0;
        int playAtColumn = 2;
        int playTurn = 6;
        String expectSymbol = playTurn % 2 == 0 ? "x" : "o";
        
        board.setTurn(playTurn);
        
        board.play(playAtRow, playAtColumn, expectSymbol);
        assertEquals(expectSymbol, board.getBoard()[playAtRow][playAtColumn]);
        assertEquals(playTurn + 1, board.getTurn());
    }
    
    @Test
    public void checkTurnFive(){
        BoardXO board = new BoardXO();
        int playTurn = 5;
        board.setTurn(playTurn);    
        assertTrue("Turn < 5",board.checkTurnFive());
    }
    
    @Test
    public void winRow(){
        BoardXO board = new BoardXO();
        String[][] exBoard = board.getBoard();
//        for (int i = 0; i < 3; i++) {
//            exBoard[0][i] = "o";
//        }
        exBoard[1][0] = "x";
        exBoard[1][1] = "x";
        exBoard[1][2] = "x";
        
        int lastRow = 1;
        String lastSymbol = "x";
        
        assertEquals(true, board.checkWinRow(lastRow, lastSymbol));
    }
    
    @Test
    public void winColumn(){
        BoardXO board = new BoardXO();
        String[][] exBoard = board.getBoard();
//        for (int i = 0; i < 3; i++) {
//            exBoard[i][0] = "o";
//        }
        exBoard[0][0] = "x";
        exBoard[1][0] = "x";
        exBoard[2][0] = "x";
        
        int lastColumn = 0;
        String lastSymbol = "x";
        
        assertEquals(true, board.checkWinColumn(lastColumn, lastSymbol));
    }
    
    @Test
    public void winDiagonally(){
        BoardXO board = new BoardXO();
        String[][] exBoard = board.getBoard();
//        for (int i = 0; i < 3; i++) {
//            exBoard[i][0] = "o";
//        }
        exBoard[0][0] = "x";
        exBoard[1][1] = "x";
        exBoard[2][2] = "x";
        exBoard[0][2] = "o";
        exBoard[2][0] = "o";
        

        String lastSymbol = "x";
        
        assertEquals(true, board.checkWinDiagonally(lastSymbol));
    }
}
