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
    public void CreateBoard(){
        BoardXO board = new BoardXO();
        String[][] expBoard = new String [3][3];
//        assertNotNull(board);
        assertEquals(expBoard, board.createBoard());
    }
    
    @Test 
    public void BoardSetStart(){
        BoardXO board =new BoardXO();
        assertEquals(0, board.getP1Score());
        assertEquals(0,board.getP2Score());
        assertEquals(0,board.getTieScore());
    }
    
    @Test 
    public void selectPositionToPlayTest(){
        BoardXO board = new BoardXO();
        String row = "0";
        String col = "2";
        assertTrue(!board.selectPositionToPlay(row, col).values().isEmpty());
    }
    
    @Test
    public void boxEmptyTest(){
        BoardXO board = new BoardXO();
        String[][] x = new String[3][3];
        x[1][0] = "x";
        board.setBoard(x);
        assertTrue("it not empty",board.boxIsEmpty(board.selectPositionToPlay("1","1"))); 
    }

}
