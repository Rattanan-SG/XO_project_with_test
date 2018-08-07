package BoardGame.Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BoardGame.Models.BoardXO;
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
public class CheckWinTest {
    
    public CheckWinTest() {
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
    public void enableToCheckColumn(){
        BoardXO board=new BoardXO();   
           String[][] gg = new String[3][3];
           gg[0][2]="X";
           gg[1][2]="X";
           gg[2][2]="X";
           board.setBoard(gg);
        assertTrue(board.checkColumn(2,"X"));
        
    }
    
    @Test
    public void enableToCheckRow(){
        BoardXO board=new BoardXO();   
           String[][] gg = new String[3][3];
           gg[2][0]="X";
           gg[2][1]="X";
           gg[2][2]="X";
           board.setBoard(gg);
        assertTrue(board.checkRow(2,"X"));
        
    }
    
    @Test
    public void checkTurnIsViable(){
        BoardXO board = new BoardXO();
        assertFalse(board.checkTurn());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
